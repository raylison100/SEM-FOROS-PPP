/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

/**
 *
 * @author Michel Perilo
 */
public class BufferAP {
    private StringBuffer buffer;

	public BufferAP() {
		buffer = new StringBuffer();
	}

	public synchronized void add(String pfx) {
		for (int i = 0; i < pfx.length(); i++)
			buffer.append(pfx.charAt(i));
	}

	public synchronized void print() {
		System.out.println(buffer);
	}
    
}
