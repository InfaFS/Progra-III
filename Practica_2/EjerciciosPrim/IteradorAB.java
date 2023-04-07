

public class IteradorAB {
    public static void main(String[] args) {
        System.out.println("Arranca iteracion con for...");
        IteradorAB it1= new IteradorAB();
        it1.iteracionConFor(2,7);
        //
        System.out.println("Arranca iteracion con while...");
        IteradorAB it2= new IteradorAB();
        it2.iteracionConWhile(2,7);
        //
        System.out.println("Arranca impresion recursiva...");
        IteradorAB it3= new IteradorAB();
        it3.recursivo(2,7);
    }
    public void iteracionConFor(int a, int b){
        int i;
        for (i=a;i<=b;i++){
            System.out.println(i);
        }
    }
    public void iteracionConWhile(int a, int b){
        int i=a;
        while (i<=b){
            System.out.println(i);
            i++;
        }
    }
    public void recursivo(int a, int b){
        if (a<=b){
            System.out.println(a +" ");
            recursivo(a+1,b);
        }
    }
}