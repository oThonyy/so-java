package view;

import java.util.concurrent.Semaphore;

import controller.threadCarro;

public class Main {
	
	public static void main (String[] args) {
		Semaphore mut = new Semaphore(1);
		int id;
		
		for (id = 0; id < 8; id++) {
			Thread threadCarro = new threadCarro(id, mut);
			threadCarro.start();
		}
	}
	
}
