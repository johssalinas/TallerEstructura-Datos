package estructuradatos.taller1septiembre;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Johs Brayan Salinas Lopez - Yhon Jairo Ochoa Mayorga
 */
public class Taller1Septiembre {

   //Ingresa los datos y los guarda en Scanner
    public static int input(String a){
        System.out.print(a);
        return new Scanner(System.in).nextInt();
    } 
    
        //Imprime los datos
    public static void output(Conjunto a){
        for(int i = 0; i<a.items.size();i++)System.out.print(a.items.get(i) + " ");
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
        System.out.println("\t1) union");
        System.out.println("\t2) interseccion");
        System.out.println("\t3) diferencia simetrica");
        System.out.println("\t4) pertenece");
        System.out.println("\t5) incluido");
        int seleccion = sc.nextInt();
        switch(seleccion){
            case 1:
                pedirDatos(primerConjunto,segundoConjunto);
                output((primerConjunto.union(segundoConjunto)));
                break;
            case 2:
                pedirDatos(primerConjunto,segundoConjunto);
                output((primerConjunto.interseccion(segundoConjunto)));
                break;
            case 3:
                pedirDatos(primerConjunto,segundoConjunto);
                output(primerConjunto.diferenciaSimetrica(segundoConjunto));                
                break;
            case 4:
                int cant;
                cant = input("\n\tDigita la cantidad elementos del primer conjunto ");
                for(int i = 0; i < cant; i++) 
                    primerConjunto.items.add(input("Digite el elemento " +(i+1) +" del primer conjunto "));
                 
                int numeroPertenece = input("\n\tDigita un número ");
                    if(primerConjunto.pertenece(numeroPertenece)) System.out.println(numeroPertenece+" SÍ pertenece al conjunto");
                    else System.out.println(numeroPertenece+" NO pertenece al conjunto");
                    break;
            case 5:
                pedirDatos(primerConjunto,segundoConjunto);
                if(primerConjunto.incluido(segundoConjunto))System.out.println("B SÍ está incluido en A: ");
                else System.out.println("B NO está incluido en A: ");
                break;
            case 6:
                pedirDatos(primerConjunto,segundoConjunto);
                System.out.println("La cantidad de primos es "+primerConjunto.cantidadPrimos()); 
                break;
            default:
                System.out.println("Digite un valor válido");
        }        
    }
    
    //Metodo para pedir los valores de los 2 vectores
    public static void pedirDatos(Conjunto primerConjunto, Conjunto segundoConjunto){
        int cant;
        cant= input("\n\tDigita la cantidad de elementos del primer conjunto ");
        for(int i = 0; i < cant; i++) primerConjunto.items.add(input("Digite el elemento " +(i+1) +" del primer conjunto "));
        
        cant = input("\n\tDigita la cantidad de elementos del segundo conjunto ");
        for(int i = 0; i < cant; i++) segundoConjunto.items.add(input("Digite el elemento " +(i+1) +" del segundo conjunto "));
    }
    
    public static class Conjunto{
        
        public ArrayList<Integer> items;
        //public int contador;
        
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
        
        //Numeros pares
        public int cantidadaPares(){
            int c=0;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) % 2 ==0)                
                    ++c;
            }
            return c;
        }
        
        //Numeros primos 
        public int cantidadPrimos(){
            int c=0;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) % 2 != 0 || items.get(i) % 3 != 0 || items.get(i) % 5 != 0) {
                    c++;
                    System.out.println(items.get(i));
                }
                
                
            }
            return c;
        }
    }
}
