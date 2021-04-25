package com.sakura.upload.controller;

import com.sakura.upload.file.FastDFSFile;
import com.sakura.upload.service.UploadService;
import com.sakura.upload.util.FastDFSClient;
//import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/15 23:23
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

//    /**
//     * 上传图片功能
//     * @param file
//     * @return
//     */
//    @PostMapping("image")
//    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
//        String url = this.uploadService.upload(file);
//        System.out.println(url);
//        if (StringUtils.isBlank(url)) {
//            // url为空，证明上传失败
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        // 返回200，并且携带url路径
//        return ResponseEntity.ok(url);
//    }

    /**
     * 返回 图片的全路径
     *
     * @param file 页面的文件对象
     * @return
     */
    @PostMapping("/image")
    public String upload(@RequestParam(value = "file") MultipartFile file) {
        try {
            //1. 创建图片文件对象(封装)
            //2. 调用工具类实现图片上传
            //String substring = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            FastDFSFile fastdfsfile = new FastDFSFile(
                    file.getOriginalFilename(),//原来的文件名  1234.jpg
                    file.getBytes(),//文件本身的字节数组
                    StringUtils.getFilenameExtension(file.getOriginalFilename())
            );
            String[] upload = FastDFSClient.upload(fastdfsfile);
            //  upload[0] group1
            //  upload[1] M00/00/00/wKjThF1aW9CAOUJGAAClQrJOYvs424.jpg
            //3. 拼接图片的全路径返回
            // http://192.168.211.132:8080/group1/M00/00/00/wKjThF1aW9CAOUJGAAClQrJOYvs424.jpg
            return "http://image.sakura.com/"+upload[0]+"/"+upload[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
