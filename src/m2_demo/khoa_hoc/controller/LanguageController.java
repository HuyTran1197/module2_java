package m2_demo.khoa_hoc.controller;

import m2_demo.khoa_hoc.model.Language;
import m2_demo.khoa_hoc.service.ILanguageService;
import m2_demo.khoa_hoc.service.LanguageService;
import m2_demo.khoa_hoc.view.LanguageView;

import java.util.List;

public class LanguageController {
    private static ILanguageService languageService = new LanguageService();

    public static void showListLanguage(){
        List<Language> languageList = languageService.getAll();
        LanguageView.showList(languageList);
    }

    public static void showListLanguage(List<Language> languageList){
        LanguageView.showList(languageList);
    }

    public static void addLanguage(){
        Language language = LanguageView.inputToAddLanguage();
        if (language!=null){
            boolean isSuccessAdd = languageService.add(language);
            if (isSuccessAdd){
                System.out.println("Added language success");
            }else {
                System.out.println("Added language fail");
            }
        }
    }
}
