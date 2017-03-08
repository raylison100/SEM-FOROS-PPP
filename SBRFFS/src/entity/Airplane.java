/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import buffer.BufferAP;
import java.util.concurrent.Semaphore;

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
    
    //private boolean procedure; // se true querendo aterrissar false querendo decolar
                                  //pode ser mudado conforme implementação o taxiamento.
  
    private String pfx; //prefixo
    private int fp;  //flight priority 
    private int fuel; //em toneladas 
    private boolean ita=true; //in the air
    private final int MAX_PRIORITY = 10;
    private final int MED_PRIORITY = 5;
    private final int LOW_PRIORITY = 0;
    private final int LAND=0;  
    private final int TAKEOFF=1;
    private final int TAXI=2;
    private final int TERMINAL=3;
    //private boolean decolar;
    private int intension; /*a intensao e definida atraves das constantes (LAND, TAXI, TERMINAL e TAKEOFF) por default as aeronaves iniciaram 
                             a variavel intension com 0 (LAND) indicando a intencao de pouso. as intensoes TAXI, TERMINAL e TAKEOFF so sao 
                             utilizadas quando a aeronave estiver em solo, ou seja a variavel ita esta em false. ao final de casa procedimento
                             a variavel intension e setada com a nova intensao da aeronave seguindo a sequencia(LAND,TAXI E TERMINAL e TERMINAL
                             TAXI E TAKEOFF)*/
    private Semaphore semaforo;

      

    public Airplane(BufferAP buf,String pfx,int fuel, boolean status, Semaphore semaforo){
        
        this.buffer = buf;
        //this.procedure = status;
        this.pfx = pfx;
        this.fuel=fuel;
        this.intension=LAND;
        this.semaforo=semaforo;
        this.flightPriority();
        this.decrementFuel();
        this.procedure();
    }

    public int getFlightPriority(){
        return fp;
    }
    
    private void setFlightPriority(int fp){
        this.fp = fp;
    }
    
    private int getFuel(){
        return fuel;
    }
    
    public boolean getITA(){
        return ita;
    }
    
    public void setITA(boolean ita){
        this.ita=ita;
    }
    
    public int getIntension(){
        return intension;
    }
    
    public void setIntension(int intension){
        switch(intension){
                case 0: this.intension=LAND;
                break;
                case 1: this.intension=TAKEOFF;
                break;
                case 2: this.intension=TAXI;
                break;
                case 3: this.intension=TERMINAL;
                break;
                default: System.out.println("Erro de intensao"); //poderia ser uma excecao
        }
    }
       
    private void decrementFuel(){            //a decrementacao ficara a cargo da propria classe aeronave, sendo chamado no construtor
        while (ita==true){
            this.fuel=this.fuel--;
        }
    }
    
    private void incrementFuel(){              //rabastecimento: chamado após a aeronave adentrar ao terminal
        this.fuel=100;
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
    
    private void procedure(){
        while(true){
        switch (intension){
            case 0: 
                this.pousar(); // solicitacao de aterrisagem ao controle
            break;
            case 1:
                this.decolar(); // solicitacao de decolagem ao controle
            break; 
            case 2: 
                this.taxi(); //solicitacao de taxiamento ao controle
            break;
            case 3:
                this.terminal(); //solicitacao de ancoragem no terminal
            break;
            default: System.out.println("Erro de intencao"); //pode ser uma excecao
        }
        }
    }
    
    public void pousar(){
        
       System.out.println("Aeronave " + this.pfx + " preparando-se para aterrissagem...");
       this.setIntension(0);
    }
    
    public void decolar(){
        
        System.out.println("Aeronave " + this.pfx + " está decolando!");
        this.setIntension(1);
    }
    
    public void taxi(){
       
        System.out.println("Aeronave " + this.pfx + " irá taxiar.");
        this.setIntension(2);
    }
    
    public void terminal(){
    
        System.out.println("Aeronave " + this.pfx + " solicitando acesso ao terminal...");
        this.setIntension(3);
    }
    
    /*public void status(){
        
        if(this.procedure == true)
            pousar();
        else
            decolar();
                      
    }   */ 
    
    public synchronized void run() {
		for (int i = 0; i < 10; i++)
			buffer.add(pfx);
	}
    
    
   
    
}