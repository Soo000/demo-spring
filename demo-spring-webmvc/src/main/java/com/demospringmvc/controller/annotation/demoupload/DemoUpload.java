package com.demospringmvc.controller.annotation.demoupload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/upload")
public class DemoUpload {

	@RequestMapping("/uploadfile")
	public String uploadFile(@RequestParam("myFile") CommonsMultipartFile commonsMultipartFile) {
		String result = "demoupload/uploadresult";
		System.out.println("------ ÎÄ¼þÃû³Æ£º " + commonsMultipartFile.getOriginalFilename() + " ------");
		
		if (commonsMultipartFile.isEmpty()) {
			return result;
		}
		
		try {
			String myFile = "e:/tmp/" + commonsMultipartFile.getOriginalFilename();
			InputStream inputStream = commonsMultipartFile.getInputStream();
			OutputStream outputStream = new FileOutputStream(myFile);
			
			int b = 0;
			while ((b = inputStream.read()) != -1) {
				outputStream.write(b);
			}
			outputStream.flush();
			outputStream.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping("/uploadfile2")
	public String uploadFile2(HttpServletRequest request, HttpServletResponse response) {
		String result = "demoupload/uploadresult";
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		
		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			Iterator iterator = multipartHttpServletRequest.getFileNames();
			while(iterator.hasNext()) {
				MultipartFile multipartFile = multipartHttpServletRequest.getFile((String) iterator.next());
				if (multipartFile == null) {
					continue;
				}
				
				File newFile = new File("e:/tmp/" + multipartFile.getOriginalFilename());
				try {
					if (!newFile.exists()) {
						newFile.createNewFile();
					}
					multipartFile.transferTo(newFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
}
