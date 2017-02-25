/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import negocios.BufferAero;

/**
 *
 * @author Michel Perilo
 */
public class Aeronave extends Thread {
    private BufferAero buffer;
    private boolean decolagem; // true decolou,false pista nao liberada. 
    private boolean aterrissagem; // true pousou , false taxiando.
    
    //  ? como saber se ta indo pousar o decolar ?
    
    private boolean statusAviao; // se true querendo aterrissar false querendo decolar
                                  //pode ser mudado conforme implementação o taxiamento.
    
    private String pfx; //prefixo
    private int fp;  //flight priority 
    private float fuel; //em toneladas 
    private final int MAX_PRIORITY = 10;
    private final int MED_PRIORITY = 5;
    private final int LOW_PRIORITY = 0;
    private boolean decolar;

      

    public Aeronave(BufferAero buf,String pfx,float fuel, boolean status){
        
        this.buffer = buf;
        this.statusAviao = status;
        this.pfx = pfx;
        this.fuel=fuel;
        this.flightPriority();
    }

    public int getFlightPriority(){
        return fp;
    }
    
    private void setFlightPriority(int fp){
        this.fp = fp;
    }
    
    private float getFuel(){
        return fuel;
    }
       
    public void decrementFuel(){
        this.fuel=this.fuel--;
    }
    
    private void flightPriority(){                           /*A prioridade de vôo vai ser definida de acordo
                                                           com a quantidade de combustivel que a aeronave
                                                           carrega*/
        if (this.getFuel() >= 7){
            this.setFlightPriority(LOW_PRIORITY);      
        }
        else if(this.getFuel() < 7 && this.getFuel() > 3){
            this.setFlightPriority(MED_PRIORITY);
        }
        else if(this.getFuel() <= 3){
            this.setFlightPriority(MAX_PRIORITY);
        }
        
    }
    
    public synchronized void run() {
		for (int i = 0; i < 10; i++)
			buffer.add(pfx);
	}
    
    
    public void pousar(){
        
        this.aterrissagem = false;
        do{
            // se pista liberada pousou recebe true 
            // se pista ocupada ou alguem na frete int continua taxiando e 
            // chama procedimento decrementFuel()
            
        }while(this.aterrissagem =! true);
        
    }
    
    public void decolar(){
        
        this.decolar = false;
        
    }
    
    
    public void status(){
        
        if(this.statusAviao == true)
            pousar();
        else
            decolar();
                      
    }   
    
}