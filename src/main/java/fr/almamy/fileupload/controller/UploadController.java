package fr.almamy.fileupload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@PropertySource("classpath:config/upload.properties")
public class UploadController {
    // == Constants ==
    @Value("${file.upload.max.size: 300}")
    public int MAX_UPLOAD_SIZE;
    public String FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\uploads\\";

    // == Fields ==
    Map<String, Object> result = new HashMap<>();

    // == Public Methods ==
    @RequestMapping("/upload")
    public Map<String, Object> upload (@RequestParam("attach") MultipartFile file) {
        /// File Information
        System.out.println("Filename = " + file.getOriginalFilename());
        System.out.println("File type = " + file.getContentType());

        // Save to disk
        try{
            file.transferTo(new File(FILE_PATH + file.getOriginalFilename()));
            result.put("Success", true);
        } catch (Exception e){
            result.put("Success", false);
        }
        return result;
    }


}