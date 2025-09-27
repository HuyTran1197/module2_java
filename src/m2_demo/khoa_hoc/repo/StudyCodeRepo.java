package m2_demo.khoa_hoc.repo;

import m2_demo.khoa_hoc.model.StudyCode;
import m2_demo.khoa_hoc.util.ReadAndWriteFileStudy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudyCodeRepo implements IStudyCodeRepo{
    private final String CODE_FILE = "src/m2_demo/khoa_hoc/data/code.csv";

    @Override
    public List<StudyCode> getAll(){
        List<StudyCode> studyCodeList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileStudy.readFileCSV(CODE_FILE);
            String[] arr;
            for (String line : stringList){
                arr = line.split(",");
                StudyCode studyCode = new StudyCode(Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        arr[3],
                        Long.parseLong(arr[4]),
                        arr[5]
                        );
                studyCodeList.add(studyCode);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return studyCodeList;
    }

    @Override
    public boolean add(StudyCode studyCode){
        List<String> list = new ArrayList<>();
        list.add(studyCode.getInfoCSV());
        try {
            ReadAndWriteFileStudy.writeListStringToCSV(CODE_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<StudyCode> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdCLass().equals(id)){
                list.remove(i);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (StudyCode s : list){
            stringList.add(s.getInfoCSV());
        }
        try {
            ReadAndWriteFileStudy.writeListStringToCSV(CODE_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<StudyCode> find(String name){
        List<StudyCode> studyCodeList = getAll();
        List<StudyCode> newList = new ArrayList<>();
        for (StudyCode s : studyCodeList){
            if (s.getNameClass().toLowerCase().contains(name.toLowerCase())){
                newList.add(s);
            }
        }
        return newList;
    }
}
