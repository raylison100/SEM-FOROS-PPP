/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raylison
 */
public class Control extends Thread {
    private static Control instance;
    private Semaphore semaforoPous;
    private Semaphore semaforoDeco;
    private Semaphore semaforoTerm;
    private static int MAX=1;
    
    public Control(){
        semaforoPous = new Semaphore(MAX);
        semaforoDeco = new Semaphore(MAX);
        semaforoTerm = new Semaphore(3);
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
    
    public void controleAr(Airplane airplane){
        if(airplane.getIntension() == 0){ // solicita pouso
            System.out.println("Controle: " + airplane.getPfx() + " Aguarde liberação.");
            try {
                semaforoPous.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                System.out.println("Controle: " + airplane.getPfx() + " Liberação confirmada, inicie procedimento de aterrissagem.");
                System.out.println(airplane.getPfx() + ": Ok, controle.");
                semaforoPous.release();
                try {
                    airplane.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    airplane.setITA(false);
                    airplane.setDir(1); // indica que acabou de pousar
                    airplane.setIntension(2); // taxiar
                }
                }
        }else{
            //DEFAULT
        }
    }
    
    public void controleSolo(Airplane airplane){
        switch (airplane.getIntension()){
            case 1: // decolagem
                    System.out.println("Controle: " + airplane.getPfx() + " Aguarde liberação.");
                    try {
                        semaforoDeco.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        System.out.println("Controle: " + airplane.getPfx() + " Pista liberada, proceda com a decolagem, boa viagem.");
                        System.out.println(airplane.getPfx() + ": Ok, controle. Obrigado.");
                        semaforoDeco.release();
                        System.out.println("Controle: " + airplane.getPfx() + " Até a próxima!\n");
                        try {
                            airplane.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                        }finally{
                            airplane.setITA(true);
                            airplane.setIntension(4);
                            airplane.stop();
                            
                        }
                    }
  
            case 2: // taxiamento
                System.out.println("Controle: " + airplane.getPfx() + " Verificando Disponibilidade...");
                System.out.println("Controle: " + airplane.getPfx() + " Tudo certo, posicione a aeronave para taxiamento.");
                System.out.println(airplane.getPfx() + ": OK, iniciando manobra.");
                try { 
                    airplane.sleep(15);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    if(airplane.getDir() == 1){
                        airplane.setIntension(3);
                    } else{
                        airplane.setIntension(1);
                    }
                }
  
            case 3: //terminal
                System.out.println("Controle: " + airplane.getPfx() + " aguarde liberação.");
                try {
                    semaforoTerm.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    System.out.println("Controle: " + airplane.getPfx() + " ancoragem liberada, siga para a posição " + (int)(Math.random() * 24) + " do terminal.");
                    System.out.println(airplane.getPfx() + ": procedendo com a ancoragem.");
                try {
                    airplane.sleep((int)(Math.random() * 20));
                    airplane.desembarque();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    airplane.sleep((int)(Math.random() * 50));
                    airplane.embarque();
                } catch (InterruptedException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                    semaforoTerm.release();
                    try {
                        airplane.sleep((int)(Math.random() * 20) + 30);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        airplane.setIntension(1);
                    }
                }
        }
    }
    
    
}
