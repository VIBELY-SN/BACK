package com.metrica.vibely.data.model.dto;

import java.util.Objects;
import java.util.UUID;

public class FileDTO {
	// <<-FIELDS->>
    
    // Basics
	private UUID 		fileId;
	private String 		fileName;
    private String 		contentType;
    private String 		absolutePath;
    private Long 		size;
    
    // Relations
    private UUID 	uploader;
	
	
	// <<-CONSTRUCTORS->>
    	public FileDTO() {
    	}
    
		public FileDTO(
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
	        FileDTO other = (FileDTO) obj;
	        return Objects.equals(this.fileId, other.fileId);
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


		public String getContentType() {
			return contentType;
		}


		public void setContentType(String contentType) {
			this.contentType = contentType;
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


		public UUID getUploader() {
			return uploader;
		}


		public void setUploader(final UUID uploader) {
			this.uploader = uploader;
		}
}