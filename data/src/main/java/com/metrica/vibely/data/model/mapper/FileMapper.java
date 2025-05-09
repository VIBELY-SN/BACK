package com.metrica.vibely.data.model.mapper;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.metrica.vibely.data.entity.File;
import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.model.dto.FileDTO;


public class FileMapper {
	// <<-METHODS->>
		/**
		 * Maps the information contained in the DTO into the Entity.
		 * @param 	FileDTO the DTO to map
		 * @return 	the entity with the DTO info
		 */
	public static File toEntity(FileDTO fileDTO, Post uploader) {
		File file = new File();

		// Mapping Basics
		file.setFileId		(fileDTO.getFileId());
		file.setFileName	(fileDTO.getFileName());
		file.setContentType	(fileDTO.getContentType());
		file.setAbsolutePath(fileDTO.getAbsolutePath());
		file.setSize		(fileDTO.getSize());

		// Mapping Relations
		file.setOwnerPost	    (uploader);


		return file;
	}
	/**
     * Convert an entity into a DTO
     *
     * @param 	file entity
     * @return 	the FileDTO
     */
	public static FileDTO toDTO(File file) {
		FileDTO fileDTO = new FileDTO();
		// Mapping Basics
			fileDTO.setFileId		(file.getFileId());
			fileDTO.setFileName		(file.getFileName());
			fileDTO.setContentType	(file.getContentType());
			fileDTO.setAbsolutePath	(file.getAbsolutePath());
			fileDTO.setSize			(file.getSize());

		// Mapping Relations
			fileDTO.setOwnerPostId(file.getOwnerPost().getPostId());
			
		return fileDTO;
	}
	
	/**
     * Convert a multipartFile into an entity
     *
     * @param 	MultipartFile entity
     * @return 	the file entity
     */
	public static File multipartFiletoEntity(MultipartFile file, String path, Post ownerPost) {
		File fileEntity = new File();
		String newFileName = UUID.randomUUID().toString() + file.getOriginalFilename();

		// Mapping Basics
			
			fileEntity.setFileName		(newFileName);
			fileEntity.setContentType	(file.getContentType());
			fileEntity.setAbsolutePath	(path + newFileName);
			fileEntity.setSize			(file.getSize());

		// Mapping Relations
			fileEntity.setOwnerPost(ownerPost);
			
		return fileEntity;
	}
}
