package org.johs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pila lista = new Pila();
        Scanner sc = new Scanner(System.in);
        lista.primero = null;
        int opcion,lugar;
        System.out.println("Practica nodos\n ¿Qué desea hacer?\n");
        do{
            System.out.println("\n1) Push\n" +
                    "2) Pop\n" +
                    "3) Stack\n" +
                    "4) suma de primos\n" +
                    "8) Imprimir los primos\n" +
                    "0) salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Valor del nodo");
                    lista.push(sc.nextInt());
                    break;
                case 2:
                    lista.pop();
                    break;
                case 3:
                    if(lista.stack() == 0)
                        System.out.println("La lista está vacía");
                    else
                        System.out.println("stack: "+ lista.stack());
                    break;

                case 4:
                    System.out.println("La suma de los primos es: "+ lista.sumaPrimos());
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
    public static class Pila{
        nodo primero;
        public void push(int valor){
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
        public nodo pop(){
            nodo temporal = new nodo();
            nodo current = new nodo();
            if(primero.siguiente == null){
                temporal = primero;
                primero = null;
            }else{
                current=temporal=primero;
                while (temporal.siguiente != null) {
                    current = temporal;
                    temporal = temporal.siguiente;
                }
                current.siguiente = null;
            }
            return temporal;
        }
        public int stack(){
            return (!vacio())?primero.info:0;
        }
        public int sumaPrimos(){
            int suma = 0;
            if(vacio())
                System.out.println("La lista está vacía");
            else{
                nodo temporal = new nodo();
                while (temporal != null) {
                    if(temporal.esPar())
                        suma += pop().info;
                    else pop();
                }
            }
            return suma;
        }
        public void imprimirLista(){
            nodo temporal = new nodo();
            temporal = primero;
            if (vacio())
                System.out.println("La lista está vacía");
            else{
                while (primero != null) {
                    temporal = pop();
                    System.out.println(temporal.info);
                    if(temporal == null) break;
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