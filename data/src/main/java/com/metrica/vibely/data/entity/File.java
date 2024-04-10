package com.metrica.vibely.data.entity;

import java.util.Objects;
import java.util.UUID;

import com.metrica.vibely.data.util.Copyable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table
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
    @JoinColumn(name = "ownerpost",
    	nullable = false,
    	foreignKey = @ForeignKey(name = "fk_file_post"))
    private Post ownerPost;
    
 // <<-CONSTRUCTORS->>
    
	public File(
			UUID 		fileId, 
			String 		fileName, 
			String		contentType,
			String 		absolutePath, 
			Long 		size, 
			Post 		ownerPost) {
		this.setFileId		(fileId);
		this.setFileName	(fileName);
		this.setContentType	(contentType);
		this.setAbsolutePath(absolutePath);
		this.setSize		(size);
		this.setOwnerPost	(ownerPost);
}
	
    public File() {
    	this.setFileId(null);
		this.setOwnerPost(null);
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

	public Post getOwnerPost() {
		 return this.ownerPost;
	}

	public void setOwnerPost(Post ownerPost) {
		this.ownerPost = ownerPost;
	}

	
}
