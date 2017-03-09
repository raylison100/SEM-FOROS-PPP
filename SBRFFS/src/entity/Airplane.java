/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Michel Perilo
 */
public class Airplane extends Thread {
    
    private String pfx; //prefixo
    private int fp;  //flight priority 
    private int fuel; //em toneladas 
    private boolean ita=true; //in the air
    private int dir; //1 para chegada e 0 para saída
    //private final int MAX_PRIORITY = 10;
    //private final int MED_PRIORITY = 5;
    //private final int LOW_PRIORITY = 0;
    private final int LAND=0;  
    private final int TAKEOFF=1;
    private final int TAXI=2;
    private final int TERMINAL=3;
    private int passengers;
    private PassageirosBuffer buffer;
    private int intension; /*a intensao e definida atraves das constantes (LAND, TAXI, TERMINAL e TAKEOFF) por default as aeronaves iniciaram 
                             a variavel intension com 0 (LAND) indicando a intencao de pouso. as intensoes TAXI, TERMINAL e TAKEOFF so sao 
                             utilizadas quando a aeronave estiver em solo, ou seja a variavel ita esta em false. ao final de casa procedimento
                             a variavel intension e setada com a nova intensao da aeronave seguindo a sequencia(LAND,TAXI E TERMINAL e TERMINAL
                             TAXI E TAKEOFF)*/
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;

      

    public Airplane(String pfx, PassageirosBuffer buf, Semaphore sem1, Semaphore sem2, Semaphore sem3){
        
        this.buffer = buf;
        this.pfx = pfx;
        this.passengers = (int)(Math.random() * 50) + 50;
        this.intension=LAND;
        this.sem1=sem1;
        this.sem2=sem2;
        this.sem3=sem3;
    }
    public String getPfx(){
        return this.pfx;
    }

    public int getFlightPriority(){
        return fp;
    }
    
    public int getDir(){
        return dir;
    }
 
    public void setDir(int dir){
        this.dir = dir;
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
                case 0: 
                    this.intension=LAND;
                    break;
                case 1: 
                    this.intension=TAKEOFF;
                    break;
                case 2: 
                    this.intension=TAXI;
                    break;
                case 3: 
                    this.intension=TERMINAL;
                    break;
                default:  //poderia ser uma excecao
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
    
    /*private void flightPriority(){                           /*A prioridade de vôo vai ser definida de acordo
                                                           com a quantidade de combustivel que a aeronave
                                                           carrega
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
    */
    
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
            default: 
        }
        }
    }
    
    public void embarque(){
       // for (int i = 0; i < 50 + ((int)(Math.random() * 25) + 25); i++) {
            buffer.get(pfx);
        }
    
    
    public void desembarque(){
        //for (int i = 0; i < 100; i++) {
            buffer.set(pfx, passengers);
        
    }
    
    public void pousar(){
        
       System.out.println(this.pfx + ": Solicito vetor de aproximação...");
       Control.getInstance().controleAr(this);
      
    }
    
    public void decolar(){
        System.out.println(this.pfx + ": Tudo pronto, solicito liberação de pista para de decolagem");
        Control.getInstance().controleSolo(this);
        
    }
    
    public void taxi(){
        System.out.println(this.pfx + ": Queremos liberação para pista de taxi");
       Control.getInstance().controleSolo(this);
    }
    
    public void terminal(){
        System.out.println(this.pfx + ": Solicito posição para atracagem");
        Control.getInstance().controleSolo(this);
    }
    
    /*public void status(){
        
        if(this.procedure == true)
            pousar();
        else
            decolar();
                      
    }   */ 
    
    public void run() {
		/*for (int i = 0; i < 10; i++)
			buffer.add(pfx);
                  */      
        //this.flightPriority();
        //this.decrementFuel();
        //procedure();
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
            default: 
        }
	}
    
    
   
    }
}