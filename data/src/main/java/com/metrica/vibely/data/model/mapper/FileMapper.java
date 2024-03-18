package com.metrica.vibely.data.model.mapper;

import java.util.stream.Collectors;

import com.metrica.vibely.data.entity.File;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.FileDTO;


public class FileMapper {
	// <<-METHODS->>
		/**
		 * Maps the information contained in the DTO into the Entity.
		 *
		 * This method is mainly used when you create a new entity
		 * so it's really not important the values you assign to the
		 * relations fields.
		 *
		 * @param 	FileDTO the DTO to map
		 * @return 	the entity with the DTO info
		 */
	public static File toEntity(FileDTO fileDTO) {
		File file = new File();

		// Mapping Basics
		file.setFileId		(fileDTO.getFileId());
		file.setFileName	(fileDTO.getFileName());
		file.setContentType	(fileDTO.getContentType());
		file.setAbsolutePath(fileDTO.getAbsolutePath());
		file.setSize		(fileDTO.getSize());

		// Mapping Relations
		file.setUploader	(null);


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
			fileDTO.setUploader(file.getUploader()
					.stream	()
					.map	(User::getUserId)
					.collect(Collectors.toSet()));
			
		return fileDTO;
	}
}
