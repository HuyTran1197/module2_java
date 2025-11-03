package m2_demo.practice_java.practice4.StudentsManagement_2;

public class Valid {
    public static boolean checkId(String id){
        String idRegex = "^V-[0-9]{4}$";
        return id.matches(idRegex);
    }
    public static boolean checkBrand(String regex){
        String nameRegex = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
        return regex.matches(nameRegex);
    }
}
