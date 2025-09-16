package ss18_string_regex.validate;

public class CheckValidate {
    public static boolean checkNameClass(String name){
        String regexName = "^[ACP]+[0-9]{4}[GHIK]+$";
        return name.matches(regexName);
    }

    public static boolean checkNumber(String stringNumber){
        String regexNumber ="^[(0-9)]{4}-+[(0]{2}[0-9]{9}[)]$";
        return stringNumber.matches(regexNumber);
    }
}
