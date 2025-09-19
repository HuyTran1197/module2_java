package m2_demo.bank.repo;
import m2_demo.bank.entity.SavingAccount;
import m2_demo.bank.util.ReadAndWriteFileBank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavingAccountRepo implements ISavingAccountRepo{
    private final String SAVING_FILE = "src/m2_demo/bank/data/bank_accounts.csv";

    @Override
    public List<SavingAccount> getAll(){
        List<SavingAccount> savingAccountList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileBank.readFileCSV(SAVING_FILE);
            String[] arr;
            for (String line: stringList){
                arr = line.split(",");
                SavingAccount savingAccount = new SavingAccount(Integer.parseInt(arr[0])
                        ,Integer.parseInt(arr[1])
                        ,arr[2]
                        ,arr[3]
                        ,Integer.parseInt(arr[4])
                        ,arr[5]
                        ,Integer.parseInt(arr[6])
                        ,Integer.parseInt(arr[7])
                );
                savingAccountList.add(savingAccount);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return savingAccountList;
    }
    @Override
    public boolean add(SavingAccount savingAccount){
        List<String> list = new ArrayList<>();
        list.add(savingAccount.getInfoToCSV());
        try {
            ReadAndWriteFileBank.writeListStringToCSV(SAVING_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }
    @Override
    public boolean delete(int idAccount){
        boolean isSuccessDelete = false;
        List<SavingAccount> savingAccounts = getAll();
        for (SavingAccount s : savingAccounts){
            if (s.getIdAccount()==idAccount){
                savingAccounts.remove(s);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (SavingAccount s : savingAccounts){
            stringList.add(s.getInfoToCSV());
        }
        try {
            ReadAndWriteFileBank.writeListStringToCSV(SAVING_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
        }
        return isSuccessDelete;
    }
    @Override
    public SavingAccount find(int idAccount){
        List<SavingAccount> savingAccountList = getAll();
        for (SavingAccount s : savingAccountList){
            if (s.getIdAccount()==idAccount){
                return s;
            }
        }
        return null;
    }
}
