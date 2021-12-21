public class GenerycznyTest {

    public static void main(String[] args) {

        GenerycznaLista<Gracz> listaGraczy = new GenerycznaLista<Gracz>();
        listaGraczy
                .add(new Gracz(13, "hubo"))
                .add(new Gracz(43, "vndasd"))
                .add(new Gracz(43253455, "vndasd"))
                .showAll();

    }


}
