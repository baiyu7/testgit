package com.by.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class AppFileService {


    @RequestMapping("AppFileService")
    @ResponseBody
    public String upload(@RequestParam(value = "testfile", required = false) MultipartFile testfile, HttpServletRequest request) throws IllegalStateException, IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        //将上传文件保存到一个目标文件当中
        System.out.println(path);
        System.out.println(testfile.getOriginalFilename());
        System.out.println(new File(path + "//" + testfile.getOriginalFilename()).getAbsolutePath());
        testfile.transferTo(new File(path + "//" + testfile.getOriginalFilename()));
        return "success";
    }

}