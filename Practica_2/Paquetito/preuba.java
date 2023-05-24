public class preuba{


    public static void main(String[] args) {
        
        int i,j,n;
        
        int suma=1;

        n=4;

        for (i=1;i<=n;i++){
            for (j=1;j<=i;j++){
                suma=2*suma;
            }
        }

        System.out.println("El valor de suma es "+ suma);
    }




}