package m2_demo.company.service;

import m2_demo.company.model.ElectronicProduct;
import m2_demo.company.repo.ElectronicRepo;
import m2_demo.company.repo.IElectronicRepo;

import java.util.List;

public class ElectronicService implements IElectronicService{
    private static IElectronicRepo electronicRepo = new ElectronicRepo();

    @Override
    public List<ElectronicProduct> getAll(){
        return electronicRepo.getAll();
    }

    @Override
    public boolean add(ElectronicProduct electronicProduct){
        for (ElectronicProduct e : electronicRepo.getAll()){
            if (e.getId()== electronicProduct.getId()){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<ElectronicProduct> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        electronicProduct.setId(id);
        return electronicRepo.add(electronicProduct);
    }

    @Override
    public boolean delete(int id){
        return electronicRepo.delete(id);
    }

    @Override
    public List<ElectronicProduct> findByKeyword(String keyword){
        return electronicRepo.findByKeyword(keyword);
    }

    public ElectronicProduct findToShow(int id){
        List<ElectronicProduct> electronicProductList = getAll();
        for (ElectronicProduct e : electronicProductList){
            if (e.getId()==id){
                return e;
            }
        }
        return null;
    }
}
