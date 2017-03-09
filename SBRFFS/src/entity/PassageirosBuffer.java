/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author 
 */
public class PassageirosBuffer {
 
    private int total = 1000;
    private int conteudo = 600;
 
    public synchronized void set(String id, int pas) {
        while (total - conteudo < pas) {
            try {
                System.out.println(id + " Aguardando vagas...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        conteudo = conteudo + pas;
        System.out.println(id + " desmbarcou " + pas + " passageiros.");
        notifyAll();
    }
 
    public synchronized int get(String id, int val) {
        val = (int)(Math.random() * 50) + 50;
        while (val > conteudo) {
            try {
                System.out.println(id + ": Passageiros embarcando...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(id + ": " + val + " passageiros embarcados.");
        conteudo = conteudo - val;
        notifyAll();
        return conteudo;
    }
    
    }

