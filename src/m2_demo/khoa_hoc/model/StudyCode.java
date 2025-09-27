package m2_demo.khoa_hoc.model;

public class StudyCode extends ClassStudy{
    private String languageCode;

    public StudyCode(String idCLass, String nameClass, String teacher, long cost, String languageCode) {
        super(idCLass, nameClass, teacher, cost);
        this.languageCode = languageCode;
    }

    public StudyCode(int id, String idCLass, String nameClass, String teacher, long cost, String languageCode) {
        super(id, idCLass, nameClass, teacher, cost);
        this.languageCode = languageCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String getInfoCSV() {
        return this.getId()+
                ","+this.getIdCLass()+
                ","+this.getNameClass()+
                ","+this.getTeacher()+
                ","+this.getCost()+
                ","+this.getLanguageCode();
    }

    @Override
    public String toString() {
        return "Study code {"+super.toString()+
                ", "+getLanguageCode()
                +"}";
    }
}
