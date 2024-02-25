package com.driver.models;

import java.util.Arrays;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String imageName;
    private byte[] imageData;
    
    public byte[] getImageData() {
        return Arrays.copyOf(imageData, imageData.length);
    }
    public void setImageData(byte[] imageData) {
        this.imageData = Arrays.copyOf(imageData, imageData.length);
    }
	
}