package m2_demo.furama_resort.util;

public class Validate {
    public static boolean checkEmail(String regex){
        String emailRegex = "^[A-Za-z0-9]+[@][A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        return regex.matches(emailRegex);
    }

    public static boolean checkId(String id){
        String idRegex = "^NV-[0-9]{4}$";
        return id.matches(idRegex);
    }

    public static boolean checkName(String name){
        String nameRegex = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return name.matches(nameRegex);
    }

    public static boolean checkBirthday(String born){
        String bornRegex = "^[0-9]+\\/[0-9]+\\/[0-9]{4}$";
        return born.matches(bornRegex);
    }

    public static boolean checkPhone(String phone){
        String phoneRegex = "^0[0-9]{9}$";
        return phone.matches(phoneRegex);
    }

    public static boolean checkIdPerson(String id){
        String idPerson = "^\\d{9,12}$";
        return id.matches(idPerson);
    }

    public static boolean checkIdVL(String id){
        String idService = "^SVVL-[0-9]{4}$";
        return id.matches(idService);
    }

    public static boolean checkIdHO(String id){
        String idService = "^SVHO-[0-9]{4}$";
        return id.matches(idService);
    }

    public static boolean checkIdRO(String id){
        String idService = "^SVRO-[0-9]{4}$";
        return id.matches(idService);
    }

    public static boolean checkService(String name){
        String nameSer = "^[A-Z][a-z]+$";
        return name.matches(nameSer);
    }
}
