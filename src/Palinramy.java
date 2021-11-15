
public class Palinramy {

//    public static String findLongestPalindram(String word){
//
//        // Onecnie najlepszy wynik na start pusty wyraz
//        String longestPalindram = "";
//
//        for (int i=0; i<word.length(); i++){
//            String proposed;
//            //Podsłowo i liter z lewej aż do końca
//            String subword = word.substring(i);
//            // System.out.println("Analizowane podsłowo: " + subword);
//            proposed = analyzeSubstring(subword);
//            if (proposed.length() > longestPalindram.length()){
//                longestPalindram = proposed;
//            }
//        }
//        return longestPalindram;
//    }
//
//    public static String analyzeSubstring(String word){
//        int index = word.length();
//
//        while (index > 0){
//            String substring = word.substring(0, index);
//            // System.out.print("  Analizowane podsłowo " + substring);
//            if (!isPalindram(substring)){
//                index--;
//                // System.out.println(" czy to palindram " + false);
//            }
//            else{
//                //System.out.println(" czy to palindram " + true);
//                return substring;
//            }
//        }
//        return "";
//    }
//
//    public static boolean isPalindram(String word){
//        int lewa = 0;
//        int prawa = word.length()-1;
//        while(prawa > lewa){
//            if (word.charAt(lewa) != word.charAt(prawa)){
//                return false;
//            }
//            prawa --;
//            lewa ++;
//        }
//        return true;
//    }


    public static void main(String[] args) {
        //Tutaj odpala się program
        String word = "okoajaka";

    }
}
