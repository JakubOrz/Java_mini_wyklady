import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Samochod autko1 = new Samochod("bmw", 420);
        Samochod autko2 = new Samochod("volvo", 69);
        LocalDateTime data1 = LocalDateTime.now();
        DayOfWeek dayofweek = data1.getDayOfWeek();

        SimpleDateFormat dataformater = new SimpleDateFormat("HH:mm:ss");

        String[] linie = new String[]{"Hehe", "Hehe"};
        System.out.print(Arrays.toString(linie));
    }
}
