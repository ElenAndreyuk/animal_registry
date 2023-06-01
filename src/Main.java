import Controller.AnimalController;
import Model.Animal;
import Model.Cat;
import Services.AnimalRepository;
import Services.IRepository;
import View.View;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        IRepository<Animal> myFarm = new AnimalRepository();
        AnimalController animalController = new AnimalController(myFarm);
        View view = new View(animalController);
        animalController.start();




        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = parseDate("2022-03-03");
        Cat one = new Cat("Murzik", birthday);
    }
    
    public static boolean isDateValid(String date) // проверяем правильно ли введена дата
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
    static Date parseDate(String maybeDate) {
        Date date = null;

        // test date string matches format structure using regex
        // - weed out illegal characters and enforce 4-digit year
        // - create the regex based on the local format string
        String reFormat = Pattern.compile("d+|M+").matcher(Matcher.quoteReplacement(format)).replaceAll("\\\\d{1,2}");
        reFormat = Pattern.compile("y+").matcher(reFormat).replaceAll("\\\\d{4}");
        if ( Pattern.compile(reFormat).matcher(maybeDate).matches() ) {

            // date string matches format structure,
            // - now test it can be converted to a valid date
            SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance();
            sdf.applyPattern(format);
            sdf.setLenient(lenient);
            try { date = sdf.parse(maybeDate); } catch (ParseException e) { }
        }
        return date;
    }
}