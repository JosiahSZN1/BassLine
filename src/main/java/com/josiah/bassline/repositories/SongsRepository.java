package com.josiah.bassline.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.josiah.bassline.models.Song;

public interface SongsRepository extends CrudRepository<Song, Long> {

	List<Song> findAll();
}
