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
public class Aeronave {
private String pfx; //prefixo
private int fp;  //flight priority(meios de estabalecer a prioridade podem ser aperfeiçoados) 
private String dpt; //departure(para fins de negócios)
private float fuel; //em toneladas 

public Aeronave(String pfx,String dpt, float fuel){
    this.pfx = pfx;
    this.fuel=fuel;
    this.dpt=dpt;
}

public int getFlightPriority(){
    return fp;
}
public void setFlightPriority(int fp){
    this.fp = fp;
}

public void flightPriority(){                                                       /*A prioridade de vôo vai ser definidade de acordo
                                                                                      com a quantidade de combustivel que a aeronave
                                                                                      carrega*/
    
}







    
}
