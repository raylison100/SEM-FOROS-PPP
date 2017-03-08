/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Raylison
 */
public class RunWay {
    private boolean freerunway=true;          //true para disponivel, false para nao disponivel
    private static RunWay instance;
    
    public RunWay(){
        
    }
    
    public static RunWay getInstance(){ //Singleton
        if (instance == null) {
            instance = new RunWay();
        }
        return instance;          
    }
    
    private boolean getFreeRunWay(){
        return this.freerunway;
    }
    
    private void setFreeRunWay(boolean freerunway){
        this.freerunway=freerunway;
    }
    
  
    // informa a torre de controle se esta ocupada ou nao , dispara um tempo de uso para taxiamento.
    
    //recebe as filas de taxiamento diacordo com as prioridades.
    
    
  }
