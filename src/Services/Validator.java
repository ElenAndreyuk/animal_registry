package Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Validator {
    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public void validate (String [] data){



        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for (int i=0; i < data.length; i++){
            try{
                 isValidDate (data[i]);

            } catch (RuntimeException e){
                sb.append ("\n");
                sb.append(e.getMessage());
                flag = false;
            }
        }
        if (flag == false){
            throw new RuntimeException(sb.toString());
        }
    }

    private boolean isValidDate (String birthday)  {



        LocalDate date;
        Integer [] month_30 = {4, 6, 9, 11};
        int day;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = LocalDate.parse(birthday, formatter);
            day = date.getDayOfMonth();

        } catch (Exception e) {
            throw new RuntimeException("некорректный формат даты");
        }

        if ((Arrays.asList(month_30).contains(date.getMonthValue()) && day > 30) ||
                (date.isLeapYear() && date.getMonthValue() == 2 && day > 29) ||
                (!date.isLeapYear() && date.getMonthValue() == 2 && day > 28)) {

            throw new RuntimeException("введена некорректная дата рождения");

        } else
            return true;
    }
}
