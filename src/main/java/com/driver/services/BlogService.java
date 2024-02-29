package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(int userId, String title, String content) {
        //create a blog at the current time
    	 User user = userRepository1.findById(userId).orElse(null);
           
    	 if(user!=null) {
    		 //create new blog
    		 Blog newBlog= new Blog();
    		 newBlog.setTitle(title);
    		 newBlog.setContent(content);
    		 newBlog.setUserId(userId);
    		 
    		 blogRepository1.save(newBlog);
    		 return newBlog;	 
    	 }
    	 
    	return null;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
    	
    	//find blog Id
    	 Blog blogToDelete = blogRepository1.findById(blogId).orElse(null);
    	 
    	 if (blogToDelete != null) {
             // Delete the associated images
            

             // Delete the blog
             blogRepository1.delete(blogToDelete);
         }
    	 
    	 

    }
}
