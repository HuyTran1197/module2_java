package m2_demo.company.util;

public class Valid {
    public static boolean checkDate(String regex){
        String stringDate = "^[0-9]+\\/[0-9]+\\/[0-9]{4}$";
        return regex.matches(stringDate);
    }
    public static boolean checkString(String regex){
        String nameRegex = "^[A-Z][a-z]+(\\s[a-z]+)*$";
        return regex.matches(nameRegex);
    }
    public static boolean checkBrand(String regex){
        String nameRegex = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
        return regex.matches(nameRegex);
    }
}
