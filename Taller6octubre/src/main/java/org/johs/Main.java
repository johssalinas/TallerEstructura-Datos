package org.johs;

import java.util.Scanner;
/**
 * @author Johs Brayan Salinas López
 */
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
                    "5) Imprimir los primos\n" +
                    "0) salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Valor del nodo");
                    lista.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Se eliminó "+ lista.pop().info);
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
                case 5:
                    lista.imprimirLista();
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