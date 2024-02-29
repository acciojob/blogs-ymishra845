package com.driver.models;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 int id;
	Blog blog;
	
	String description;
	String dimention;
	
	public Image(String description, String dimention) {
		this.description=description;
		this.dimention=dimention;
	}

	public String getDimensions() {
		// TODO Auto-generated method stub
		return this.dimention;
	}

	
	
   
	
}