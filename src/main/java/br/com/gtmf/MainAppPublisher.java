package br.com.gtmf;

import javax.xml.ws.Endpoint;

/**
 * Classe publicadora do Servico Web
 * 
 */
public class MainAppPublisher {
	
	public static void main(String[] args) {
		
		String url = "http://localhost:8080/ws/sim";
		
		System.out.println("======================================================================");
		System.out.println("= Curso: Engenharia de Computação");
		System.out.println("= Disciplina: Programação Paralela e Distribuída");
		System.out.println("= Trabalho: Sistema de Interação Móvel (SIM)");
		System.out.println("= Aluno: Gabriel Tavares [https://github.com/gabrieltavaresmelo]");
		System.out.println("==========");
		System.out.println("=");
		System.out.println("= Aplicação: WebService utilizando JAX-WS");
		System.out.println("=");
		System.out.println("= Acesse o browser na seguinte URL:");
		System.out.println("= " + url + "?wsdl");
		System.out.println("=");
		System.out.println("======================================================================");
		
		// Inicia o servidor web
		Endpoint.publish(url, new SimInterfaceImpl());
	}
	
}
