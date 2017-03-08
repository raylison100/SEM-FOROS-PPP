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
public class Terminal {
    private final int CAPACIDADE=15;     //capacidade de aeronaves dispotas no terminal
    private static Terminal instance;
    
    public Terminal(){
        
    }
    
    public static Terminal getInstance(){ //Singleton
        if (instance == null) {
            instance = new Terminal();
        }
        return instance;          
    }
    
    
    
    
    
    
    //recebe os avioes de taxiamento de aterrissagem e envia os avioes para o taxiamento de decolagem.
    
}
