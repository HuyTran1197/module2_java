package m2_demo.khoa_hoc.model;

public class Language extends ClassStudy{
    private String languageTeach;
    private String level;

    public Language(String idCLass, String nameClass, String teacher, long cost, String languageTeach, String level) {
        super(idCLass, nameClass, teacher, cost);
        this.languageTeach = languageTeach;
        this.level = level;
    }

    public Language(int id, String idCLass, String nameClass, String teacher, long cost, String languageTeach, String level) {
        super(id, idCLass, nameClass, teacher, cost);
        this.languageTeach = languageTeach;
        this.level = level;
    }

    public String getLanguageTeach() {
        return languageTeach;
    }

    public String getLevel() {
        return level;
    }

    public void setLanguageTeach(String languageTeach) {
        this.languageTeach = languageTeach;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String getInfoCSV() {
        return this.getId()+
                ","+this.getIdCLass()+
                ","+this.getNameClass()+
                ","+this.getTeacher()+
                ","+this.getCost()+
                ","+this.getLanguageTeach()+
                ","+this.getLevel();
    }

    @Override
    public String toString() {
        return "Language {"+super.toString()+
                ", "+getLanguageTeach()+
                ", "+getLevel()+
                "}";
    }
}
