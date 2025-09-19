package m2_demo.bank.repo;

import m2_demo.bank.entity.PayAccount;
import m2_demo.bank.util.ReadAndWriteFileBank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PayAccountRepo implements IPayAccountRepo{
    private final String PAY_FILE = "src/m2_demo/bank/data/bank_accounts.csv";
    @Override
    public List<PayAccount> getAll(){
        List<PayAccount> payAccountList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileBank.readFileCSV(PAY_FILE);
            String[] arr;
            for (String line: stringList){
                arr = line.split(",");
                PayAccount payAccount = new PayAccount(Integer.parseInt(arr[0])
                        ,Integer.parseInt(arr[1])
                        ,arr[2]
                        ,arr[3]
                        ,Integer.parseInt(arr[4])
                        ,Integer.parseInt(arr[5])
                );
                payAccountList.add(payAccount);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return payAccountList;
    }
    @Override
    public boolean add(PayAccount payAccount){
        List<String> list = new ArrayList<>();
        list.add(payAccount.getInfoToCSV());
        try {
            ReadAndWriteFileBank.writeListStringToCSV(PAY_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }
    @Override
    public boolean delete(int idAccount){
        boolean isSuccessDelete = false;
        List<PayAccount> payAccountList = getAll();
        for (PayAccount p : payAccountList){
            if (p.getIdAccount()==idAccount){
                payAccountList.remove(p);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (PayAccount p : payAccountList){
            stringList.add(p.getInfoToCSV());
        }
        try {
            ReadAndWriteFileBank.writeListStringToCSV(PAY_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
        }
        return isSuccessDelete;
    }

    @Override
    public PayAccount find(int idAccount){
        List<PayAccount> payAccountList = getAll();
        for (PayAccount p : payAccountList){
            if (p.getIdAccount()==idAccount){
                return p;
            }
        }
        return null;
    }
}
