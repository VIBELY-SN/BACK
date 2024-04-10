package com.metrica.vibely.data.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metrica.vibely.data.entity.File;

public interface FileRepository extends JpaRepository<File, UUID>{
	
	/**
	 * @param filename
	 * @return list of files
	 * @throws NoSuchElementException
	 */
	@Query("SELECT f FROM File f WHERE f.ownerPost.postId = :postId")
    List<File> getAllByOwnerPostId(@Param("postId") UUID postId);
	
}
