
import entity.Airplane;
import negocios.BufferAP;

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
        BufferAP buffer = new BufferAP();
        Airplane a1 = new Airplane(buffer,"PPT-225\n",5,false);
        Airplane a2 = new Airplane(buffer,"LZK-123\n",2,true);
        a1.start();
        a2.start();
        a1.join();
        a2.join();
        buffer.print();
    }
    
}
