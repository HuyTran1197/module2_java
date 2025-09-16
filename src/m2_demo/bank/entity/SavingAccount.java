package m2_demo.bank.entity;

public class SavingAccount extends BankAccounts{
    private int savingMoney;
    private String sentDate;
    private int rate;
    private int term;

    public SavingAccount(int idAccount, String owner, String date, int savingMoney, String sentDate, int rate, int term) {
        super(idAccount, owner, date);
        this.savingMoney = savingMoney;
        this.sentDate = sentDate;
        this.rate = rate;
        this.term = term;
    }

    public SavingAccount(int id, int idAccount, String owner, String date, int savingMoney, String sentDate, int rate, int term) {
        super(id, idAccount, owner, date);
        this.savingMoney = savingMoney;
        this.sentDate = sentDate;
        this.rate = rate;
        this.term = term;
    }

    public int getSavingMoney() {
        return savingMoney;
    }

    public String getSentDate() {
        return sentDate;
    }

    public int getRate() {
        return rate;
    }

    public int getTerm() {
        return term;
    }

    public void setSavingMoney(int savingMoney) {
        this.savingMoney = savingMoney;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+
                ","+this.getIdAccount()+
                ","+this.getOwner()+
                ","+this.getDate()+
                ","+this.getSavingMoney()+
                ","+this.getSentDate()+
                ","+this.getRate()+
                ","+this.getTerm();
    }

    @Override
    public String toString() {
        return "Saving Account {"+super.toString()+
                ", "+getSavingMoney()+
                ", "+getSentDate()+
                ", "+getRate()+
                ", "+getTerm()+"}";
    }
}
