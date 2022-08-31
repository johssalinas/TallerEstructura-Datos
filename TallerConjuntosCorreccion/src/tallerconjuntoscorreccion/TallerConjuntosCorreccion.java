package tallerconjuntoscorreccion;

import java.util.Scanner;

/**
 * @author Johs Brayan Salinas Lopez - Yhon Jairo Ochoa Mayorga
 */
public class TallerConjuntosCorreccion {
    
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conjunto a,b,c;
        
        a=new Conjunto();
        b=new Conjunto();
        c=new Conjunto();
        
        System.out.println("¿Qué operacion desea realizar?");
        System.out.println("1) union");
        System.out.println("2) interseccion");
        System.out.println("3) diferencia simetrica");
        System.out.println("4) pertenece");
        System.out.println("5) incluido");
        int seleccion = sc.nextInt();
        switch(seleccion){
            case 1:
                pedirDatos(a,b,sc);
                c= a.Union(b);
                break;
            case 2:
                pedirDatos(a,b,sc);
                c= a.Interseccion(b);
                break;
            case 3:
                pedirDatos(a,b,sc);
                c= a.DiferenciaSimetrica(b);
                break;
            case 4:
                pedirDatos(a,b,sc);
                c= a.DiferenciaSimetrica(b);
                break;
            case 5:
                pedirDatos(a,b,sc);
                c= a.DiferenciaSimetrica(b);
                break;
            default:
                System.out.println("Digite un valor válido");
        }
        imprimir(c);
        
    }
    public static void pedirDatos(Conjunto a, Conjunto b, Scanner sc){
        System.out.println("\n\tDigita los 5 elementos del primer vector\n");
        int opcion=1,c1=0;
        while(opcion == 1){
            int i;
            for(i=0;i<5;i++){
               System.out.println("Digite el "+(i+1) +" valor del dato del conjunto A");
            a.items[c1++]=sc.nextInt();
            if(c1>=5) break; 
            }break;
        }
        a.contador=c1;
        
        System.out.println("\n\tDigite los 5 elementos del segundo vector\n");
        opcion=1;c1=0;
        while(opcion == 1){
            int i;
            for(i=0;i<5;i++){
            System.out.println("Digite el valor del dato del conjunto B");
            b.items[c1++]=sc.nextInt();
            if(c1>=5)break;
            }break;
        }
        b.contador=c1;
    }
    
    
    public static void imprimir(Conjunto a){
        int i= 0;
        System.out.println("Elementos del conjunto: ");
        while(a.items[i]!=0) System.out.print(a.items[i++]+" "); 
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
                if(R.Encontrar(dato))
                    R.items[R.contador]=items[i++];
                else
                    ++i;
                if (i==contador)break;
                ++R.contador;
            }
            return R;
        }
        public boolean Encontrar(int dato){
            for(int i=0; i<items.length;i++){
                if(dato == items[i]){
                    return true;
                }
            }
            return false;
        }
        public Conjunto Interseccion (Conjunto a){
            Conjunto R = new Conjunto();
            R.contador=0;
            for(int i=0; i<= a.contador; i++){
                if(Encontrar(a.items[i])){
                    R.items[R.contador++] = a.items[i];
                }
            }
            return R;
        }
        
        public Conjunto DiferenciaSimetrica (Conjunto a){
            Conjunto R = new Conjunto();
            R.contador=0;
            for(int i=0; i<= contador; i++){
                if(!Encontrar(a.items[i])) R.items[R.contador++] = items[i];
            }
            
            for(int i=0; i<= a.contador; i++){
                if(!Encontrar(a.items[i])) R.items[R.contador++] = a.items[i];
            }
            return R;
        }
        
       // public boolean Pertenece(int a){
            
        //}
    }
}
