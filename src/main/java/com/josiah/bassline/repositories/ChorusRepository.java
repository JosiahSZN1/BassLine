package com.josiah.bassline.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.josiah.bassline.models.Chorus;

public interface ChorusRepository extends CrudRepository<Chorus, Long> {

	List<Chorus> findAll();
}
