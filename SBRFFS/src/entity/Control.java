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
public class Control {
    private static Control instance;
    private RunWay runway;
    private Terminal terminal;
    
    public Control(){
        runway = new RunWay();
        terminal = new Terminal();
    }
    
    public static Control getInstance(){ //Singleton
        if (instance == null) {
            instance = new Control();
        }
        return instance;          
    }
    
    
    
    
    // criar filas para aterrissagem, decolagem , taxiamento(decolagem), taxiamento(aterrissagem). 
    
    
}
