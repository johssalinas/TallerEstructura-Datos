package primerParcial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Johs Brayan Salinas Lopez
 */
public class primerParcial {

   //Ingresa los datos y los guarda en Scanner
    public static int input(String a){
        System.out.print(a);
        return new Scanner(System.in).nextInt();
    } 
    
        //Imprime los datos
    public static void imprimir(Conjunto a){
        for(int i = 0; i<a.items.size();i++)System.out.print(a.items.get(i) + " ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conjunto primerConjunto,segundoConjunto;
        
        primerConjunto=new Conjunto();
        segundoConjunto=new Conjunto();
        
        //Se llenan los datos del 0 al 4
        for(int i=0;i<5;i++)
            primerConjunto.items.add(i);
        //se llenan los datos del 4 al 9
        for(int j=4;j<10;j++)
            segundoConjunto.items.add(j);
        
        //Se imprimen la union del conjuto b en el a
        imprimir(primerConjunto.union(segundoConjunto));
        //Se imprimen la intersecion del conjuto b en el a
        imprimir(primerConjunto.interseccion(segundoConjunto));
        imprimir(primerConjunto.diferenciaSimetrica(segundoConjunto));
        int numeroPertenece = 12;
        if(primerConjunto.pertenece(numeroPertenece)) System.out.println(numeroPertenece+" SÍ pertenece al conjunto");
        else System.out.println(numeroPertenece+" NO pertenece al conjunto");
        imprimir(((primerConjunto.union(segundoConjunto)).union(segundoConjunto)).interseccion(segundoConjunto)); 
        if(primerConjunto.incluido(segundoConjunto))System.out.println("El segundo conjunto SÍ está incluido en A: ");
                else System.out.println("El segundo conjunto NO está incluido en A: ");
        primerConjunto.cantidadPrimos();
    }
    
    public static class Conjunto{
        
        public ArrayList<Integer> items;
        public int contador;
        
        public Conjunto(){
            items = new ArrayList<Integer>();
        }
        public Conjunto (ArrayList<Integer> v){
            items = v;
        }
        
        public Conjunto union(Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            for(int i=0; i<conjuntoRecibido.items.size(); i++) auxConjunto.items.add(conjuntoRecibido.items.get(i));
            
            for(int i=0;i<items.size();i++){
                if(!auxConjunto.encontrar(items.get(i))) auxConjunto.items.add(items.get(i));
            }
            return auxConjunto;
        }
        
        public Conjunto interseccion (Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            for(int i=0; i< conjuntoRecibido.items.size(); i++){
                if(encontrar(conjuntoRecibido.items.get(i))) auxConjunto.items.add(conjuntoRecibido.items.get(i));
            }
            return auxConjunto;
        }
        
        public Conjunto diferenciaSimetrica (Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            //Guarda dentro del auxiliar el valor del conjunto inmerso
            for(int i=0; i< items.size(); i++){
                if(!conjuntoRecibido.encontrar(items.get(i))) auxConjunto.items.add(items.get(i));
            }
            
            //Guarda dentro del auxiliar el valor del conjunto recibido
            for(int i=0; i< conjuntoRecibido.items.size(); i++){
                if(!encontrar(conjuntoRecibido.items.get(i))) auxConjunto.items.add(conjuntoRecibido.items.get(i));
            }
            return auxConjunto;
        }
        
        public boolean pertenece(int valorRecibido){
            return encontrar(valorRecibido);
        }
        
        public boolean incluido(Conjunto conjuntoRecibido){
            for(int i=0;i<conjuntoRecibido.items.size();i++){
                if(!encontrar(conjuntoRecibido.items.get(i))) return false;
            }
            return true;
        }
        
        //Recorre el array y retorna true cuando el item está en el conjunto
        public boolean encontrar(int conjuntoRecibido){
            for(int i=0; i<items.size();i++)
                if(conjuntoRecibido == items.get(i)) return true;
            return false;
        }
        
        //Numeros primos 
        public Conjunto cantidadPrimos(){
            Conjunto auxConjunto = new Conjunto();
            for (int i = 0; i < items.size(); i++) {
                if(items.get(i)==1||items.get(i) == 2 || items.get(i) == 3 || items.get(i) ==5)
                    auxConjunto.items.add(items.get(i));
                
                else if (items.get(i) % 2 != 0 && items.get(i) % 3 != 0 && items.get(i) % 5 != 0)
                    auxConjunto.items.add(items.get(i));
                
                else {
                    System.out.println("No hay primos");
                    break;
                }
            }
            return auxConjunto;
        }
    }
}
