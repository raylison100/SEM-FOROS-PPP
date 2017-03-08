/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Raylison
 */
public class Control extends Thread {
    private static Control instance;
    private RunWay runway;
    private Terminal terminal;
    private Semaphore semaforo;
    private static int MAX=100;
    
    public Control(){
        runway = new RunWay();
        terminal = new Terminal();
        semaforo = new Semaphore(MAX,true); 
    }
    
     public static Control getInstance(){ //Singleton
        if (instance == null) {
            instance = new Control();
        }
        return instance;          
    }
     
    private void main(Airplane airplane){
        if(airplane.getITA() == true){
            this.controleAr(airplane);
        }else{
            this.controleSolo(airplane);
        }
        
    }
    
    private void controleAr(Airplane airplane){
        if(airplane.getIntension() == 0){
            
        }else{
            
        }
        
        
        
    }
    
    private void controleSolo(Airplane airplane){
        switch (airplane.getIntension()){
            case 1:
                
            case 2:
                
            case 3:
        }
    }
    
    
    
    
    
    
   
    
    
    
    /*public static Control getInstance(){ //Singleton
        if (instance == null) {
            instance = new Control();
        }
        return instance;          
    }*/
    
    
    
    
    // criar filas para aterrissagem, decolagem , taxiamento(decolagem), taxiamento(aterrissagem). 
    
    
}
