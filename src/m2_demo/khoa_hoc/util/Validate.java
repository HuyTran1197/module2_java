package m2_demo.khoa_hoc.util;

public class Validate {
    public static boolean checkIdCode(String id){
        String idService = "^CO-[0-9]{4}$";
        return id.matches(idService);
    }

    public static boolean checkIdLanguage(String id){
        String idService = "^LA-[0-9]{4}$";
        return id.matches(idService);
    }

    public static boolean checkNameStudy(String name){
        String nameSer = "^[A-Z][a-z]+(\\s[a-z]+)+$";
        return name.matches(nameSer);
    }

    public static boolean checkLanguageCode(String name){
        String nameRegex = "^[A-Z][a-z]+$";
        return name.matches(nameRegex);
    }

    public static boolean checkNameTeacher(String name){
        String nameRegex = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return name.matches(nameRegex);
    }

    public static boolean checkLevel(String lv){
        String lvRegex = "^A[0-9]$";
        return lv.matches(lvRegex);
    }
}
