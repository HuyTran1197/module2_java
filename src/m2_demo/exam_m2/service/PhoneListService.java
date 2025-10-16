package m2_demo.exam_m2.service;

import m2_demo.exam_m2.model.PhoneList;
import m2_demo.exam_m2.repo.IPhoneListRepo;
import m2_demo.exam_m2.repo.PhoneListRepo;

import java.util.LinkedList;
import java.util.List;

public class PhoneListService implements IPhoneListService{
    private static IPhoneListRepo phoneListRepo = new PhoneListRepo();

    private static LinkedList<PhoneList> phoneLists = new LinkedList<>();

    static {
        phoneLists.add(new PhoneList("0905716540","Study","Tran Huy","Male","20/12/2005"));
        phoneLists.add(new PhoneList("0905235541","Study","Dinh Phong","Male","12/05/2003"));
        phoneLists.add(new PhoneList("0906747778","Study","Le Long","Male","15/08/2000"));
    }

    public void getList(){
        for (PhoneList p : phoneLists){
            System.out.println(p.toStringList());
        }
    }

    @Override
    public List<PhoneList> getAll(){
        return phoneListRepo.getAll();
    }

    @Override
    public boolean add(PhoneList phoneList){
        for (PhoneList p : phoneListRepo.getAll()){
            if (p.getPhone().equals(phoneList.getPhone())){
                System.out.println("phone is already exists");
                return false;
            }
        }
        return phoneListRepo.add(phoneList);
    }

    @Override
    public boolean delete(String id){
        return phoneListRepo.delete(id);
    }

    @Override
    public boolean edit(PhoneList phoneList){
        boolean checkExists = false;
        for (PhoneList p : phoneListRepo.getAll()){
            if (p.getPhone().equals(phoneList.getPhone())){
                checkExists = true;
                break;
            }
        }
        if (!checkExists){
            System.out.println("Not found phone to edit");
            return false;
        }
        return phoneListRepo.edit(phoneList);
    }

    @Override
    public List<PhoneList> findByKeyword(String keyword){
        return phoneListRepo.findByKeyword(keyword);
    }

    public PhoneList findToShow(String phone){
        List<PhoneList> phoneListList = getAll();
        for (PhoneList p : phoneListList){
            if (p.getPhone().equals(phone)){
                return p;
            }
        }
        return null;
    }
}
