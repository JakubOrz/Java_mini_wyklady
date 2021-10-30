import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

class Przystanek{
    private static final LocalDate[] swieta = {
            LocalDate.of(0,12, 25),
            LocalDate.of(0, 11, 11)
    };
        //tablica rozkładów
    private static final LocalTime[][] rozklad_normalny = {
            //linia 1
            {
                LocalTime.of(1,2),
                LocalTime.of(5, 44)
            },
            //linia 2
            {
                LocalTime.of(1, 34),
                LocalTime.of(4, 23)
            }
    };

}


public class Main {

    public static void main(String[] args) {
        Scanner czytacz = new Scanner(System.in);

        LocalDateTime dataDzis = LocalDateTime.now();
        DayOfWeek dayofweek = dataDzis.getDayOfWeek();

        if (dayofweek.getValue() >= 6){
            System.out.println("Weekend");
            //wypisuje         dzień tygodnia według    styl wypisz wszystko Locale = lokalizacja u nas polska
            System.out.println(dayofweek.getDisplayName(TextStyle.FULL, Locale.GERMAN));
        }
        else{
            System.out.println("Mamy zwykły dzień tygodnia");
        }

        DateTimeFormatter formatGodzinowy = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Wpisz TAK jeśli mam pokazać aktualną godzinę");
        String command = czytacz.next();
        if (command.equals("TAK")){
            System.out.println(dataDzis.format(formatGodzinowy));
        }




        //przełącznik
//        switch (command){
//            case "tak":
//                System.out.println("Okej działam");
//                break;
//            case "może":
//                // do the stuff
//                break;
//            case "nie":
//                break;
//            default:
//                System.out.println("Pierdol sie");
//        }

    }
}
