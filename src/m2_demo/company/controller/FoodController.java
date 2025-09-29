package m2_demo.company.controller;

import m2_demo.company.model.FoodProduct;
import m2_demo.company.service.FoodService;
import m2_demo.company.service.IFoodService;
import m2_demo.company.view.FoodView;

import java.util.List;

public class FoodController {
    private static IFoodService foodService = new FoodService();

    public static void showList(){
        List<FoodProduct> foodProductList = foodService.getAll();
        FoodView.showList(foodProductList);
    }

    public static void showListFood(List<FoodProduct> foodProductList){
        FoodView.showList(foodProductList);
    }

    public static void addFood(){
        FoodProduct foodProduct = FoodView.inputToAddFood();
        if (foodProduct!=null){
            boolean isSuccessAdd = foodService.add(foodProduct);
            if (isSuccessAdd){
                System.out.println("Added food success");
            }else {
                System.out.println("Added food fail");
            }
        }
    }
}
