package m2_demo.company.service;

import m2_demo.company.model.FoodProduct;
import m2_demo.company.repo.FoodRepo;
import m2_demo.company.repo.IFoodRepo;

import java.util.List;

public class FoodService implements IFoodService{
    private static IFoodRepo foodRepo = new FoodRepo();

    @Override
    public List<FoodProduct> getAll(){
        return foodRepo.getAll();
    }

    @Override
    public boolean add(FoodProduct foodProduct){
        for (FoodProduct f : foodRepo.getAll()){
            if (f.getId()==foodProduct.getId()){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<FoodProduct> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        foodProduct.setId(id);
        return foodRepo.add(foodProduct);
    }

    @Override
    public boolean delete(int id){
        return foodRepo.delete(id);
    }

    @Override
    public List<FoodProduct> findByKeyword(String keyword){
        return foodRepo.findByKeyword(keyword);
    }

    public FoodProduct findToShow(int id){
        for (FoodProduct f : foodRepo.getAll()){
            if (f.getId()==id){
                return f;
            }
        }
        return null;
    }
}
