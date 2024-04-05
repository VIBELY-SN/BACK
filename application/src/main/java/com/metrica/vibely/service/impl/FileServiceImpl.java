package com.metrica.vibely.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metrica.vibely.data.entity.File;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.FileDTO;
import com.metrica.vibely.data.model.mapper.FileMapper;
import com.metrica.vibely.data.repository.FileRepository;
import com.metrica.vibely.data.repository.UserRepository;
import com.metrica.vibely.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	// <<-FIELD->>
		private FileRepository fileRepository;
		private UserRepository userRepository;

	    // <<-CONSTRUCTOR->>
		@Autowired
		public FileServiceImpl(final FileRepository fileRepository, final UserRepository userRepository) {
			this.fileRepository = fileRepository;
			this.userRepository = userRepository;
		}

	    // <<-METHODS->>
	@Override
	public FileDTO getById(UUID id) {
		return FileMapper.toDTO(fileRepository.findById(id).orElseThrow());
	}


	
	public List<FileDTO> getAllByUserName(UUID id) {
		List<File> entityFiles = fileRepository.findAllByUploader(id);
		List<FileDTO> dtoFiles = new ArrayList<FileDTO>(); 
		if(entityFiles != null) {
			for(File file : entityFiles) {
				dtoFiles.add(FileMapper.toDTO(file));
			}
		}
		return dtoFiles;
	}

	@Override
	public FileDTO uploadFile(MultipartFile file, UUID uploaderId) throws IOException {
		User uploader = userRepository.findById(uploaderId).orElseThrow();
		File fileEntity = FileMapper.multipartFiletoEntity(file, PATH, uploaderId);
		FileDTO fileDto = FileMapper.toDTO(fileEntity);
		
		// Escribimos en disco con Files.write(Ruta, contenido del fichero)
		Files.write(Paths.get(fileDto.getAbsolutePath()),file.getBytes());
		
		fileRepository.save(fileEntity);
		
		return fileDto;
	}

	@Override
	public void deleteById(UUID fileId) {
		fileRepository.deleteById(fileId);
	}


}
