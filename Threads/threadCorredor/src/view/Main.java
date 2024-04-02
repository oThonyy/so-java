package view;

import java.util.concurrent.Semaphore;

import controller.threadCorredor;

public class Main {

	public static void main (String[] args) {
		
		String[] vetPessoas = {"Fulano", "Cicrano", "Beltrano", "José Magalhães"};
		Semaphore mut = new Semaphore(1);
		int id;
		
		for (id = 0; id < 4; id++) {
			Thread threadCorredor = new threadCorredor(vetPessoas[id], mut);
			threadCorredor.start();
		}
	}

}
