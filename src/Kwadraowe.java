public class Kwadraowe {

    //calculate root dla 3 floatów
    public static void calculateRoot(float a, float b, float c){
        //System.out.println("Wykonuje się dla 3 argumentów");
        if (a == 0){
            calculateRoot(b, c);
        }
        float delta = (b * b) - (4 * a * c);
        if (delta < 0){
            System.out.println("Nie ma rozwiązania");
        }
        else if (delta == 0){
            float result = -b / (2 * a);
            System.out.println("Istnieje jedno miejsce zerowe x0 = " + result);
        }
        else{
            delta = (float) Math.sqrt(delta);
            float result1 = (-b - delta) / (2 * a);
            float result2 = (-b + delta) / (2 * a);
            System.out.println("Istnieją dwa miejsca zerowe x1 = " + result1 + " x2= " + result2);
        }
    }

    public static void calculateRoot(float a, float b){
        //System.out.println("Wykonuje się dla 2 argumentów");
        if (a == 0){
            System.out.println("Nie ma miejsca zerowego");
            return;
        }
        float result = -b / a;
        System.out.println("Miejsce zerowe jest dla x = " + result);
    }


    public static void main(String[] args) {
        calculateRoot(2.4f, 3.4f);
        calculateRoot(3.2f, -23.2f, 1f);
        calculateRoot(1f, 3.2f, 1f);

    }


}
