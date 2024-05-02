import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Resistencia {
    static ArrayList<Double> resistencias = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {

        int cantidadDeResistencias = (int) Math.round(obtenerValor("Cuantas resistencias ingresaras?: "));
        for (int i = 0; i < cantidadDeResistencias ; i++) {
            resistencias.add(1/(obtenerValor("Ingresar valor de R"+ (i+1) +"(Mayor a CERO): ")));
        }
        resistencias.forEach(System.out::println);

        System.out.printf("La resistencia total es de %.1f", resistenciaTotal(resistencias, cantidadDeResistencias) );
    }

    private static Double obtenerValor(String message)throws IOException, InterruptedException{
        Double base = 0.0;
        do {

            try {
                System.out.print(message);
                base = sc.nextDouble();
            }catch(InputMismatchException e) {
                System.out.println("El valor debe que ser numérico...");
            }
            sc.nextLine();

        } while (base <= 0);
        return base;
    }

    private static Double resistenciaTotal(ArrayList<Double> resistencias, int totalResistencias){
        Double result = 0.0;
        for (int i = 0; i < totalResistencias; i++) {
            result += resistencias.get(i);
        }
        return (1/result);
    }
}