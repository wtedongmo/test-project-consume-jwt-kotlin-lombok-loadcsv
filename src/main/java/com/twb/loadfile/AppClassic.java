package com.twb.loadfile;

import com.twb.loadfile.csv.UserService;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.annotation.PreDestroy;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class AppClassic {

    public static void main(String[] args) {

//        ConfigurableApplicationContext ctx = new
//                SpringApplicationBuilder(AppClassic.class).run();
//
//        System.out.println("Spring Boot application started");
//
//        UserService userService = ctx.getBean(UserService.class);
//        try {
//            userService.loadFileCsv(new File("loadfileUserTest.csv"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("\n\tSpring Boot application Load File end");
//        ctx.close();

//        Locale loc = LocaleContextHolder.getLocale();
//        System.out.println("\n\t locale "+loc.getDisplayLanguage());
//        System.out.println("\n\t locale cont "+loc.getCountry());
//        System.out.println("\n\t locale name "+loc.getDisplayName());
//        System.out.println("\n\t locale lan "+loc.getLanguage());
//        System.out.println("\n\t locale tag "+loc.toLanguageTag());
//        System.out.println("\n\t locale iso lang "+loc.getISO3Language());
//        System.out.println("\n\t locale iso cont "+loc.getISO3Country());
//        System.out.println("\n\t locale var "+loc.getDisplayVariant());

        String val = "je teste encadrement avec accolade {val1} et {val2}";// \\{.*?}
        System.out.println("\n\t Texte init "+val+"\n Texte replace: "+val.replaceAll("\\{.*?}", "")+
                "\n Texte contient: "+val.contains("\\{.*?}"));

        List<String> list = Arrays.asList("val1", "val2", "val3", "val4"); //new ArrayList<>();
        StringBuilder stBuil = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            stBuil.append("\n").append((i+1)).append(" ").append(list.get(i));
        }
        System.out.println("\n String build"+ stBuil);
        //ctx.getBean(TerminateBean.class);
    }
}


//class TerminateBean {
//
//    @PreDestroy
//    public void onDestroy() throws Exception {
//        System.out.println("Spring Container is destroyed!");
//    }
//}