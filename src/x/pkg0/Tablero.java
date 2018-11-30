
package x.pkg0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tablero {
    protected String file = System.getProperty("user.dir");
    protected String file2 = file + "\\historal.txt";
    protected File archivo =new File(file2);
    protected String jugador1="X";
    protected String jugador2="O";
    protected String [][] tablero = new String[3][3];
    
    public Tablero(){
    
            for(int x = 0 ; x<3;x++){
                for(int z = 0 ; z<3 ; z++){
                    tablero[x][z]=" ";
                }
            }
        }
  
    public void reset(){
          for(int x = 0 ; x<3;x++){
                for(int z = 0 ; z<3 ; z++){
                    tablero[x][z]=" ";
                }
            }
    }
    
    public void cambiarSimboloJugador1(String nom){
    this.jugador1=nom;
        System.out.println(file);
    }
    public void cambiarSimboloJugador2(String nom){
    this.jugador2=nom;
    }
    
    public boolean MovimientoJugador1(int fila, int columna){
        if(tablero[fila][columna].equals(" ")){
            tablero[fila][columna]=jugador1;
            return true;
        }
        System.out.println("Posicion ocupada");
        return false;
    
   }
    
   public boolean MovimientoJugador2(int fila, int columna){
       if(tablero[fila][columna].equals(" ")){
            tablero[fila][columna]=jugador2;
            return true;
        }
        System.out.println("Posicion ocupada");
        return false;
   }
   
   public boolean encontrarGanadorGeneral(String jugador, int fila, int columna){
   if(encontrarGanadorHorizontal(jugador,columna)){
       return true;
   }
   
   if(encontrarGanadorVertical(jugador, fila)){
       return true;
   }
   
   if(encontrarGanadorDiagonal(jugador,fila,columna)){
   return true;
   }
   
   return false;
   }
   
   public boolean encontrarGanadorHorizontal(String jugador, int columna){
      String resultado="";
      for(int x = 0; x<3 ; x++){
          if(tablero[x][columna].equals(jugador)){
             resultado+=jugador; 
          }
      }
      
      if(resultado.equals(jugador+jugador+jugador)){
          return true;
      }else{return false;}
   
   }
   
   public boolean encontrarEmpate(){
   for(int x = 0 ; x<3;x++){
                for(int z = 0 ; z<3 ; z++){
                    if(tablero[x][z].equals(" ")){
                        return false;
                    }
                }
            }
   return true;
   }
     public void updateLista(String jugador1, String jugador2, String ganador)throws IOException {
         if(archivo.isFile()){
             FileWriter fw = new FileWriter(archivo,true);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write("GANADOR DE PARTIDA : "+ ganador +"||"+ " Jugador 1 : "+jugador1 + " Jugador 2 : "+jugador2 +"\n");
             bw.newLine();
             bw.close();
         }else{archivo.createNewFile();updateLista(jugador1,jugador2,ganador);}
     }
    
    
   
   public boolean encontrarGanadorVertical(String jugador, int fila){
       String resultado="";
       for(int x = 0; x<3 ; x++){
          if(tablero[fila][x].equals(jugador)){
             resultado+=jugador; 
          }
      }
       if(resultado.equals(jugador+jugador+jugador)){
          return true;
      }else{return false;}
   }
   
   public boolean encontrarGanadorDiagonal(String jugador, int fila,int columna){
       int x,y;
       String resultado="";
       
       //diagonal derecha
       for( x = fila,y=columna;x<3&&y>=0;x++,y--){
           if(tablero[x][y].equals(jugador)){
           resultado+=jugador;
           }
       }
       for( x = fila,y=columna;x>=0&&y<3;x--,y++){
           if(tablero[x][y].equals(jugador)){
           resultado+=jugador;
           }
       }
             
       if(resultado.equals(jugador+jugador+jugador+jugador)){
       return true;
       }
       
       //Diagonal izquierda
       String resultado2="";
       for( x = fila,y=columna;(x<3&&x>=0)&&(y<3&&y>=0);x++,y++){
           if(tablero[x][y].equals(jugador)){
           resultado2+=jugador;
           }
       }
       for( x = fila,y=columna;x>=0&&y>=0;x--,y--){
           if(tablero[x][y].equals(jugador)){
           resultado2+=jugador;
           }
       }
       System.out.println("resutlado 2 : "+ resultado2);
       if(resultado2.equals(jugador+jugador+jugador+jugador)){
       return true;
       }else{return false;}
       
   }
    
    public void imprimirtablero(){
     for(int x = 0 ; x<3;x++){
                for(int z = 0 ; z<3 ; z++){
                    System.out.print("|"+tablero[x][z]+"| ");
                }
                System.out.println("");
            }
    }
    
    
}
