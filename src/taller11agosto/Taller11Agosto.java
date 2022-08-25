
package taller11agosto;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.Scanner;

public class Taller11Agosto {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Fraccionario a,b,c;
       a = new Fraccionario();
       b= new Fraccionario();
       c= new Fraccionario();
       
        String p,q;
       
        System.out.println("Digite un numero: ");
        p = sc.nextLine();
        String[] primero = p.split("/");
        if(p.contains("/")){
            a.numerador= Integer.parseInt(primero[0]);
            a.denominador=Integer.parseInt(primero[1]);
        }else{
            a.numerador=Integer.parseInt(primero[0]);
            a.denominador=1;
        }
        
        System.out.println("Digite otro numero: ");
        q = sc.nextLine();
        String[] segundo = q.split("/");
        if(String.valueOf(q).contains("/")){
            b.numerador=Integer.parseInt(segundo[0]);
            b.denominador= Integer.parseInt(segundo[1]);
        }else{
            b.numerador=Integer.parseInt(segundo[0]);
            b.denominador=1;
        }
       
        c=(a.Suma(b)).Simplificado();
        System.out.println("La suma de los fraccionarios es: " + c.numerador + "/"+ c.denominador);
    }

    private static class Fraccionario {

        public int numerador;
        public int denominador;
        
        public Fraccionario(){
            numerador = 0;
            denominador = 1;
        }
        
        public Fraccionario(int N, int D) {
            numerador=N;
            denominador=D;
        }
        public Fraccionario Suma(Fraccionario a){
        int n,d;
            if(denominador == a.denominador){
                n = numerador + a.denominador;
                d = denominador;
            }else {
                d=denominador + a.denominador;
                n=(numerador + a.denominador) + (denominador * a.numerador);
            }
            return (new Fraccionario (n,d));
        }
        
        public Fraccionario Resta(Fraccionario a){
        int n,d;
        if(denominador == a.denominador){
            n= numerador - a.denominador;
            d=denominador;
        }else {
            d= denominador * a.denominador;
            n= (numerador * a.denominador)-(denominador * a.numerador);
        }
        return (new Fraccionario(n,d));
        }
        
        public Fraccionario Multiplicacion (Fraccionario a){
            int num, den;
            num = numerador * a.numerador;
            den = denominador * a.denominador;
        return (new Fraccionario (num, den));
        }
        
        public Fraccionario Division(Fraccionario a){
            return (new Fraccionario(numerador*a.denominador, denominador*a.numerador));
        }
        public Fraccionario Simplificado(){
            Fraccionario T = new Fraccionario();
            int c=2, bandera = 1;
            while(true){
                    if(numerador % c == 0 && denominador % c == 0 && bandera == 1){
                numerador = numerador / c;
                denominador = denominador / c;
                    }else {
                    c += 1;
                        if(c >= numerador || c >= denominador)
                            break;
                    }
                    }
                    T.numerador=numerador;
                    T.denominador=denominador;
                    return T;
        } 
    }  
}
