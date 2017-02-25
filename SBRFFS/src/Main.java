
import entity.Aeronave;
import negocios.BufferAero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michel Perilo
 */
public class Main {
    
    public static void main (String[]args) throws InterruptedException{
        BufferAero buffer = new BufferAero();
        Aeronave a1 = new Aeronave(buffer,"PPT-225\n",5,false);
        Aeronave a2 = new Aeronave(buffer,"LZK-123\n",2,true);
        a1.start();
        a2.start();
        a1.join();
        a2.join();
        buffer.print();
    }
    
}
