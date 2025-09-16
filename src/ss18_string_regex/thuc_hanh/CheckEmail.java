package ss18_string_regex.thuc_hanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
    private static Pattern pattern;
    private Matcher matcher;

    private final String REGEX_EMAIL = "^[A-Za-z0-9]+[@][A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public CheckEmail(){
        pattern = Pattern.compile(REGEX_EMAIL);
    }

    public boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
