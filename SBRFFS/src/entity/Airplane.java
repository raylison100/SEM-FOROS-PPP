/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import negocios.BufferAP;

/**
 *
 * @author Michel Perilo
 */
public class Airplane extends Thread {
    private BufferAP buffer;
    /*private boolean decolagem; // true decolou,false pista nao liberada. 
    private boolean aterrissagem; // true pousou , false taxiando.
    variaveis podem ser substituidas pela variavel intheair, que indica se a aeronave esta em solo ou nao
    */
    //  ? como saber se ta indo pousar o decolar ? 
    
    private boolean procedure; // se true querendo aterrissar false querendo decolar
                                  //pode ser mudado conforme implementação o taxiamento.
    
    private String pfx; //prefixo
    private int fp;  //flight priority 
    private float fuel; //em toneladas 
    private boolean ita=true; //in the air
    private final int MAX_PRIORITY = 10;
    private final int MED_PRIORITY = 5;
    private final int LOW_PRIORITY = 0;
    private final int LAND=0;  
    private final int TAKEOFF=1;
    private final int TAXI=2;
    private final int TERMINAL=3;
    private boolean decolar;
    private int intension; /*a intensao e definida atraves das constantes (LAND, TAXI, TERMINAL e TAKEOFF) por default as aeronaves iniciaram 
                             a variavel intension com 0 (LAND) indicando a intencao de pouso. as intensoes TAXI, TERMINAL e TAKEOFF so sao 
                             utilizadas quando a aeronave estiver em solo, ou seja a variavel ita esta em false. ao final de casa procedimento
                             a variavel intension e setada com a nova intensao da aeronave seguindo a sequencia(LAND,TAXI E TERMINAL e TERMINAL
                             TAXI E TAKEOFF)*/
    

      

    public Airplane(BufferAP buf,String pfx,float fuel, boolean status){
        
        this.buffer = buf;
        this.procedure = status;
        this.pfx = pfx;
        this.fuel=fuel;
        this.intension=LAND;
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
    
    private boolean getITA(){
        return ita;
    }
    
    private void setITA(boolean ita){
        this.ita=ita;
    }
    
    private int getIntension(){
        return intension;
    }
    
    private void setIntension(int intension){
        this.intension=intension;
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
    
    
    /*public void pousar(){
        
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
        
        if(this.procedure == true)
            pousar();
        else
            decolar();
                      
    }   */
    
}