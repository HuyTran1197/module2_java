package m2_demo.khoa_hoc.controller;

import m2_demo.khoa_hoc.model.StudyCode;
import m2_demo.khoa_hoc.service.IStudyCodeService;
import m2_demo.khoa_hoc.service.StudyCodeService;
import m2_demo.khoa_hoc.view.StudyCodeView;

import java.util.List;

public class StudyCodeController {
    private static IStudyCodeService studyCodeService = new StudyCodeService();

    public static void showListCode(){
        List<StudyCode> studyCodeList = studyCodeService.getAll();
        StudyCodeView.showList(studyCodeList);
    }

    public static void showListCode(List<StudyCode> studyCode){
        StudyCodeView.showList(studyCode);
    }

    public static void addCode(){
        StudyCode studyCode = StudyCodeView.inputToAdd();
        if (studyCode!=null){
            boolean isSuccessAdd = studyCodeService.add(studyCode);
            if (isSuccessAdd){
                System.out.println("Added study code success");
            }else {
                System.out.println("Added study code fail");
            }
        }
    }
}
