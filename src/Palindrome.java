import java.util.Hashtable;

public class Palindrome {
    private static int licznikToString = 0;
    public static int licznikHashCode = 0;
    /**
     * Tutaj przechowuję napis
     */
    private String palindrame;

    /**
     * Pozbawiony białych znaków
     */
    private String rawPalindrame;

    //konstruktor
    public Palindrome(String word){
        this.palindrame = word;
        this.rawPalindrame = makeRawPalindrame();
    }

    public String getPalindrame() {
        return palindrame;
    }

    public String getRawPalindrame() {
        return rawPalindrame;
    }

    public static void ileRazyBylToString(){
        System.out.println("Łącznie obikety klasy Palndrome użyły toString " + licznikToString + " razy");
    }

    public String makeRawPalindrame(){
        StringBuilder sb = new StringBuilder();
        //for Jakiego typu jest elemet w tablicy/kolecji : tablica/kolekcja
        //Dla każdego elementu w tablicy
        for (Character letter : palindrame.toCharArray()){
            if (Character.isLetter(letter)){
                //dodaje do Strig Buildera literę którą wiemie że nie jest białym znakiem
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        licznikToString ++;
        return palindrame;
    }

    @Override
    public boolean equals(Object obj) {
        //getClass() zwraca mi nazwę klasy jakiej jest object
        //sprawdzam czy obiekt z którym porównuję się jest takiej samej klasy to jest klasy Palindrame
        if (obj.getClass() != this.getClass()){
            //jeśli nie jest to wiem że nie są one równe
            return false;
        }
        else{
            //Skoro wiem że obiekt z którym się porównuję jest klasy Palindrame to mogę bezpiecznie dokonać rzutowania
            //sprawdzam czy pola rawpalindrome są sobie równe
            return ((Palindrome) obj).rawPalindrame.equals(this.rawPalindrame);
        }
    }

    @Override
    public int hashCode() {
        licznikHashCode++;
        return palindrame.hashCode();
    }

        public static String findLongestPalindram(String word){

        // Onecnie najlepszy wynik na start pusty wyraz
        String longestPalindram = "";

        for (int i=0; i<word.length(); i++){
            String proposed;
            //Podsłowo i liter z lewej aż do końca
            String subword = word.substring(i);
            // System.out.println("Analizowane podsłowo: " + subword);
            proposed = analyzeSubstring(subword);
            if (proposed.length() > longestPalindram.length()){
                longestPalindram = proposed;
            }
        }
        return longestPalindram;
    }

    private static String analyzeSubstring(String word){
        int index = word.length();

        while (index > 0){
            String substring = word.substring(0, index);
            // System.out.print("  Analizowane podsłowo " + substring);
            if (!isPalindram(substring)){
                index--;
                // System.out.println(" czy to palindram " + false);
            }
            else{
                //System.out.println(" czy to palindram " + true);
                return substring;
            }
        }
        return "";
    }

    private static boolean isPalindram(String word){
        int lewa = 0;
        int prawa = word.length()-1;
        while(prawa > lewa){
            if (word.charAt(lewa) != word.charAt(prawa)){
                return false;
            }
            prawa --;
            lewa ++;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome p1 = new Palindrome("kobyłamamałybok");
        Palindrome p2 = new Palindrome("kobyła ma mały bok!");
        Palindrome p3 = new Palindrome("elf układał kufle");
        System.out.println("p1 == p2 : " + (p1 == p2));
        System.out.println("p1.equals(p2) : " + p1.equals(p2));
        Hashtable<Palindrome, String> ps = new Hashtable<>();
        ps.put(new Palindrome("a car boso kokos obraca"), "Andrzej Pacierpnik");
        ps.put(p2, "autor nieznany");
        ps.put(new Palindrome("muzo, raz daj jad za rozum"), "Julian Tuwim");
        ps.put(p3, "Tadeusz Morawski");
        System.out.println("HashCode był użyty: " + licznikHashCode);
        System.out.println("Autorem palindromu " + p3 + " jest " + ps.get(p3));
        String word = "rrrrr abccba kobyłamamałybok";
        String longestPalindrome = findLongestPalindram(word);
        System.out.println("longestPalindrome: " + longestPalindrome);
        System.out.println("HashCode był użyty: " + licznikHashCode);
    }

}
