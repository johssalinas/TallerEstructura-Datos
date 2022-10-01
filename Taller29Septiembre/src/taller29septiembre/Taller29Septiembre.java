package taller29septiembre;
import java.util.Scanner;
/**
 * @author Johs Brayan Salinas López
 */
public class Taller29Septiembre {
    public static void main(String[] args) {
        Lista lista = new Lista();
        Scanner sc = new Scanner(System.in);
        lista.primero = null;
        int opcion;
        System.out.println("Practica nodos\n ¿Qué desea hacer?\n");
        do{
            System.out.println("\n1) Insertar nodo al principio\n" +
                    "2) Insertar nodo al final\n" +
                    "3) Sumar el primero con el último\n" +
                    "4) Sumar el primer par con el ultimo par\n" +
                    "5) Imprimir la lista\n" +
                    "6) Imprimir los pares\n" +
                    "7) Imprimir los primos\n" +
                    "0) salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Valor del nodo :");
                    lista.agregarNodoPrincipio(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Valor del nodo :");
                    lista.agregarNodoFinal(sc.nextInt());
                    break;
                case 3:
                    lista.sumaPrimeroUltimo();
                    break;
                case 4:
                    lista.sumarPrimerParUltimoPar();
                    break;
                case 5:
                    lista.imprimirLista();
                    break;
                case 6:
                    lista.imprimirPares();
                    break;
                case 7:
                    lista.imprimirPrimos();
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Digita un un número válido");
                    break;
            }
        }while(opcion !=0);
    }
    public static class Lista{
    nodo primero;
        public void agregarNodoPrincipio(int valor){
            nodo temporal = new nodo();
            nodo otro = new nodo();
            temporal.info = valor;
            temporal.siguiente = null;
            if(primero == null)
                primero = temporal;
            else{
                otro = primero;
                primero = temporal;
                primero.siguiente = otro;
            }
        }
        public void agregarNodoFinal(int valor){
            nodo nuevo = new nodo();
            nodo temporal = new nodo();
            nuevo.info = valor;
            nuevo.siguiente = null;
            if(primero == null)
                primero = nuevo;
            else{
                temporal = primero;
                while(temporal.siguiente != null)
                    temporal = temporal.siguiente;
                temporal.siguiente = nuevo;
            }
        }
        public void sumaPrimeroUltimo(){
            nodo temporal = new nodo();
            temporal = primero;
            int pr=0,ul=0;
            if(temporal!=null){
                pr = temporal.info;
                while (temporal.siguiente!=null)
                    temporal = temporal.siguiente;
                ul = temporal.info;
            }
            System.out.println("La suma del primero y del ultimo es: "+(pr+ul));
        }
        public void sumarPrimerParUltimoPar(){
            int primerPar=0, ban2=0, ultimoPrimo=0;
            nodo temporal = new nodo();
            temporal=primero;
            while(temporal!=null){
                if(temporal.info%2==0 && ban2==0){
                    primerPar = temporal.info;
                    ban2 = 1;
                }
                if(temporal.info%2==0 && ultimoPrimo != temporal.info)
                    ultimoPrimo = temporal.info;
                temporal = temporal.siguiente;
            }
            System.out.println("La suma de primer par y el ultimo par es : "+(primerPar + ultimoPrimo));
        }
        public void imprimirLista(){
            nodo temporal = new nodo();
            temporal = primero;
            while (temporal != null) {
                System.out.println(temporal.info);
                temporal = temporal.siguiente;
            }
        }
        public void imprimirPares(){
            nodo temporal = new nodo();
            temporal = primero;
            while(temporal!=null){
                if (temporal.esPar())
                    System.out.println("Es par: "+ temporal.info);
            temporal = temporal.siguiente;
            }
       }
       public void imprimirPrimos(){
            nodo temporal = new nodo();
            temporal = primero;
            while (temporal!=null){
                if (temporal.esPrimo())
                    System.out.println("Es primo: "+ temporal.info);
                temporal = temporal.siguiente;
            }
       }
    }
    private static class nodo{
    int info;
    nodo siguiente;
        public Boolean esPar(){
            return (info % 2 == 0);
        }
        public Boolean esPrimo(){
            return (info % 2 == 0 && info % 3 == 0 && info % 5 == 0 && info % 7 ==0 || (info == 1 || info ==2 || info == 3 || info ==5 || info ==7));
        }
    }
}