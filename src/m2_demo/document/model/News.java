package m2_demo.document.model;

public class News extends Document{
    private int numberProduce;
    private int monthProduce;

    public News(String idDocument, String nameDocument, String year, String compose, int numberProduce, int monthProduce) {
        super(idDocument, nameDocument, year, compose);
        this.numberProduce = numberProduce;
        this.monthProduce = monthProduce;
    }

    public News(int id, String idDocument, String nameDocument, String year, String compose, int numberProduce, int monthProduce) {
        super(id, idDocument, nameDocument, year, compose);
        this.numberProduce = numberProduce;
        this.monthProduce = monthProduce;
    }

    public int getNumberProduce() {
        return numberProduce;
    }

    public int getMonthProduce() {
        return monthProduce;
    }

    public void setNumberProduce(int numberProduce) {
        this.numberProduce = numberProduce;
    }

    public void setMonthProduce(int monthProduce) {
        this.monthProduce = monthProduce;
    }

    @Override
    public String getInfoCSV() {
        return this.getId()+
                ","+this.getIdDocument()+
                ","+this.getNameDocument()+
                ","+this.getYear()+
                ","+this.getCompose()+
                ","+this.getNumberProduce()+
                ","+this.getMonthProduce();
    }

    @Override
    public String toString() {
        return "News {"+super.toString()+
                ", "+getNumberProduce()+
                ", "+getMonthProduce()+
                "}";
    }
}
