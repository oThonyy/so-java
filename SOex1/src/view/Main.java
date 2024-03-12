package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		//Instanciando
		RedesController sysV = new RedesController();
		
		//Exibir sistema operacional
		String os = sysV.chamarSoName();
		System.out.println(os);
		
		//Checando sistema para ver IP
		String ip = sysV.ip(os);
		System.out.println(ip);	
				
		//Fazendo chamada de ping com 10 iterações
		String ping = sysV.ping(os);
		System.out.println(ping);
	}

}
