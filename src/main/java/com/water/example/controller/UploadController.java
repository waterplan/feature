package com.water.example.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class UploadController {



    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegistration(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest  multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        String username = multipartHttpServletRequest.getParameter("username");
        System.out.println("username:"+username);
        MultipartFile file = multipartHttpServletRequest.getFile("uploadFile");
        String uploadFileName = file.getOriginalFilename();
        System.out.println("文件名:"+uploadFileName);
        InputStream fileStream = file.getInputStream();
        String uploadPath = request.getSession().getServletContext().getRealPath("upload");
        File destination = new File(uploadPath,uploadFileName);
        FileUtils.copyInputStreamToFile(fileStream,destination);
        return "indi";
    }
}
