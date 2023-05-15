package com.josiah.bassline.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.josiah.bassline.models.LoginUser;
import com.josiah.bassline.models.User;
import com.josiah.bassline.repositories.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepo;
	
	public User createOrUpdateUser(User u) {
		return usersRepo.save(u);
	}
	
    public User register(User newUser, BindingResult result) {
    	Optional<User>potentialUser = usersRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
        	result.rejectValue("email", "Matches", "Email already taken.");
        }
    	String passwordEntered = newUser.getPassword();
    	if(!passwordEntered.equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	if(result.hasErrors()) {
    	    return null;
    	}
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return usersRepo.save(newUser);
       
    }
	
    public User login(LoginUser loginUser, BindingResult result) {
    	Optional<User>potentialUser = usersRepo.findByEmail(loginUser.getEmail());
        if(!potentialUser.isPresent()) {
        	result.rejectValue("email", "Matches", "Email does not match any reocrds");
        	return null;
        }
        User foundUser = potentialUser.get();
        
 
        if(!BCrypt.checkpw(loginUser.getPassword(), foundUser.getPassword())) {
        	result.rejectValue("password", "Matches", "Incorrect password");
        }
        if(result.hasErrors()) {
        	return null;
        }
        return foundUser;
    }
    
	public User findUser(Long id) {
		Optional<User> potentialUser = usersRepo.findById(id);
		if(potentialUser.isPresent()) {
			return potentialUser.get();
		} else {
			return null;
		}
	}
	
	public List<User> findAll() {
		return usersRepo.findAll();
	}
	
	public void deleteUser(Long id) {
		usersRepo.deleteById(id);
	}
}
