package edu.etime.yqxdc.controllers;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/test")
public class FileUploadController {

	@RequestMapping("/toupload")
	public String toupload(){
		return "fileupload/fileupload";
	}
	
	@RequestMapping("/upload")
	public String upload(String filename,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		
		//1、非文件参数可以直接获取
		System.out.println(filename);
		
		//2、上传文件
		if(file!=null && !file.isEmpty()){
			/* 
			 *  注意：上传文件的时候，需要：
			 *  1、指定上传文件的路径（一定要放在服务器的目录下面。因为文件还需要利用服务器去获取。）
			 *  2、文件名称：为了防止服务器上的文件重名。一般在上传文件的时候，都会将文件进行重命名（UUID）
			 */
			// 保存到服务器上的文件新名字
			String newName = UUID.randomUUID().toString();
            // 原文件名，并且包含后缀名。xxx.xxx
			String oldName = file.getOriginalFilename();
            System.out.println(oldName);
            // 取文件的后缀名
            String sux = oldName.substring(oldName.lastIndexOf("."));
            // 组成新的文件名
            String fileName = newName + sux;
            System.out.println("fileName:"+fileName);
            //request.getServletContext(): 获取项目的根路径（是一个URL路径）
            //request.getServletContext().getRealPath("/files/"): 根据URL获取服务器上的绝对路径
            String upload = request.getServletContext().getRealPath("/file/")+fileName;
            System.out.println("upload:"+upload);
            file.transferTo(new File(upload));
		}
		return "";
	}
	
	
	
	
}
