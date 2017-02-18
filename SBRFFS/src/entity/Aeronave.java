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
public class Aeronave extends Thread {
private String pfx; //prefixo
private int fp;  //flight priority 
private float fuel; //em toneladas 
private final int MAX_PRIORITY = 10;
private final int MED_PRIORITY = 5;
private final int LOW_PRIORITY = 0;


public Aeronave(String pfx,float fuel){
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
public void setFuel(float fuel){
    this.fuel=fuel; 
}
public void decrementFuel(){
    this.fuel=this.fuel--;
}

private void flightPriority(){                           /*A prioridade de vôo vai ser definida de acordo
                                                           com a quantidade de combustivel que a aeronave
                                                           carrega*/
    if (this.getFuel() >= 7){
        this.setFlightPriority(LOW_PRIORITY);      
    }else if(this.getFuel() < 7 && this.getFuel() > 3){
        this.setFlightPriority(MED_PRIORITY);
    }else if(this.getFuel() <= 3){
        this.setFlightPriority(MAX_PRIORITY);
    }
}







    
}
