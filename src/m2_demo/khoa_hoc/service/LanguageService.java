package m2_demo.khoa_hoc.service;

import m2_demo.khoa_hoc.model.Language;
import m2_demo.khoa_hoc.repo.ILanguageRepo;
import m2_demo.khoa_hoc.repo.LanguageRepo;

import java.util.List;

public class LanguageService implements ILanguageService{
    private static ILanguageRepo languageRepo = new LanguageRepo();

    @Override
    public List<Language> getAll(){
        return languageRepo.getAll();
    }

    @Override
    public boolean add(Language language){
        for (Language l : languageRepo.getAll()){
            if (l.getIdCLass().equals(language.getIdCLass())){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<Language> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        language.setId(id);
        return languageRepo.add(language);
    }

    @Override
    public boolean delete(String id){
        return languageRepo.delete(id);
    }

    @Override
    public List<Language> find(String name){
        return languageRepo.find(name);
    }

    public Language findToDelete(String id){
        for (Language l : languageRepo.getAll()){
            if (l.getIdCLass().equals(id)){
                return l;
            }
        }
        return null;
    }
}
