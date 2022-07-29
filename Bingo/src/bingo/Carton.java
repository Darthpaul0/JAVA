/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author deifont
 */
public class Carton {

    private int[][]datos={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
    private int casillasMarcadas;
    
    public Carton(){
        this.casillasMarcadas=0;
    }
    
    public Carton(Carton carton){
        this.casillasMarcadas=0;
        this.datos = new int[3][5];
        for(int i=0;i<datos.length;i++){
            for(int j=0;j<datos[0].length;j++){
                this.datos[i][j]=carton.datos[i][j];
            }
        }
    }
    
    public int getValor(int fila, int columna){
        
        return this.datos[fila][columna];
    }
    
    public boolean marcarCasilla(int bola){
        boolean marcada = false;
        
        for(int i = 0;i<datos.length && !marcada;i++){
            for(int j=0;j<datos[0].length && !marcada;j++){
                if(datos[i][j]==bola){
                    datos[i][j]=-1;
                    marcada = true;
                    this.casillasMarcadas++;
                }
            }
        }
        return marcada;
    }
    
    public boolean cantarFila(){
        
        return comprobarFila(0) || comprobarFila(1) || comprobarFila(2);
    }
    
    public boolean cantarBingo(){
        
        return (this.casillasMarcadas==15);
    }
    
    public String toString(){
        String carton = "--------------------------------\n";
        for(int i=0;i<datos.length;i++){
            for(int j=0;j<datos[0].length;j++){
                if(this.datos[i][j]==-1){
                    carton = carton+ " X  | ";
                } else{
                    carton = carton+this.datos[i][j]+ "  | ";
                }
                
            }   
            carton = carton +"\n";
        }
            
        carton = carton.concat("--------------------------------");
        return carton;
    }
    
    private boolean comprobarFila(int fila){
        boolean esFila=true;
        
       for(int i=0;i<datos[0].length && esFila;i++){
           if(datos[fila][i]!=-1){
               esFila = false;
           }
       }
       return esFila;
    }
}
