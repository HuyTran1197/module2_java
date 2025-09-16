package ss18_string_regex.thuc_hanh;

public class EmailTest {
    private static CheckEmail checkEmail;
    private static final String[] validEmail = new String[]{"wasd@gmail.com","a@yahoo.com","0511@hotmail.com"};
    private static final String[] inValidEmail = new String[]{"@gmail.com","a@yahoo.","@#avshotmail.com"};

    public static void main(String[] args) {
        checkEmail = new CheckEmail();
        for (String e : validEmail){
            boolean isValid = checkEmail.validate(e);
            System.out.println("Email "+e+" is valid : "+isValid);
        }
        for (String e : inValidEmail){
            boolean isInvalid  = checkEmail.validate(e);
            System.out.println("Email "+e+" is valid : "+isInvalid);
        }
    }
}
