package m2_demo.khoa_hoc.repo;

import m2_demo.khoa_hoc.model.Language;
import m2_demo.khoa_hoc.util.ReadAndWriteFileStudy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanguageRepo implements ILanguageRepo{
    private final String LANGUAGE_FILE = "src/m2_demo/khoa_hoc/data/language.csv";

    @Override
    public List<Language> getAll(){
        List<Language> languageList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileStudy.readFileCSV(LANGUAGE_FILE);
            String[] arr;
            for (String line : stringList){
                arr = line.split(",");
                Language language = new Language(Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        arr[3],
                        Long.parseLong(arr[4]),
                        arr[5],
                        arr[6]
                        );
                languageList.add(language);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return languageList;
    }

    @Override
    public boolean add(Language language){
        List<String> list = new ArrayList<>();
        list.add(language.getInfoCSV());
        try {
            ReadAndWriteFileStudy.writeListStringToCSV(LANGUAGE_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        List<Language> languageList = getAll();
        boolean isSuccessDelete = false;
        for (int i = 0; i < languageList.size(); i++) {
            if (languageList.get(i).getIdCLass().equals(id)){
                languageList.remove(i);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Language l : languageList){
            stringList.add(l.getInfoCSV());
        }
        try {
            ReadAndWriteFileStudy.writeListStringToCSV(LANGUAGE_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<Language> find(String name){
        List<Language> languageList = getAll();
        List<Language> list = new ArrayList<>();
        for (Language l : languageList){
            if (l.getNameClass().toLowerCase().contains(name.toLowerCase())){
                list.add(l);
            }
        }
        return list;
    }
}
