package controller;

import java.util.concurrent.Semaphore;

public class threadCarro extends Thread{

	
	static String[] vetDirecao = {"esquerda.", "cima.", "direita.", "baixo."};
	private int id;
	Semaphore mut;
	
	
	public threadCarro(int id, Semaphore mut) {
		this.id = id;
		this.mut = mut;
	}
	
	
	public void run() {
		try {
			mut.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			mut.release();
		}
	}
	
	
	public void cruzamento() {
		int direcao = (int)(Math.random() * 4);
		
		System.out.println("O carro " + (id + 1) + " está cruzando para " + vetDirecao[direcao]);
		
		try {
			sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
}
