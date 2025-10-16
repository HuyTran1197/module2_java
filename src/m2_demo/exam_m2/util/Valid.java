package m2_demo.exam_m2.util;

public class Valid {
    public static boolean checkDate(String regex){
        String stringDate = "^[0-9]+\\/[0-9]+\\/[0-9]{4}$";
        return regex.matches(stringDate);
    }
    public static boolean checkBrand(String regex){
        String nameRegex = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
        return regex.matches(nameRegex);
    }
    public static boolean checkPhone(String phone){
        String phoneRegex = "^(0[0-9]{9,12})$";
        return phone.matches(phoneRegex);
    }
    public static boolean checkString(String regex){
        String nameRegex = "^[A-Z][a-z]+(\\s[a-z]+)*$";
        return regex.matches(nameRegex);
    }
    public static boolean checkEmail(String regex){
        String nameRegex = "^[A-Za-z0-9]+[@][A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        return regex.matches(nameRegex);
    }
}
