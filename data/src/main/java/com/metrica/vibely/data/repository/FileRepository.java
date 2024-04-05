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
	@Query("SELECT file_id FROM Uploaded_files WHERE uploader =: id")
	List<File> findAllByUploader(UUID id);
	
}
