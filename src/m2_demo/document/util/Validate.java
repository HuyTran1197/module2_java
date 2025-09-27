package m2_demo.document.util;

public class Validate {
    public static boolean checkIdBO(String id){
        String idService = "^BO-[0-9]{4}$";
        return id.matches(idService);
    }
    public static boolean checkIdNEW(String id){
        String idService = "^NEW-[0-9]{4}$";
        return id.matches(idService);
    }

    public static boolean checkNameDO(String name){
        String nameSer = "^[A-Z][a-z]+(\\s[a-z]+)+$";
        return name.matches(nameSer);
    }

    public static boolean checkName(String name){
        String nameRegex = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return name.matches(nameRegex);
    }

    public static boolean checkYear(String year){
        String yearRegex = "^[0-9]{4}$";
        return year.matches(yearRegex);
    }
}
