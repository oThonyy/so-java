package view;

import java.util.Scanner;
import controle.ClasseControlador;

public class ClassePrincipal {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
        System.out.print("Informe o Symbol: ");
        String symbol = scan.nextLine();
        scan.close();

        String arquivo = "C:\\Windows\\Temp\\btc.json";
        ClasseControlador controle = new ClasseControlador(arquivo);

        String lastPrice = controle.obterLastPrice(symbol);
        System.out.println("LastPrice: " + lastPrice);
        
	}
}
