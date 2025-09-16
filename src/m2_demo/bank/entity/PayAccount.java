package m2_demo.bank.entity;

public class PayAccount extends BankAccounts{
    private int idNumber;
    private int moneyAccount;

    public PayAccount(int idAccount, String owner, String date,int idNumber, int moneyAccount) {
        super(idAccount, owner, date);
        this.idNumber = idNumber;
        this.moneyAccount = moneyAccount;
    }

    public PayAccount(int id, int idAccount, String owner, String date, int idNumber, int moneyAccount) {
        super(id, idAccount, owner, date);
        this.idNumber = idNumber;
        this.moneyAccount = moneyAccount;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public int getMoneyAccount() {
        return moneyAccount;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setMoneyAccount(int moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+
                ","+this.getIdAccount()+
                ","+this.getOwner()+
                ","+this.getDate()+
                ","+this.getIdNumber()+
                ","+this.getMoneyAccount();
    }

    @Override
    public String toString() {
        return "Pay Account {"+super.toString()+
                ", "+getIdNumber()+
                ", "+ getMoneyAccount();
    }
}
