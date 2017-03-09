
import entity.Airplane;
import java.util.concurrent.Semaphore;

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
        //BufferAP buffer = new BufferAP();
        Semaphore sem1 = new Semaphore(100);
        Semaphore sem2 = new Semaphore(100);
        Semaphore sem3 = new Semaphore(100);
        (new Airplane("PPT-226",5, sem1, sem2, sem3)).start();
        Airplane a1 = new Airplane("PPT-225",5, sem1, sem2, sem3);
        Airplane a2 = new Airplane("LZK-123",2,sem1, sem2, sem3);
        Airplane a3 = new Airplane("KKK-245",5, sem1, sem2, sem3);
        Airplane a4 = new Airplane("ASD-453",2,sem1, sem2, sem3);
        Airplane a5 = new Airplane("PPK-223",5, sem1, sem2, sem3);
        Airplane a6 = new Airplane("XXT-768",2,sem1, sem2, sem3);
        Airplane a7 = new Airplane("LOL-666",5, sem1, sem2, sem3);
        Airplane a8 = new Airplane("WTF-724",2,sem1, sem2, sem3);
        Airplane a9 = new Airplane("KCT-765",5, sem1, sem2, sem3);
        Airplane a10 = new Airplane("KRL-876",2,sem1, sem2, sem3);
        Airplane a11 = new Airplane("PQP-254",5, sem1, sem2, sem3);
        Airplane a12 = new Airplane("HUE-576",2,sem1, sem2, sem3);
        Airplane a13 = new Airplane("POO-243",5, sem1, sem2, sem3);
        Airplane a14 = new Airplane("FDC-943",2,sem1, sem2, sem3);
        
       
        a1.start();
        a2.setIntension(2);
        a2.start();
        a2.join();
        a1.join();
        a3.start();
        a4.setIntension(3);
        a4.start();
        a5.start();
        a6.setIntension(1);
        a6.start();
        a7.start();
        a10.setIntension(2);
        a10.start();
        a8.start();
        a13.setIntension(1);
        a13.start();
        a12.start();
        a11.setIntension(2);
        a11.start();
        a9.start();
        a14.setIntension(3);
        a14.start();
        
        a3.join();
        a4.join();
        a5.join();
        a6.join();
        a7.join();
        a8.join();
        a9.join();
        //buffer.print();
        
        }
}
