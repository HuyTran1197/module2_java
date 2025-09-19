package m2_demo.bank.util;

public class Validate {
    public static boolean checkDate(String regex){
        String stringDate = "^[0-9]+\\/[0-9]+\\/[0-9]{4}$";
        return regex.matches(stringDate);
    }
}
