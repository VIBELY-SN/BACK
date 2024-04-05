package com.metrica.vibely.service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.metrica.vibely.data.model.dto.FileDTO;

public interface FileService{
	
	final String PATH = "C:\\Users\\Tiago\\Desktop\\ficheros\\";
	
	/**
     * Gets file information by its id
     * @param id 
     * @return FileDTO
     * @throws NoSuchElementException
     */
	FileDTO getById(UUID id);
	
	/**
     * Gets all files of an user by its userId
     * @param userId 
     * @return Set<FileDTO>
     * @throws NoSuchElementException
     */
	List<FileDTO> getAllByUserName(UUID id);
	
	/**
     * Gets all files of an user by its userId
     * @param MultipartFile file 
     * @return FileDTO
     * @throws NoSuchElementException
     */
	FileDTO uploadFile(MultipartFile file, UUID user) throws IOException;
	
	/**
     * Deletes a file given its id
     * @param fileId 
     * @throws NoSuchElementException
     */
	void deleteById(UUID fileId);
	

		
	
	
}
