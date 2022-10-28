package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();
        Cola cola = new Cola();
        Cola otraCola = new Cola();
        Scanner sc = new Scanner(System.in);
        otraCola.primero = null;
        otraCola.ultimo = null;
        cola.primero = null;
        cola.ultimo = null;
        pila.primero = null;
        int opcion,lugar;
        System.out.println("Practica nodos\n ¿Qué desea hacer?\n");
        do{
            System.out.println("\n1) Acolar\n" +
                    "2) Desacolar\n" +
                    "3) Sumar el par más grande con el primer impar\n" +
                    "4) suma de primos\n" +
                    "5) Imprimir los primos\n" +
                    "0) salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Valor del nodo");
                    cola.acolar(sc.nextInt());
                    cola.acolar(6);
                    cola.acolar(2);
                    cola.acolar(3);
                    cola.acolar(9);
                    cola.acolar(8);
                    cola.acolar(10);
                    otraCola.acolar(11);
                    otraCola.acolar(12);
                    otraCola.acolar(13);
                    otraCola.acolar(14);
                    otraCola.acolar(15);
                    otraCola.acolar(16);
                    break;
                case 2:
                    System.out.println("Se eliminó "+ cola.desacolar().info);
                    break;
                case 3:
                    System.out.println("La suma es "+ cola.sumaParGrandePrimerImpar());
                    break;
                case 4:
                    cola.intercalarColas(otraCola);
                    System.out.println("La suma de los primos es: "+ pila.sumaPrimos());
                    break;
                case 5:
                    pila.imprimirLista();
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
    public static class Pila {
        nodo primero, ultimo;
        public void push(int valor){
            nodo nuevo = new nodo();
            nuevo.info = valor;
            nuevo.siguiente = null;
            if(vacio()) {
                primero = nuevo;
                ultimo = nuevo;
            }
            else{
                ultimo.siguiente = nuevo;
                ultimo = ultimo.siguiente;
            }
        }
        public nodo pop(){
            nodo temporal = new nodo();
            nodo current = new nodo();
            if(primero.siguiente == null){
                temporal = primero;
                primero = null;
            }else{
                temporal = ultimo;
                current = primero;
                while (current.siguiente != null) {
                    ultimo = current;
                    current = current.siguiente;
                }
                ultimo.siguiente = null;
            }
            return temporal;
        }
        public int stack(){
            return (!vacio())?ultimo.info:0;
        }
        public int sumaPrimos(){
            int suma = 0;
            if(vacio())
                System.out.println("La lista está vacía");
            else{
                while (primero != null) {
                    if(ultimo.esPrimo()) {
                        suma += pop().info;
                    }
                    else pop();
                }
            }
            return suma;
        }
        public void imprimirLista(){
            if (vacio())
                System.out.println("La lista está vacía");
            else{
                while (primero != null) {
                    if (ultimo.esPrimo())
                        System.out.println(pop().info);
                    else pop();
                }
            }
        }
        public Boolean vacio(){
            return (primero==null);
        }
    }
    public static class Cola{
        nodo primero,ultimo;
        public void acolar(int valor){
            nodo temporal = new nodo();
            nodo otro = new nodo();
            temporal.info = valor;
            temporal.siguiente = null;
            if(vacio()) {
                primero = temporal;
                ultimo = primero;
            }
            else{
                otro = primero;
                primero = temporal;
                primero.siguiente = otro;
            }
        }
        public nodo desacolar(){
            nodo temporal =new nodo();
            nodo current = new nodo();
            if(vacio())
                System.out.println("La lista está vacía");
            else{
                temporal = ultimo;
                current = primero;
                while (current.siguiente != null){
                    ultimo = current;
                    current = current.siguiente;
                }
                ultimo.siguiente = null;
            }
            return temporal;
        }

        public int sumarPrimeroUltimo(){
            return (desacolar().info+ primero.info);
        }
        public int sumaParGrandePrimerImpar(){
            nodo temporal = new nodo();
            temporal = primero;
            int mayor = 0, primo = 0;
            boolean band = true;
            while (temporal != null){
                if(temporal.esPar()) {
                    if (mayor < temporal.info)
                        mayor = temporal.info;
                }else if(band) {
                    primo = temporal.info;
                    band=false;
                }
                temporal = desacolar();
            }
            return (mayor+primo);
        }
        public Cola intercalarColas(Cola otraCola){
            Cola nuevaCola = new Cola();

            nodo cola1 = primero;
            nodo cola2 = otraCola.primero;
            Boolean llave1 = false;
            Boolean llave2 = false;

            while(!(llave2 && llave1)){
                if(cola1 != null){
                    if(cola1.esPar())
                        nuevaCola.acolar(cola1.info);
                    cola1= cola1.siguiente;
                }else llave1 = true;
                if(cola2 != null){
                    if(!cola2.esPar())
                        nuevaCola.acolar(cola2.info);
                    cola2= cola2.siguiente;
                }else llave2 = true;
            }
            return nuevaCola;
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