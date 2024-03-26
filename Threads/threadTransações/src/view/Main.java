package view;

import java.util.concurrent.Semaphore;

import controller.Threads;

public class Main {

	public static void main(String[] args) {
		Semaphore mut = new Semaphore(1);
		
		for(int id = 1; id <= 21; id++) {
			Thread db = new Threads(id, mut);
			db.start();
		}
	}
}