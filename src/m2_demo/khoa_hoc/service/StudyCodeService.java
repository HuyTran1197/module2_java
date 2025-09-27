package m2_demo.khoa_hoc.service;

import m2_demo.khoa_hoc.model.StudyCode;
import m2_demo.khoa_hoc.repo.IStudyCodeRepo;
import m2_demo.khoa_hoc.repo.StudyCodeRepo;

import java.util.List;

public class StudyCodeService implements IStudyCodeService{
    private static IStudyCodeRepo studyCodeRepo = new StudyCodeRepo();

    @Override
    public List<StudyCode> getAll(){
        return studyCodeRepo.getAll();
    }

    @Override
    public boolean add(StudyCode studyCode){
        for (StudyCode s : studyCodeRepo.getAll()){
            if (s.getIdCLass().equals(studyCode.getIdCLass())){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<StudyCode> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        studyCode.setId(id);
        return studyCodeRepo.add(studyCode);
    }

    @Override
    public boolean delete(String id){
        return studyCodeRepo.delete(id);
    }

    @Override
    public List<StudyCode> find(String name){
        return studyCodeRepo.find(name);
    }

    public StudyCode findToDelete(String id){
        for (StudyCode s : studyCodeRepo.getAll()){
            if (s.getIdCLass().equals(id)){
                return s;
            }
        }
        return null;
    }
}
