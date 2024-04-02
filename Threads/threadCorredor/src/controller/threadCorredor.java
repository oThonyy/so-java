package controller;

import java.util.concurrent.Semaphore;

public class threadCorredor extends Thread{

	
	private String pessoa;
	Semaphore mut;
	
	
	public threadCorredor (String pessoa, Semaphore mut) {
		this.pessoa = pessoa;
		this.mut = mut;
		
	}
	
	
	public void run() {
		corredor();
		try {
			mut.acquire();
			porta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			mut.release();
		}
	}
	
	
	private void corredor() {
		int percurso = 0;
		
		while (percurso < 200) {
			int velocidade = (int) ((Math.random() * 3) + 4);
			percurso = percurso + velocidade;
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());;
			}
			System.out.println(pessoa + " andou " + percurso + " metros no corredor.");
		}
	}
	
	
	private void porta() {
		System.out.println(pessoa + " está abrindo a porta...");
		int tempo = (int) ((Math.random()* 1001) + 1000);
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());;
		}
		System.out.println(pessoa + " cruzou a porta.");
	}
	
}
