package m2_demo.exam_m2.repo;

import m2_demo.exam_m2.model.PhoneList;
import m2_demo.exam_m2.util.ReadAndWriteFIleExam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneListRepo implements IPhoneListRepo{
    private final String PHONE_FILE = "src/m2_demo/exam_m2/data/contacts.csv";

    @Override
    public List<PhoneList> getAll(){
        List<PhoneList> phoneListList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFIleExam.readFileCSV(PHONE_FILE);
            String[] arr;
            for (String line : stringList){
                arr = line.split(",");
                PhoneList phoneList = new PhoneList(arr[0],
                        arr[1],
                        arr[2],arr[3],arr[4],arr[5],arr[6]
                        );
                phoneListList.add(phoneList);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return phoneListList;
    }

    @Override
    public boolean add(PhoneList phoneList){
        List<String> list = new ArrayList<>();
        list.add(phoneList.getInfoCSV());
        try {
            ReadAndWriteFIleExam.writeListStringToCSV(PHONE_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        List<PhoneList> phoneListList = getAll();
        boolean isSuccessDelete = false;
        for (PhoneList p : phoneListList){
            if (p.getPhone().equalsIgnoreCase(id)){
                phoneListList.remove(p);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (PhoneList p : phoneListList){
            stringList.add(p.getInfoCSV());
        }
        try {
            ReadAndWriteFIleExam.writeListStringToCSV(PHONE_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public boolean edit(PhoneList phoneList){
        List<PhoneList> phoneListList = getAll();
        boolean isSuccessEdit = false;
        for (int i = 0; i < phoneListList.size(); i++) {
            if (phoneListList.get(i).getPhone().equalsIgnoreCase(phoneList.getPhone())){
                phoneListList.set(i,phoneList);
                isSuccessEdit = true;
                break;
            }
        }
        if (isSuccessEdit){
            List<String> stringList = new ArrayList<>();
            for (PhoneList p : phoneListList){
                stringList.add(p.getInfoCSV());
            }
            try {
                ReadAndWriteFIleExam.writeListStringToCSV(PHONE_FILE,stringList,false);
            } catch (IOException e) {
                System.out.println("file write fail");
                return false;
            }
        }
        return isSuccessEdit;
    }

    @Override
    public List<PhoneList> findByKeyword(String keyword){
        List<PhoneList> phoneListList = getAll();
        List<PhoneList> addList = new ArrayList<>();
        for (PhoneList p : phoneListList){
            if (p.getPhone().contains(keyword)){
                PhoneList newList = p;
                addList.add(newList);
            } else if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                PhoneList newList = p;
                addList.add(newList);
            }
        }
        return addList;
    }
}
