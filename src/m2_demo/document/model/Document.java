package m2_demo.document.model;

public abstract class Document {
    private int id;
    private String idDocument;
    private String nameDocument;
    private String year;
    private String compose;

    public Document(String idDocument, String nameDocument, String year, String compose) {
        this.idDocument = idDocument;
        this.nameDocument = nameDocument;
        this.year = year;
        this.compose = compose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Document(int id, String idDocument, String nameDocument, String year, String compose) {
        this(idDocument, nameDocument, year, compose);
        this.id = id;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public String getYear() {
        return year;
    }

    public String getCompose() {
        return compose;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCompose(String compose) {
        this.compose = compose;
    }

    public abstract String getInfoCSV();

    @Override
    public String toString() {
        return "id: "+getId()+
                ", id document: "+getIdDocument()+
                ", name document: "+getNameDocument()+
                ", year: "+getYear()+
                ", compose: "+getCompose();
    }
}
