

public class Multiplos {
   public Multiplos(){}

    public int[] getMultiplos (int n){
       int i,multiplo;
       int [] vector= new int[n];
       for (i=0;i<n;i++) {
           multiplo=(n*(i+1));
           vector[i]=multiplo;
       }

       return vector;
       }


    }

