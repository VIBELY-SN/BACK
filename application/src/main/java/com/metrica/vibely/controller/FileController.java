package com.metrica.vibely.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.metrica.vibely.controller.util.ResponseManager;
import com.metrica.vibely.data.model.dto.FileDTO;
import com.metrica.vibely.model.response.create.CreateFileResponse;
import com.metrica.vibely.model.response.get.GetAllFilesByUserResponse;
import com.metrica.vibely.model.response.get.GetFileResponse;
import com.metrica.vibely.service.FileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {
	
	// <<-FIELDS->>
	private ResponseManager responseManager;
	private FileService fileService;
	
	// <<-CONSTRUCTOR->>
    @Autowired
    public FileController(FileService fileService, ResponseManager responseManager) {
		this.responseManager = responseManager;
		this.fileService = fileService;
	}
    
    
 // <<-METHODS->>
    @GetMapping("/{id}")
    public ResponseEntity<GetFileResponse> getById(@PathVariable UUID id){
    	FileDTO fileDto = this.fileService.getById(id);
    	return this.responseManager.generateGetResponse(fileDto);
    }
    
    
    @GetMapping("/userFiles/{id}")
    public ResponseEntity<GetAllFilesByUserResponse> getAllByUserName(@PathVariable UUID id){
    	List<FileDTO> userFiles = this.fileService.getAllByUserName(id);
    	return this.responseManager.generateGetResponse(userFiles); 	
    }
    
    @PostMapping("/upload/{uploader}")
    public ResponseEntity<CreateFileResponse> uploadFile(
//    		@RequestBody
            @Valid
            MultipartFile file,
//            BindingResult bindingResult,
            @PathVariable UUID uploader
   ){
//    	if (bindingResult.hasErrors()) {            
//            return ResponseEntity.badRequest().build(); 
//        }
    	
    	try {
			FileDTO fileDto = this.fileService.uploadFile(file, uploader);
			return this.responseManager.generateCreateResponse(fileDto);
		} catch (IOException e) {
			 return ResponseEntity.notFound().build();
		}
    }
	
    @DeleteMapping("/{id}")	
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        this.fileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }	
}
