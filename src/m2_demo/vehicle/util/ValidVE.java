package m2_demo.vehicle.util;

public class ValidVE {
    public static boolean checkId(String id){
        String idRegex = "^V-[0-9]{4}$";
        return id.matches(idRegex);
    }
    public static boolean checkBrand(String regex){
        String nameRegex = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
        return regex.matches(nameRegex);
    }
    public static boolean checkType(String t){
        String tRegex = "^\\w+$";
        return t.matches(tRegex);
    }
}
