

public class Main {
    public static void main(String[] args) {
        int[] vector_main= new int[0]; //ver como podria hacerlo sin tener que poner el valor 0
        System.out.println("Comienza el uso de los metodos de la clase iteradorAB_metodos_de_clase...");
        IteradorAB_metodos_de_clase a = new IteradorAB_metodos_de_clase();
        System.out.println("------------------");
        a.iteracionConFor_(2,7);
        System.out.println("------------------");
        a.iteracionConWhile_(2,7);
        System.out.println("------------------");
        a.recursivo_(7,2);
        System.out.println("Carga de vector con multiplos de N(lo pones manual)");
        Multiplos M= new Multiplos();
       vector_main=M.getMultiplos(4);
       for (int i=0;i<4;i++) {
            System.out.println(vector_main[i]);
       }
       }

}
