package taller29septiembre;

import java.util.Scanner;

/**
 * @author jbrayan
 */
public class Taller29Septiembre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista P = new Lista();
        Scanner sc = new Scanner(System.in);
        int op=1;
        int bandera=0;
        
        P.primero = null;
        
        nodo r= new nodo();
        nodo n= new nodo();
        int opc;
        do{
            System.out.println("Agregue nodo");
            int dato = sc.nextInt();
            agregarNodo(P, dato);
            System.out.println("Desea crear otro Nodo 1-Sí, 0-No");
            opc = sc.nextInt();
        }while(opc !=0);
        
        int primerPar=0, ban2=0,ultimoPrimo=0,cont=0,suma=0;
        r=P.primero;
        while(r!=null){
           if(r.info%2==0 && ban2==0){
               ultimoPrimo = r.info;
               ban2 = 1;
           }
           if(r.info%2==0 && ultimoPrimo != r.info)
               primerPar = r.info;
           r = r.siguiente;
        }
        suma = primerPar + ultimoPrimo;
        System.out.println("Primer par: "+ primerPar);
        System.out.println("Ultimo par: "+ ultimoPrimo);
        System.out.println("La suma de primer par y el ultimo par es : "+suma);
        
        r = P.primero;
        System.out.println("Los pares de la lista son: ");
        P.imprimirPares();
        
        P.SumaPrimeroUltimo();
    }
    
    public static void agregarNodo(Lista lista, int x){
            nodo n = new nodo();
            nodo otro = new nodo();
            n.info = x;
            n.siguiente = null;
            if(lista.primero == null)
                lista.primero = n;
            else{
                otro = lista.primero;
                lista.primero = n;
                lista.primero.siguiente = otro;
            }
        }

    public static class Lista{
    nodo primero;

        public void SumaPrimeroUltimo(){
            nodo r = new nodo();
            r = primero;
            int pr=0,ul=0;
            if(r!=null){
                pr = r.info;
                while (r.siguiente!=null)
                    r = r.siguiente;
                ul = r.info;
            }
            System.out.println("La suma del primero y del ultimo es: "+(pr+ul));
        }
        public void imprimirLista(){
            nodo r = new nodo();
            r = primero;
            while (r != null) {            
                System.out.println(r.info);
                r = r.siguiente;
            }
        }

        public void imprimirPares(){
            nodo T = new nodo();
            T = primero;

            while(T!=null){
                if (T.esPar())
                    System.out.println("Es par: "+ T.info);
            T = T.siguiente;
            }
       }
    }
    private static class nodo{
    int info;
    nodo siguiente;

        public Boolean esPar(){
            Boolean R = true;
            if(info % 2 ==0)
                R = true;
            else
                R = false;
            return R;
        }
        public Boolean esPrimo(){
            Boolean R = true;
            return  R;
        }
    }
}