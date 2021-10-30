
public class Samochod {
    private static int wyprodukowane_auta = 0;
    private String marka;
    private int przebieg;

    public Samochod(String marka, int przebieg){
        wyprodukowane_auta ++;
        this.marka = marka;
        this.przebieg = przebieg;
    }

    public void przebijlicznik(int przebicie){
        this.przebieg -= przebicie;
    }

    public void opiszSie(){
        System.out.println("Jestem samochodem marki "+ marka +" i mam przebieg " + przebieg);
    }

    public static void kurvix(){
        System.out.println("Auto z galaktyki kurvix");
    }

    public static int ileAut(){
        return wyprodukowane_auta;
    }


}
