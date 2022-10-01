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
        int opcion,lugar;
        System.out.println("Practica nodos\n ¿Qué desea hacer?\n");
        do{
            System.out.println("\n1) Insertar nodo al principio\n" +
                    "2) Insertar nodo al final\n" +
                    "3) Intertar nésimo\n" +
                    "4) Sumar el primero con el último\n" +
                    "5) Sumar el primer par con el ultimo par\n" +
                    "6) Imprimir la lista\n" +
                    "7) Imprimir los pares\n" +
                    "8) Imprimir los primos\n" +
                    "0) salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Valor del nodo");
                    lista.agregarNodoPrincipio(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Valor del nodo");
                    lista.agregarNodoFinal(sc.nextInt());
                    break;
                case 3:
                    System.out.println("En que lugar?");
                    lugar = sc.nextInt();
                    System.out.println("Valor del nodo");
                    lista.agregarNesimo(lugar, sc.nextInt());
                    break;
                case 4:
                    lista.sumaPrimeroUltimo();
                    break;
                case 5:
                    lista.sumarPrimerParUltimoPar();
                    break;
                case 6:
                    lista.imprimirLista();
                    break;
                case 7:
                    lista.imprimirPares();
                    break;
                case 8:
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
            if(vacio())
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
            if(vacio())
                primero = nuevo;
            else{
                temporal = primero;
                while(temporal.siguiente != null)
                    temporal = temporal.siguiente;
                temporal.siguiente = nuevo;
            }
        }
        public void agregarNesimo(int lugar, int valor){
            nodo tamanoNodo = new nodo();
            int tamano=0;
            tamanoNodo = primero;
            while (tamanoNodo!=null) {
                tamanoNodo = tamanoNodo.siguiente;
                tamano++;
            }
            if(lugar<=tamano){
                if (vacio() || lugar==1)
                    agregarNodoPrincipio(valor);
                else{
                    nodo temporal = primero;
                    nodo nuevoNodo = new nodo();
                    for (int i = 0; i <(lugar-2); i++)
                        temporal = temporal.siguiente;
                    nuevoNodo.info = valor;
                    nuevoNodo.siguiente = temporal.siguiente;
                    temporal.siguiente = nuevoNodo;
                }
            }else System.out.println("El lugar debe ser menor");
        }
        public void sumaPrimeroUltimo(){
            nodo temporal = new nodo();
            temporal = primero;
            int primero=0,ultimo=0;
            if(vacio()){
                System.out.println("La lista está vacía");
            }else{
                primero = temporal.info;
                while (temporal.siguiente!=null)
                    temporal = temporal.siguiente;
                ultimo = temporal.info;
                System.out.println("La suma del primero y del ultimo es: "+(primero+ultimo));
            }
        }
        public void sumarPrimerParUltimoPar(){
            int primerPar=0, ban2=0, ultimoPrimo=0;
            nodo temporal = new nodo();
            temporal=primero;
            if (vacio())
                System.out.println("La lista está vacía");
            else {
                while (temporal != null) {
                    if (temporal.info % 2 == 0 && ban2 == 0) {
                        primerPar = temporal.info;
                        ban2 = 1;
                    }
                    if (temporal.info % 2 == 0 && ultimoPrimo != temporal.info)
                        ultimoPrimo = temporal.info;
                    temporal = temporal.siguiente;
                }
                System.out.println("La suma de primer par y el ultimo par es : " + (primerPar + ultimoPrimo));
            }
        }
        public void imprimirLista(){
            nodo temporal = new nodo();
            temporal = primero;
            if (vacio())
                System.out.println("La lista está vacía");
            else{
                while (temporal != null) {
                    System.out.println(temporal.info);
                    temporal = temporal.siguiente;
                }
            }
        }
        public void imprimirPares(){
            nodo temporal = new nodo();
            temporal = primero;
            if (vacio())
                System.out.println("La lista está vacía");
            else{
                while(temporal!=null) {
                    if (temporal.esPar())
                        System.out.println("Es par: " + temporal.info);
                    temporal = temporal.siguiente;
            }
            }
       }
       public void imprimirPrimos(){
            nodo temporal = new nodo();
            temporal = primero;
            if (vacio())
                System.out.println("La lista está vacía");
            else{
                while (temporal!=null) {
                    if (temporal.esPrimo())
                        System.out.println("Es primo: " + temporal.info);
                    temporal = temporal.siguiente;
                }
            }
       }
       public Boolean vacio(){
            return (primero==null);
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