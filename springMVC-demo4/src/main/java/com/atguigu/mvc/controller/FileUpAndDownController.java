package com.atguigu.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName FileUpAndDownController
 * @Description
 * @Author 12468
 * @Date 2021/12/28 21:42
 * @Version 1.0
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testDown(HttpSession httpSession) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = httpSession.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        System.out.println("realPath = " + realPath);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        System.out.println(photo.getName());
        System.out.println(photo.getOriginalFilename());
        // 生成时间戳
        LocalDateTime now = LocalDateTime.now();
        String s = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS"));
        // 获取文件名
        String filename = photo.getOriginalFilename();
        // 获取文件后缀名
        String suffix = filename.substring(filename.lastIndexOf("."));
        // 生成最终的文件名
        String finalFileName = s + suffix;
        // 获取文件夹的服务器路径
        ServletContext context = session.getServletContext();
        String photoPath = context.getRealPath("photo");
        File file = new File(photoPath);
        // 判断photoPath所在对应路径是否存在
        if(!file.exists())
            // 如果不存在则创建目录
            file.mkdir();
        String finalPath = photoPath + File.separator + finalFileName;
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
