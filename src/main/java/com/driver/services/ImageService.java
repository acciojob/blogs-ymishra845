package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
    	Image obj= new Image(description,dimensions);
    	Blog blog= blogRepository2.findById(blogId).orElse(null);
    	obj.setBlog(blog);
    	imageRepository2.save(obj);
    	return obj;

    }

    public void deleteImage(Integer id){

    	Image image= imageRepository2.findById(id).orElse(null);
    	
    	blogRepository2.deleteById(image.getId());
    	imageRepository2.deleteById(id);
    	
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
    	Image image=imageRepository2.findById(id).orElse(null);
    	
    	 String[] screenSize = screenDimensions.split("x");
    	    int screenWidth = Integer.parseInt(screenSize[0]);
    	    int screenHeight = Integer.parseInt(screenSize[1]);

    	    // Assuming that image dimensions are in the format "widthxheight"
    	    String[] imageDimensions = image.getDimensions().split("x");
    	    int imageWidth = Integer.parseInt(imageDimensions[0]);
    	    int imageHeight = Integer.parseInt(imageDimensions[1]);

    	    // Calculate the number of images that can fit horizontally and vertically on the screen
    	    int horizontalFit = screenWidth / imageWidth;
    	    int verticalFit = screenHeight / imageHeight;

    	    // Return the total number of images that can fit on the screen
    	    return horizontalFit * verticalFit;

    }
}
