package controller;

import java.util.concurrent.Semaphore;

public class Threads extends Thread{

	
	private int resto;
	private int id;
	private int tempo;
	private Semaphore mut;
	
	
	public Threads() {
		super();
	}
	
	
	public Threads(int idThread, Semaphore mut) {
		this.id = idThread;
		this.mut = mut;
	}
	
	
	public void run() {
		calculoResto();
		try {
			mut.acquire();
			processamento();
		} catch (InterruptedException e) {
			System.err.println(e);
		} finally {
			mut.release();
		}
	}
	
	
	private int calculoResto() {
		resto = id % 3;
		return resto;
	}
	
	
	private void processamento() {
		if (resto == 1) {
			tempo = (int)((Math.random() * 801) + 200);
			
			try {
				System.out.println("#" + id + " está calculando.");
				sleep(tempo);
				System.out.println("#" + id + " está fazendo a transação com o banco de dados");
				sleep(1000);
				System.out.println("#" + id + " finalizou a transação");
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

		else if (resto == 2) {
			tempo = (int)((Math.random() * 1001) + 500);
			
			try {
				System.out.println("#" + id + " está calculando.");
				sleep(tempo);
				System.out.println("#" + id + " está fazendo a transação com o banco de dados");
				sleep(1500);
				System.out.println("#" + id + " finalizou a transação");
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
		
		else if (resto == 0) {
			tempo = (int)((Math.random() * 1001) + 1000);
			
			try {
				System.out.println("#" + id + " está calculando.");
				sleep(tempo);
				System.out.println("#" + id + " está fazendo a transação com o banco de dados");
				sleep(1500);
				System.out.println("#" + id + " finalizou a transação");
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}