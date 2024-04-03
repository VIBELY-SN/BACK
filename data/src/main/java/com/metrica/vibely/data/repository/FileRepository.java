package com.metrica.vibely.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrica.vibely.data.entity.File;

public interface FileRepository extends JpaRepository<File, UUID>{
	
	/**
	 * @param filename
	 * @return list of files
	 * @throws NoSuchElementException
	 */
	List<File> findAllByUploader(UUID id);
	
}
