package org.study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="z_files")
@Entity(name="files")
public class Files {
	@Id
	@Column(name="id")
	int id;
	@Column(name="filename")
	String fileName;
	@Column(name="label")
	String label;
	@Column(name="caption")
	String caption;
	

	public Files() {
		
	}


	public Files(String fileName) {
		super();
		this.fileName = fileName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	@Override
	public String toString() {
		return "Files [id=" + id + ", fileName=" + fileName + ", label=" + label + ", caption=" + caption + "]";
	}
	
	
	
}
