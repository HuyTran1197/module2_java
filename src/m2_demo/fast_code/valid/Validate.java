package m2_demo.fast_code.valid;

public class Validate {
    public static boolean checkEmail(String regex){
        String emailRegex = "^[A-Za-z0-9]+[@][A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        return regex.matches(emailRegex);
    }

    public static boolean checkId(String id){
        String idRegex = "^NV-[0-9]{4}$";
        return id.matches(idRegex);
    }

    public static boolean checkBirthday(String born){
        String bornRegex = "^[0-9]+\\/[0-9]+\\/[0-9]{4}$";
        return born.matches(bornRegex);
    }

    public static boolean checkName(String name){
        String nameRegex = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
        return name.matches(nameRegex);
    }
}
