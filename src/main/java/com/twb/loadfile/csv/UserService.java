package com.twb.loadfile.csv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void loadFileCsv(File file) throws Exception {

        List<User> list = CsvUtils.read(User.class, new FileInputStream(file));
        repository.save(list);

        List<User> listSave = repository.findAll();

        System.out.println("Liste des Users BD : "+listSave.toString());
    }
}
