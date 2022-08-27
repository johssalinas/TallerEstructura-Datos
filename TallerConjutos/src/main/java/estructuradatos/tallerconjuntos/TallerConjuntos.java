package estructuradatos.tallerconjuntos;

import com.sun.source.tree.BreakTree;
import java.util.Scanner;
/**
 *
 * @author Johs Brayan Salinas Lopez
 */
public class TallerConjuntos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conjunto a,b,c;
        
        a=new Conjunto();
        b=new Conjunto();
        c=new Conjunto();
        
        System.out.println("Digita los elementos del primer vector");
        int opcion=1,c1=0;
        
        while(opcion == 1){
            System.out.println("Digite el valor del dato del conjunto a");
            a.items[c1++]=sc.nextInt();
            System.out.println("Desea agregar otro elemento 1)Si / 0)No");
            opcion=sc.nextInt();
            if(c1>=15) break;
        }
        a.contador=c1;
        
        System.out.println("Digite los elementos del primer vector");
        opcion=1;c1=0;
        while(opcion == 1){
            System.out.println("Digite el valor del dato del conjunto b");
            b.items[c1++]=sc.nextInt();
            System.out.println("Desea agregar otro elemento 1)Si / 0)No");
            opcion=sc.nextInt();
            if(c1>=15)break;
        }
        b.contador=c1;
        
        c= a.Interseccion(b);
        for(int i = 0; i<=c.contador;i++){
            System.out.println("Elementos de la Union: "+ c.items[i]);
        }
    }
    public static class Conjunto{
        public int items[];
        public int tamaño;
        public int contador;
        
        public Conjunto(){
            items = new int[15];
        }
        public Conjunto (int v[]){
            items = v;
        }
        public Conjunto Union(Conjunto a){
            Conjunto R = new Conjunto();
            R.contador=0;
            for(int i=0; i<= a.contador; i++){
                R.items[i] = a.items[i];
            }
            R.contador=a.contador;
            int i=0, dato=0;
            while(true){
                dato=items[i];
                if(R.Encontrar(dato) == 0)
                    R.items[R.contador]=items[i++];
                else
                    ++i;
                if (i==contador)break;
                ++R.contador;
            }
            return R;
        }
        public int Encontrar(int dato){
            for(int i=0; i<items.length;i++){
                if(dato == items[i]){
                    return 1;
                }
            }
            return 0;
        }
        public Conjunto Interseccion (Conjunto a){
            Conjunto R = new Conjunto();
            return R;
        }
        
        public Conjunto DiferenciaSimetrica (Conjunto a){
            Conjunto R = new Conjunto();
            return R;
        }
    }
}
