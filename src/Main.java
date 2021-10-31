import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Przystanek{
    //stałe zwyczajowo pisze się z caps lockiem
    private static final DateTimeFormatter FORMATGODZINOWY = DateTimeFormatter.ofPattern("HH:mm");
    private static final Locale LOCATION = Locale.forLanguageTag("pl");

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
                LocalTime.of(4, 23),
                LocalTime.of(16, 32)
            }
    };

    public static void wyswietlRozklad(LocalDateTime dzien, int numer_lini){
        System.out.print("Rozkład jazdy dla linii numer "+ numer_lini );

        DayOfWeek dayOfWeek = dzien.getDayOfWeek();
        switch (dayOfWeek.getValue()){
            //sobota
            case 6:
                System.out.println(" - sobota");
                return;
            //niedziela
            case 7:
                System.out.println(" - niedziela");
                return;
            //normalny dzień
            default:
                System.out.println(" - dni powszednie");
                for (LocalTime godzinaOdjazdu : rozklad_normalny[numer_lini-1]){
                    System.out.println(godzinaOdjazdu.format(FORMATGODZINOWY));
                }
                return;
        }
    }

    public static void wyswietlKiedyKolejny(LocalDateTime data, int numer_lini){
        LocalTime czas = data.toLocalTime();
        LocalTime nastepny_autobus = null;
        for (LocalTime odjazd : rozklad_normalny[numer_lini-1]){
            //szukam w rozkładzie autobusu który jeszcze nie odjechał
            if (odjazd.isAfter(czas)){
                nastepny_autobus = odjazd;
                break;
            }
        }
        if (nastepny_autobus == null){
            System.out.println("Przykro mi ale dziś nie odjeżdża już autobus z tej linii");
        }
        else{
            long oczekiwane_godziny = ChronoUnit.HOURS.between(czas, nastepny_autobus);
            long oczekiwane_minuty = ChronoUnit.MINUTES.between(czas, nastepny_autobus) % 60;
            System.out.println("Następny autobus jest za "+
                    oczekiwane_godziny + ":" + oczekiwane_minuty);
        }

    }

    public static void wyswietlDzisiejszaDate(LocalDateTime data){
        System.out.println("Dziś jest "  +
                data.getDayOfWeek().getDisplayName(TextStyle.FULL, LOCATION) + " " +
                data.getDayOfMonth() + " " +
                data.getMonth().getDisplayName(TextStyle.FULL, LOCATION) + " " +
                data.getYear() + " godzina " +
                data.toLocalTime().format(FORMATGODZINOWY)
        );
    }
}

public class Main {

    public static void main(String[] args) {
        //skaner który czyta to co wpisujemy w konsolę
        Scanner czytacz = new Scanner(System.in);
        //Dzisiejsza data z dokładnością do nano sekundy
        LocalDateTime dataDzis = LocalDateTime.now();
        // Tego chyba nie muszę wyjaśniać
        System.out.println("Witam w moim prostym programie do rozkładów jazdy\n" +
                "Wybierz 1 aby wyświetlić rozkład jazdy\n" +
                "Wybierz 2 aby sprawdzić za ile przyjedzie kolejny autobus\n" +
                "Wybierz 3 aby sprawdzić obecną datę\n" +
                "Wybierz cokolwiek innego aby zakończyć"
        );

        //odczytanie decyzji użytkownika
        String command = czytacz.next();
        //Na podstawie tego co nam użytkownik dostarczył podejmujemy decyzję
        int numer_linii = 1;
        switch (command){
            case "1":
                System.out.println("Dobrze wybierz rozkład której linii chcesz zobaczyć 1 lub 2");
                numer_linii = Integer.parseInt(czytacz.next());
                Przystanek.wyswietlRozklad(dataDzis, numer_linii);
                break;
            case "2":
                System.out.println("Dobrze wybierz numer linii na którą oczekujesz 1 lub 2");
                numer_linii = Integer.parseInt(czytacz.next());
                Przystanek.wyswietlKiedyKolejny(dataDzis.plusDays(-2).minusHours(19), numer_linii);
                break;
            case "3":
                Przystanek.wyswietlDzisiejszaDate(dataDzis);
                break;
            default:
                //nic nie robi
        }

    }
}
