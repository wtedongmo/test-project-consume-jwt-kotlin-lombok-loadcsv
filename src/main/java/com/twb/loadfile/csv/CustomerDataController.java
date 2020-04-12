package com.twb.loadfile.csv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Controller
public class CustomerDataController {

    private static final String SEARCH_TYPES = "searchTypes";

    @ModelAttribute
    public void initValues(Model model) {
        model.addAttribute(SEARCH_TYPES, Arrays.asList("Search A", "Search B", "Search C", "Search D", "Search E", "Search F"));
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String displayUpload() {
        return "upload-file";
    }

    @RequestMapping(value = "/userFile", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("myFile") MultipartFile file,
                                   @RequestParam List<String> searchValues, @RequestParam int number1, @RequestParam int number2, Model model) {

        // here you can use searchValues and file
        model.addAttribute("selectTypes", searchValues);
        model.addAttribute("resultDiv", number1/number2);
        return "result-checked";
    }
}