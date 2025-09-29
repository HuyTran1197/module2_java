package m2_demo.company.controller;

import m2_demo.company.model.ElectronicProduct;
import m2_demo.company.service.ElectronicService;
import m2_demo.company.service.IElectronicService;
import m2_demo.company.view.ElectronicView;

import java.util.List;

public class ElectronicController {
    private static IElectronicService electronicService = new ElectronicService();

    public static void showList(){
        List<ElectronicProduct> electronicProductList = electronicService.getAll();
        ElectronicView.showList(electronicProductList);
    }

    public static void showListElectronic(List<ElectronicProduct> e){
        ElectronicView.showList(e);
    }

    public static void addElectronic(){
        ElectronicProduct electronicProduct = ElectronicView.inputToAddElectronic();
        if (electronicProduct!=null){
            boolean isSuccessAdd = electronicService.add(electronicProduct);
            if (isSuccessAdd){
                System.out.println("Added electronic success");
            }else {
                System.out.println("Added electronic fail");
            }
        }

    }
}
