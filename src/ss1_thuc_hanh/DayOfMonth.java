package ss1_thuc_hanh;

import org.w3c.dom.ls.LSOutput;

public class DayOfMonth {
    int month;
    public DayOfMonth(int month){
        this.month = month;
    }
    public String getDaysInMonth() {
        String daysInMonth;
        switch (this.month){
            case 2:
                daysInMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = "30";
                break;
            default:
                daysInMonth = "";
        }
        if (daysInMonth.equals("")){
            return "invalid input";
        }
        return "The month " + this.month + "has" +daysInMonth + "days";
    }
    public void print(){
        System.out.println(getDaysInMonth());
    }
}
