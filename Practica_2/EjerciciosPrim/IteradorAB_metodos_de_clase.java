
public class IteradorAB_metodos_de_clase {

    public IteradorAB_metodos_de_clase(){}
    public void iteracionConFor_(int a, int b){
        int i;
        for (i=a;i<=b;i++){
            System.out.println(i);
        }
    }
    public void iteracionConWhile_(int a, int b){
        int i=a;
        while (i<=b){
            System.out.println(i);
            i++;
        }
    }

    public void recursivo_(int a, int b){ //le hacemos una modificacion de a>=b y hacemos que b aumente en uno
        if (a>=b){
            System.out.println(b+" ");
            recursivo_(a,b+1);
        }
    }
}
