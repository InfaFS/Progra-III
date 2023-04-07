package Paquetito;



public class PruebaRetorno {

    public static void main(String[]args) {
        int[] arreglo = {1,5,7,3};
        //nunca METERLO CON NULL
        parametros parametro_ = new parametros();

        procesarArreglo2(arreglo,parametro_);

        System.out.println("El maximo, minimo y promedio son: "+ parametro_.getMaximo()+" " + parametro_.getMinimo()+ " " + parametro_.getPromedio());
    }
    public static void procesarArreglo2 (int[] v, parametros p)  {
        int i=0;
        int suma=0;
        int max=-1;
        int min=9999;
        for (i=0;i<4;i++) {
            suma += v[i];
            if (v[i] > max){
                max=v[i];

            }
            else if (v[i]<min){
                min=v[i];
            }
        }
        suma=suma/4;
        p.setPromedio(suma);
        p.setMaximo(max);
        p.setMinimo(min);
    }




}
