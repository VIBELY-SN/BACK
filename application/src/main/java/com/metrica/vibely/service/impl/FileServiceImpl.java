package com.metrica.vibely.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metrica.vibely.data.entity.File;
import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.model.dto.FileDTO;
import com.metrica.vibely.data.model.mapper.FileMapper;
import com.metrica.vibely.data.repository.FileRepository;
import com.metrica.vibely.data.repository.PostRepository;
import com.metrica.vibely.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	// <<-FIELD->>
		private FileRepository fileRepository;
		private PostRepository postRepository;

	    // <<-CONSTRUCTOR->>
		@Autowired
		public FileServiceImpl(final FileRepository fileRepository, final PostRepository postRepository) {
			this.fileRepository = fileRepository;
			this.postRepository = postRepository;
		}

	    // <<-METHODS->>
	@Override
	public FileDTO getById(UUID id) {
		return FileMapper.toDTO(fileRepository.findById(id).orElseThrow());
	}


	
	public List<FileDTO> getAllByOwnerPostId(UUID id) {
		List<File> entityFiles = fileRepository.getAllByOwnerPostId(id);
		List<FileDTO> dtoFiles = new ArrayList<FileDTO>(); 
		if(entityFiles != null) {
			for(File file : entityFiles) {
				dtoFiles.add(FileMapper.toDTO(file));
			}
		}
		return dtoFiles;
	}

	@Override
	public FileDTO uploadFile(MultipartFile file, UUID ownerPostId) throws IOException {
		Post uploader = postRepository.findById(ownerPostId).orElseThrow();
		File fileEntity = FileMapper.multipartFiletoEntity(file, PATH, uploader);
		FileDTO fileDto = FileMapper.toDTO(fileEntity);
		
		// Escribimos en disco con Files.write(Ruta, contenido del fichero)
		Files.write(Paths.get(fileDto.getAbsolutePath()),file.getBytes());
		
		return FileMapper.toDTO(fileRepository.save(fileEntity));
	}

	@Override
	public void deleteById(UUID fileId) {
		fileRepository.deleteById(fileId);
	}


}
