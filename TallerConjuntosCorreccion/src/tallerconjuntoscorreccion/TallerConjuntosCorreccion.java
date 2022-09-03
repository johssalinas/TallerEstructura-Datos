package tallerconjuntoscorreccion;

import java.util.Scanner;

/**
 * @authores Johs Brayan Salinas Lopez - Yhon Jairo Ochoa Mayorga
 */
public class TallerConjuntosCorreccion {
    
        //Ingresa los datos y los guarda en Scanner
    public static int input(String a){
        System.out.print(a);
        return new Scanner(System.in).nextInt();
    } 
    
        //Imprime los datos
    public static void output(Conjunto a){
        for(int i = 0; i<a.contador;i++)System.out.print(a.items[i] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conjunto primerConjunto,segundoConjunto;
        
        primerConjunto=new Conjunto();
        segundoConjunto=new Conjunto();
        
        /************ 
        *    Menú
        *************/
        System.out.println("\t¿Qué operacion desea realizar?");
        System.out.println("\t1) Union");
        System.out.println("\t2) Interseccion");
        System.out.println("\t3) Diferencia simetrica");
        System.out.println("\t4) Pertenece");
        System.out.println("\t5) Incluido");
        int seleccion = sc.nextInt();
        switch(seleccion){
            case 1:
                pedirDatos(primerConjunto); pedirDatos(segundoConjunto);
                output((primerConjunto.union(segundoConjunto)));
                break;
            case 2:
                pedirDatos(primerConjunto); pedirDatos(segundoConjunto);
                output((primerConjunto.interseccion(segundoConjunto)));
                break;
            case 3:
                pedirDatos(primerConjunto); pedirDatos(segundoConjunto);
                output(primerConjunto.diferenciaSimetrica(segundoConjunto));                
                break;
            case 4:
                // Pide los datos del primer conjunto y un número para saber si está dentro del primer conjunto
                pedirDatos(primerConjunto);
                int numeroPertenece = input("\n\tDigita un número ");
                    if(primerConjunto.pertenece(numeroPertenece)) System.out.println(numeroPertenece+" SÍ pertenece al conjunto");
                    else System.out.println(numeroPertenece+" NO pertenece al conjunto");
                    break;
            case 5:
                pedirDatos(primerConjunto); pedirDatos(segundoConjunto);
                if(primerConjunto.incluido(segundoConjunto))System.out.println("B SÍ está incluido en A: ");
                else System.out.println("B NO está incluido en A: ");
                break;
            default:
                System.out.println("Digite un valor válido");
        }        
    }
    
    /*
    * Metodo para pedir los valores del vector
    * Se ejecuta el bucle hasta que el valor digitado sea menor a 15
    */
    public static void pedirDatos(Conjunto conjuntoRecibido){
        int elementos;
        do 
            elementos = input("\n\tDigita la cantidad de elementos del conjunto (debe ser menor a 15) "); 
        while(elementos >15);
        conjuntoRecibido.contador = elementos;
        for(int i = 0; i < conjuntoRecibido.contador; i++)
        conjuntoRecibido.items[i] = input("Digite el elemento " +(i+1) +" del conjunto "); 
    }
    
    public static class Conjunto{
        public int items[];
        public int contador;
        
        public Conjunto(){
            items = new int[15];
        }
        public Conjunto (int v[]){
            items = v;
        }
        /*
        * Guarda el valor del conjunto inmerso en un objeto auxiliar, luego recorre el segundo conjunto
        * y guarda en el auxiliar los valores que están en ambos conjuntos pero sin repetirlos
        */
        public Conjunto union(Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            auxConjunto.contador=0;
            for(int i=0;i<contador;i++){
                if(!auxConjunto.encontrar(items[i])) auxConjunto.items[auxConjunto.contador++]=items[i];
            }
            for(int i=0; i<conjuntoRecibido.contador; i++) auxConjunto.items[auxConjunto.contador++] = conjuntoRecibido.items[i];
            return auxConjunto;
        }
        
        /*
        * Guarda en un objeto auxiliar los valores que se repiten en ambos conjuntos
        */
        public Conjunto interseccion (Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            auxConjunto.contador=0;
            for(int i=0; i< conjuntoRecibido.contador; i++){
                if(encontrar(conjuntoRecibido.items[i])) auxConjunto.items[auxConjunto.contador++] = conjuntoRecibido.items[i];
            }
            return auxConjunto;
        }
        
        /*
        * Guarda en un objeto auxiliar los valores que NO se repiten en ambos conjuntos 
        */
        public Conjunto diferenciaSimetrica (Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            auxConjunto.contador=0;
            //Guarda dentro del auxiliar el valor del conjunto inmerso
            for(int i=0; i< contador; i++){
                if(!conjuntoRecibido.encontrar(items[i])) auxConjunto.items[auxConjunto.contador++] = items[i];
            }
            
            //Guarda dentro del auxiliar el valor del conjunto recibido
            for(int i=0; i< conjuntoRecibido.contador; i++){
                if(!encontrar(conjuntoRecibido.items[i])) auxConjunto.items[auxConjunto.contador++] = conjuntoRecibido.items[i];
            }
            return auxConjunto;
        }
        
        /*
        * Valida si el numero digitado existe dentro del conjunto inmerso
        */
        public boolean pertenece(int valorRecibido){
            return encontrar(valorRecibido);
        }
        
        /*
        * Valida si cada valor del elemento enviado existe dentro de los valores del conjunto inmerso
        */
        public boolean incluido(Conjunto conjuntoRecibido){
            for(int i=0;i<=conjuntoRecibido.contador;i++){
                if(!encontrar(conjuntoRecibido.items[i])) return false;
            }
            return true;
        }
        
        //Recorre el array y retorna true cuando el valor existe en el conjunto
        public boolean encontrar(int conjuntoRecibido){
            for(int i=0; i<items.length;i++)
                if(conjuntoRecibido == items[i]) return true;
            return false;
        }
    }
}
