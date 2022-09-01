package tallerconjuntoscorreccion;

import java.util.Scanner;

/**
 * @author Johs Brayan Salinas Lopez - Yhon Jairo Ochoa Mayorga
 */
public class TallerConjuntosCorreccion {
    
    //Ingresa los datos y los guarda en Scanner
    public static int input(String a){
        System.out.print(a);
        return new Scanner(System.in).nextInt();
        } 
    
        //Imprime los datos
        public static void output(Conjunto a){
        for(int i = 0; i<a.contador;i++)System.out.print(a.items[i] + " ");
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
                output((primerConjunto.union(segundoConjunto)).ordenar());
                break;
            case 2:
                pedirDatos(primerConjunto,segundoConjunto);
                output((primerConjunto.interseccion(segundoConjunto)).ordenar());
                break;
            case 3:
                pedirDatos(primerConjunto,segundoConjunto);
                output(primerConjunto.diferenciaSimetrica(segundoConjunto).ordenar());                
                break;
            case 4:
                primerConjunto.contador = input("\n\tDigita la cantidad elementos del primer conjunto ");
                for(int i = 0; i < primerConjunto.contador; i++) primerConjunto.items[i] = input("Digite el elemento " +(i+1) +" del primer conjunto ");
                 
                int numeroPertenece = input("\n\tDigita un número ");
                    if(primerConjunto.pertenece(numeroPertenece)) System.out.println(numeroPertenece+" SÍ pertenece al conjunto");
                    else System.out.println(numeroPertenece+" NO pertenece al conjunto");
                    break;
            case 5:
                pedirDatos(primerConjunto,segundoConjunto);
                if(primerConjunto.incluido(segundoConjunto))System.out.println("B SÍ está incluido en A: ");
                else System.out.println("B NO está incluido en A: ");
                break;
            default:
                System.out.println("Digite un valor válido");
        }        
    }
    
    //Metodo para pedir los valores de los 2 vectores
    public static void pedirDatos(Conjunto primerConjunto, Conjunto segundoConjunto){
        primerConjunto.contador = input("\n\tDigita la cantidad de elementos del primer conjunto ");
        for(int i = 0; i < primerConjunto.contador; i++) primerConjunto.items[i] = input("Digite el elemento " +(i+1) +" del primer conjunto ");
        
        segundoConjunto.contador = input("\n\tDigita la cantidad de elementos del segundo conjunto ");
        for(int i = 0; i < segundoConjunto.contador; i++) segundoConjunto.items[i] = input("Digite el elemento " +(i+1) +" del segundo conjunto ");
    }
    
    public static class Conjunto{
        public int items[];
        public int contador;
        
        public Conjunto(){
            items = new int[15];
        }
        public Conjunto (int v[]){
            items = v;
        }
        public Conjunto union(Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            auxConjunto.contador=0;
            for(int i=0; i<conjuntoRecibido.contador; i++) auxConjunto.items[auxConjunto.contador++] = conjuntoRecibido.items[i];
            
            for(int i=0;i<contador;i++){
                if(!auxConjunto.encontrar(items[i])) auxConjunto.items[auxConjunto.contador++]=items[i];
            }
            return auxConjunto;
        }
        
        public Conjunto interseccion (Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            auxConjunto.contador=0;
            for(int i=0; i< conjuntoRecibido.contador; i++){
                if(encontrar(conjuntoRecibido.items[i])) auxConjunto.items[auxConjunto.contador++] = conjuntoRecibido.items[i];
            }
            return auxConjunto;
        }
        
        public Conjunto diferenciaSimetrica (Conjunto conjuntoRecibido){
            Conjunto auxConjunto = new Conjunto();
            auxConjunto.contador=0;
            //Guarda dentro del auxiliar el valor del conjunto inmerso
            for(int i=0; i< contador; i++){
                if(!conjuntoRecibido.encontrar(items[i])) auxConjunto.items[auxConjunto.contador++] = items[i];
            }
            
            //Guarda dentro del auxiliar el valor del conjunto recibido
            for(int i=0; i< conjuntoRecibido.contador; i++){
                if(!encontrar(conjuntoRecibido.items[i])) auxConjunto.items[auxConjunto.contador++] = conjuntoRecibido.items[i];
            }
            return auxConjunto;
        }
        
        public boolean pertenece(int valorRecibido){
            return encontrar(valorRecibido);
        }
        
        public boolean incluido(Conjunto conjuntoRecibido){
            for(int i=0;i<=conjuntoRecibido.contador;i++){
                if(!encontrar(conjuntoRecibido.items[i])) return false;
            }
            return true;
        }
        
        //Recorre el array y retorna true cuando el item está en el conjunto
        public boolean encontrar(int conjuntoRecibido){
            for(int i=0; i<items.length;i++)
                if(conjuntoRecibido == items[i]) return true;
            return false;
        }
        
        //Metodo para ordenar los elementos
        public Conjunto ordenar(){
            int aux;
            int cont;
            do{
                cont = 0;
                for(int i = 1; i < contador ; i++){
                if(items[i-1]> items[i]){
                    aux = items[i-1];
                    items[i-1]= items[i];
                    items[i]= aux;
                    cont++;
                }
            }   
            }while(cont != 0);
            return this;
        }
    }
}
