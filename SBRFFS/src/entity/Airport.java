/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Michel Perilo
 */
public class Airport {
    private Control control;
   // private Terminal terminal;
    //private RunWay runway;
    private static Airport instance;
    
    public Airport(){
        control = new Control();
        //terminal = new Terminal();
        //runway = new RunWay();
    }
    
    public static Airport getInstance(){ //Singleton
        if (instance == null) {
            instance = new Airport();
        }
        return instance;          
    }
    
    /*public static intensionControl(int intension, Airplane airplane){
        switch(intension){
                case 0: 
                break;
                case 1: CHAMADA AO MÉTODO DECOLAR
                break;
                case 2: CHAMADA AO MÉTODO TÁXIAR
                break;
                case 3: CHAMADA AO MÉTODO DE ACESSAR O PORTÃO
                break;
                default: System.out.println("Erro de intensao"); //poderia ser uma excecao
        }
    }
    */
    
    
    
    
}
