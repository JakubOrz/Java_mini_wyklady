import java.util.Hashtable;
import java.util.Timer;

public class main2 {

    public static void main(String[] args) {
        Palindrome p1 = new Palindrome("kobyłamamałybok");
        Palindrome p2 = new Palindrome("kobyła ma mały bok!");
        Palindrome p3 = new Palindrome("elf układał kufle");
        System.out.println(p1);
        System.out.println(p3 + " " + p3 + p3);

        Palindrome.ileRazyBylToString();

    }
}
