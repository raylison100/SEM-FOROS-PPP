
import entity.Airplane;
import entity.PassageirosBuffer;
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
        PassageirosBuffer buf = new PassageirosBuffer();
        Semaphore sem1 = new Semaphore(100);
        Semaphore sem2 = new Semaphore(100);
        Semaphore sem3 = new Semaphore(100);
        Airplane a1 = new Airplane("PPT-225", buf, sem1, sem2, sem3);
        Airplane a2 = new Airplane("LZK-123", buf, sem1, sem2, sem3);
        Airplane a3 = new Airplane("KRT-245", buf, sem1, sem2, sem3);
        Airplane a4 = new Airplane("ARD-453", buf,sem1, sem2, sem3);
        Airplane a5 = new Airplane("ASF-223", buf, sem1, sem2, sem3);
        Airplane a6 = new Airplane("NMR-768", buf, sem1, sem2, sem3);
        Airplane a7 = new Airplane("LOL-666", buf, sem1, sem2, sem3);
        Airplane a8 = new Airplane("AEF-724", buf, sem1, sem2, sem3);
        Airplane a9 = new Airplane("KPT-765", buf, sem1, sem2, sem3);
        Airplane a10 = new Airplane("LRE-876", buf, sem1, sem2, sem3);
        Airplane a11 = new Airplane("PPE-254", buf, sem1, sem2, sem3);
        Airplane a12 = new Airplane("HUE-576", buf, sem1, sem2, sem3);
        Airplane a13 = new Airplane("PSD-243", buf, sem1, sem2, sem3);
        Airplane a14 = new Airplane("TRD-943", buf, sem1, sem2, sem3);
        Airplane a15 = new Airplane("LLR-365", buf, sem1, sem2, sem3);
        Airplane a16 = new Airplane("FRE-363", buf, sem1, sem2, sem3);
        Airplane a17 = new Airplane("BGR-274", buf, sem1, sem2, sem3);
        Airplane a18 = new Airplane("MXD-743", buf, sem1, sem2, sem3);
        Airplane a19 = new Airplane("QWE-536", buf, sem1, sem2, sem3);
        Airplane a20 = new Airplane("YTU-843", buf, sem1, sem2, sem3);
        Airplane a21 = new Airplane("WER-246", buf, sem1, sem2, sem3);
        Airplane a22 = new Airplane("KJG-653", buf, sem1, sem2, sem3);
        Airplane a23 = new Airplane("PAW-243", buf, sem1, sem2, sem3);
        Airplane a24 = new Airplane("CVB-865", buf, sem1, sem2, sem3);
        Airplane a25 = new Airplane("AHG-246", buf, sem1, sem2, sem3);
        Airplane a26 = new Airplane("PRT-294", buf, sem1, sem2, sem3);
        Airplane a27 = new Airplane("DSF-875", buf, sem1, sem2, sem3);
        Airplane a28 = new Airplane("KLE-942", buf, sem1, sem2, sem3);
        Airplane a29 = new Airplane("TRT-322", buf, sem1, sem2, sem3);
        
       
        a1.start();
        a2.setIntension(2);
        a2.start();
        //a2.join();
        //a1.join();
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
        a15.setIntension(2);
        a15.start();
        a16.start();
        a17.setIntension(3);
        a17.start();
        a18.setIntension(2);
        a18.start();
        a19.start();
        a20.setIntension(3);
        a20.start();
        a21.setIntension(2);
        a21.start();
        a22.start();
        a23.setIntension(3);
        a23.start();
        a24.setIntension(2);
        a24.start();
        a25.start();
        a26.setIntension(3);
        a26.start();
        a27.start();
        a28.start();
        a29.start();
        
        
        }
}
