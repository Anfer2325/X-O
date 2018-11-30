
package x.pkg0;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    
    public static void main(String [] args){
        Scanner leer = new Scanner(System.in);
        String simbolo1 = "X";
        String simbolo2= "O";
        Tablero tablero =new Tablero();
        do{
        
        System.out.println("M E N U ");
        System.out.println("1.Jugar");
            System.out.println("2. Configuracion");
        int opcion = leer.nextInt();
        switch(opcion){
        
            case 1:
                tablero.reset();
                
                boolean turnoJugador1=true;
                boolean turnoJugador2=false;
               /* tablero.MovimientoJugador1(1, 1);
                tablero.MovimientoJugador1(0, 0);
                tablero.MovimientoJugador1(2, 2);
                  if(tablero.encontrarGanadorHorizontal("2", 2)){
                      System.out.println("gane");
                  }
                  if(tablero.encontrarGanadorVertical("2", 1)){
                      System.out.println("ganevertical");
                  }
                  
                  if(tablero.encontrarGanadorDiagonal("2", 2, 2)){
                      System.out.println("funciona diago");
                  }
                
               tablero.imprimirtablero();
               */  
             do{
             
             if(turnoJugador1==true){
                 if(tablero.encontrarEmpate()){
                     System.out.println("ES EMPATE");
                     break;
                 }
                 tablero.imprimirtablero();
                 System.out.println("Turno del jugador1: ");
                 System.out.println("Ingrese la fila donde desea colcocar");
                 int fila = leer.nextInt();
                 System.out.println("Ingrese la columna donde desea colocar");
                 int columna = leer.nextInt();
                 tablero.MovimientoJugador1(fila, columna);
                 if(tablero.encontrarGanadorGeneral(simbolo1, fila, columna)){
                     System.out.println("Gano el jugador 1");
                     try{
                     tablero.updateLista(simbolo1, simbolo2, simbolo1);}catch(IOException e){
                         System.out.println("ERRORRRR");
                     }
                     break;
                 }
                 turnoJugador1=false;
                 turnoJugador2=true;
             
             }
             
             if(turnoJugador2==true){
                  if(tablero.encontrarEmpate()){
                     System.out.println("ES EMPATE");
                     break;
                 }
                 tablero.imprimirtablero();
                 System.out.println("Turno del jugador2: ");
                  System.out.println("Ingrese la fila donde desea colcocar");
                 int fila = leer.nextInt();
                 System.out.println("Ingrese la columna donde desea colocar");
                 int columna = leer.nextInt();
                 tablero.MovimientoJugador2(fila, columna);
                 if(tablero.encontrarGanadorGeneral(simbolo2, fila, columna)){
                     System.out.println("gano el jugador 2");
                     try{
                     tablero.updateLista(simbolo1, simbolo2, simbolo2);}catch(IOException e){
                         System.out.println("ERRORRRR");
                     }
                     break;
                 }
                 turnoJugador1=true;
                 turnoJugador2=false;
                 
             }
             
             
             }while(true);   
            break;
            
            case 2 :
                boolean continuarSubmeno = true;
               do{
                   System.out.println("1. Cambiar simbolo para jugador 1 ");
                   System.out.println("2. Cambiar simbolo para jugador 2 ");
                   System.out.println("3. Salir");
                   
                   int opcion2 = leer.nextInt();
                   switch (opcion2){
                   
                       case 1: 
                           System.out.println("Ingrese el nuevo simbolo para jugador 1 : ");
                            simbolo1 = leer.next();
                            tablero.cambiarSimboloJugador1(simbolo1);
                           break;
                           
                       case 2: 
                           System.out.println("Ingrese el nuevo simbolo para jugador 2 : ");
                           simbolo2 = leer.next();
                           tablero.cambiarSimboloJugador2(simbolo2);
                           break;
                           
                       case 3 :
                           continuarSubmeno=false;
                           break;
                   
                   }
                   
               
               }while(continuarSubmeno==true);
                
                break;
        }
        }while(true);
    }
}
