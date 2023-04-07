
import java.util.Scanner;
public class MultiplosModif_ej4 {
    public static void main(String[] args) {
        int n;
        int[] vector_main= new int[0];
        Multiplos M = new Multiplos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Carga de vector con multiplos de n(-1 para salir): ");
        n= scanner.nextInt();
        while (n!=-1) {
            M=new Multiplos();
            vector_main = M.getMultiplos(n);
            System.out.println("Impresion-----------");
            for (int i = 0; i < n; i++) {
                System.out.println(vector_main[i]);
            }
            System.out.println("Carga de vector con multiplos de n(-1 para salir): ");
            n= scanner.nextInt();

        }
        scanner.close();

    }

}

