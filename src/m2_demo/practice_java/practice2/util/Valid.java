package m2_demo.practice_java.practice2.util;

public class Valid {
    public static boolean checkName(String name){
        String nameRegex = "^\\w+(\\s\\w+)*$";
        return name.matches(nameRegex);
    }
    public static boolean checkId(String id){
        String idRegex = "^NPID-[0-9]{4}$";
        return id.matches(idRegex);
    }
}
