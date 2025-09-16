package m2_demo.bank.entity;

public abstract class BankAccounts {
    private int id;
    private int idAccount;
    private String owner;
    private String date;

    public BankAccounts(int idAccount, String owner, String date) {
        this.idAccount = idAccount;
        this.owner = owner;
        this.date = date;
    }

    public BankAccounts(int id, int idAccount, String owner, String date) {
        this(idAccount,owner,date);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public String getOwner() {
        return owner;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public abstract String getInfoToCSV();
    @Override
    public String toString() {
        return "id: "+getId()+
                ", id account: "+getIdAccount()+
                ", owner: "+getOwner()+
                ", date: "+getDate()
                ;
    }
}
