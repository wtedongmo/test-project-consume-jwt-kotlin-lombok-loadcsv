package com.twb.loadfile.csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

//    public UserController(UserRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/upload")
    public String page(){
        return "upload";
        /*
        "<h1>Test upload CSV File</h1>\n" +
                "<form action=\"/upload\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "    <input type=\"file\" name=\"file\" id=\"file\" />\n" +
                "    <input type=\"submit\" name=\"submit\" value=\"Submit\" />\n" +
                "</form>";
         */

    }


    @PostMapping(value = "/upload", consumes = "text/csv")
    public void uploadSimple(@RequestBody InputStream body) throws IOException {
        List<User> list = CsvUtils.read(User.class, body);
        repository.save(list);
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
        List<User> list = CsvUtils.read(User.class, file.getInputStream());
        repository.save(list);
    }

    @GetMapping("/findAllUsers")
    public List<User> findAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id){
        return repository.findOne(id);
    }

    @GetMapping("/findByIdParam")
    public User findByIdParam(@RequestParam("id") int id){
        return repository.findOne(id);
    }
}
