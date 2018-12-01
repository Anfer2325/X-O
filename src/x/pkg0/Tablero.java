
package x.pkg0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tablero {
    protected String nombrejugador1;
    protected String nombrejugador2;
    protected String file = System.getProperty("user.dir");
    protected String file2 = file + "\\historal.txt";
    protected File archivo =new File(file2);
    protected char jugador1;
    protected char jugador2;
    protected char [][] tablero = new char[3][3];
    
    public Tablero(char jugador1, char jugador2,String nombre1,String nombre2){
           this.jugador1=jugador1;
           this.jugador2 = jugador2;
           this.nombrejugador1 = nombre1;
           this.nombrejugador2 = nombre2;
            for(int x = 0 ; x<3;x++){
                for(int z = 0 ; z<3 ; z++){
                    tablero[x][z]=' ';
                }
            }
        }
  
    public void reset(){
          for(int x = 0 ; x<3;x++){
                for(int z = 0 ; z<3 ; z++){
                    tablero[x][z]=' ';
                }
            }
    }
    
    public void cambiarSimboloJugador1(char nom){
    this.jugador1=nom;
        System.out.println(file);
    }
    public void cambiarSimboloJugador2(char nom){
    this.jugador2=nom;
    }
    
    public boolean MarcarJugadaJugador1(int fila, int columna){
        if(tablero[fila][columna]==(' ')){
            tablero[fila][columna]=jugador1;
            return true;
        }
        System.out.println("Posicion ocupada");
        return false;
    
   }
    
   public boolean MarcarJugadaJugador2(int fila, int columna){
       if(tablero[fila][columna]==(' ')){
            tablero[fila][columna]=jugador2;
            return true;
        }
        System.out.println("Posicion ocupada");
        return false;
   }
   
   public boolean revisarJuego(char jugador, int fila, int columna){
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
   
   public boolean encontrarGanadorHorizontal(char jugador, int columna){
      int resultado=0;
      for(int x = 0; x<3 ; x++){
          if(tablero[x][columna]==(jugador)){
             resultado++; 
          }
      }
      
      if(resultado==3){
          return true;
      }else{return false;}
   
   }
   
   public boolean encontrarEmpate(){
   for(int x = 0 ; x<3;x++){
                for(int z = 0 ; z<3 ; z++){
                    if(tablero[x][z]==(' ')){
                        return false;
                    }
                }
            }
   return true;
   }
     public void updateLista(char jugador1, char jugador2, char ganador)throws IOException {
         if(archivo.isFile()){
             FileWriter fw = new FileWriter(archivo,true);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write("GANADOR DE PARTIDA : "+ ganador +"||"+" Jugador 1 Nombre : "+nombrejugador1+ " Simbolo : "+jugador1 +" Jugador 2 Nombre : "+nombrejugador2+ " Simbolo : "+jugador2 +"\n");
             bw.newLine();
             bw.flush();
         }else{archivo.createNewFile();updateLista(jugador1,jugador2,ganador);}
     }
    
    
   
   public boolean encontrarGanadorVertical(char jugador, int fila){
       int encontrados=0;
       for(int x = 0; x<3 ; x++){
          if(tablero[fila][x]==(jugador)){
             encontrados++;
             
              
          }
          
      }
      
       if(encontrados==3){
          return true;
      }else{return false;}
   }
   
   public boolean encontrarGanadorDiagonal(char jugador, int fila,int columna){
       int x,y;
       int resultado=0;
       
       //diagonal derecha
       for( x = fila,y=columna;x<3&&y>=0;x++,y--){
           if(tablero[x][y]==(jugador)){
           resultado++;
           }
       }
       for( x = fila,y=columna;x>=0&&y<3;x--,y++){
           if(tablero[x][y]==(jugador)){
           resultado++;
           }
       }
             
       if(resultado==4){
       return true;
       }
       
       //Diagonal izquierda
       int resultado2=0;
       for( x = fila,y=columna;(x<3&&x>=0)&&(y<3&&y>=0);x++,y++){
           if(tablero[x][y]==(jugador)){
           resultado2++;
           }
       }
       for( x = fila,y=columna;x>=0&&y>=0;x--,y--){
           if(tablero[x][y]==(jugador)){
           resultado2++;
           }
       }
      
       if(resultado2==4){
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
