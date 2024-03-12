package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}
	
	private String soName() {
		String os = (System.getProperty("os.name"));
		System.out.println(os);
		return os;
	}
	
	public String chamarSoName() {
		return soName();
	}
	
	public String ip(String OS) {
		String process = "";
		if (OS.contains("Win")){
			process = "IPCONFIG";
		}else if(OS.contains("nux")) {
			process = "ip addr";
		}else if(OS.contains("nix")) {
			process = "ifconfig";
		}
		return lerProcesso(process);
	}
	public String ping(String OS) {
		String process = "";
		if (OS.contains("Win")){
			process = "ping -4 -n 10 www.google.com.br";
		}else {
			process = "ping -4 -c 10 www.google.com.br";
	}
		return chamaProcesso(process);
	}
	
	public String chamaProcesso(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);	
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		return process;
	}
	
	public String lerProcesso(String process) {
		  try {
		    Process p = Runtime.getRuntime().exec(process);
		    
		    InputStream fluxo = p.getInputStream();
		    InputStreamReader leitor = new InputStreamReader(fluxo);
		    BufferedReader buffer = new BufferedReader(leitor);

		    StringBuilder sb = new StringBuilder();
		    String linha;
		    while ((linha = buffer.readLine()) != null) {
		      sb.append(linha).append("\n");
		    }
		    
		    String[] saidaSplit = sb.toString().split("\n");
		    String adaptadorRede = "";
		    String ipv4 = "";
		    for (String linhaSplit : saidaSplit) {
		      if (linhaSplit.contains("Ethernet") || linhaSplit.contains("Wi-Fi")) {
		        adaptadorRede = linhaSplit;
		      }
		      if (linhaSplit.contains("IPv4")) {
		        ipv4 = linhaSplit;
		      }
		    }
		    
		    String saida = adaptadorRede + "\n" + ipv4;
		    return saida;
		  } catch (IOException e) {
		    e.printStackTrace();
		    return "erro";
		  }
		}
}
