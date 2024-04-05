package com.metrica.vibely.data.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metrica.vibely.data.entity.File;

public interface FileRepository extends JpaRepository<File, UUID>{
	
	/**
	 * @param filename
	 * @return list of files
	 * @throws NoSuchElementException
	 */
	@Query("SELECT a FROM File a WHERE a.uploader =:id")
	List<File> findAllByUploader(UUID id);
	
}
