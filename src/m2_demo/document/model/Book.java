package m2_demo.document.model;

public class Book extends Document{
    private int page;
    private String type;

    public Book(String idDocument, String nameDocument, String year, String compose, int page, String type) {
        super(idDocument, nameDocument, year, compose);
        this.page = page;
        this.type = type;
    }

    public Book(int id, String idDocument, String nameDocument, String year, String compose, int page, String type) {
        super(id, idDocument, nameDocument, year, compose);
        this.page = page;
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public String getType() {
        return type;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getInfoCSV() {
        return this.getId()+
                ","+this.getIdDocument()+
                ","+this.getNameDocument()+
                ","+this.getYear()+
                ","+this.getCompose()+
                ","+this.getPage()+
                ","+this.getType();
    }

    @Override
    public String toString() {
        return "Book {"+super.toString()+
                ", "+getPage()+
                ", "+getType()+
                "}";
    }
}
