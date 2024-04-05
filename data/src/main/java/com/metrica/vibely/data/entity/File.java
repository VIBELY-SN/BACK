package com.metrica.vibely.data.entity;

import com.metrica.vibely.data.util.Copyable;
import com.metrica.vibely.data.util.DeepCopyGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;



@Entity
@Table(name = "Uploaded_files")
public class File implements Copyable<File> {
	// <<-FIELDS->>
    // Basic
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "file_id")
    private UUID fileId;
    @Column(unique = true, nullable = false)
	private String fileName;
    @Column(nullable = false)
    private String contentType;
    @Column(name = "absolute_path",unique = true, nullable = false)
    private String absolutePath;
    @Column(nullable = false)
    private Long size;
    
    // Relations
    
    //JoinTable remaining
    @ManyToOne
    private UUID uploader;
    
 // <<-CONSTRUCTORS->>
    
	public File(
			UUID 		fileId, 
			String 		fileName, 
			String		contentType,
			String 		absolutePath, 
			Long 		size, 
			UUID 		uploader) {
		this.setFileId		(fileId);
		this.setFileName	(fileName);
		this.setContentType	(contentType);
		this.setAbsolutePath(absolutePath);
		this.setSize		(size);
		this.setUploader	(uploader);
}
	
    public File() {
    	this.setFileId(null);
		this.setUploader(null);
    }
   
 // <<-METHODS->>
 		@Override
 	    public int hashCode() {
 	        return Objects.hash(this.fileId);
 	    }

 	    @Override
 	    public boolean equals(Object obj) {
 	        if (this == obj)
 	            return true;
 	        if (obj == null)
 	            return false;
 	        if (this.getClass() != obj.getClass())
 	            return false;
 	       File other = (File) obj;
 	        return Objects.equals(this.fileId, other.fileId);
 	    } 
    
 	    @Override
		public File deepCopy() {
			File copy = new File();
			
			copy.setFileId      (this.fileId);
			copy.setFileName	(this.fileName);
			copy.setAbsolutePath(this.absolutePath);
			copy.setSize		(this.size);
			copy.setContentType	(this.contentType);
			
			return copy;
		}
	

	// <<-GETTERS & SETTERS->>
	public UUID getFileId() {
		return fileId;
	}

	public void setFileId(UUID fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public UUID getUploader() {
		 return this.uploader;
	}

	public void setUploader(UUID uploader) {
		this.uploader = uploader;
	}

	
}
