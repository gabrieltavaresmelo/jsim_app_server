package br.com.gtmf.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.gtmf.model.Client;
import br.com.gtmf.utils.Constants;
import net.jini.core.discovery.LookupLocator;
import net.jini.core.entry.Entry;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.lookup.ServiceMatches;
import net.jini.core.lookup.ServiceRegistrar;
import net.jini.core.lookup.ServiceTemplate;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

public class JavaSpaceController {

	public static final String END_SERVER = "jini://127.0.0.1:4160";
	
	private static JavaSpaceController instance = null;
	
	// Chave: nickname, Valor: Client
	private Map<String, Client> clients = new HashMap<String, Client>();
	private List<String> rooms = new ArrayList<String>();

	private JavaSpace space = null;	
	private boolean isConnected = false;
	
	
	public static JavaSpaceController getInstance() {
		if(instance == null){
			instance = new JavaSpaceController();
		}
		return instance;
	}
	
	public JavaSpaceController() {
		// Implementacao JavaSpaces
//		try {
//			if(inicializarSpace()){
//				isConnected = true;
//			}
//		} catch (Exception e) {
//			System.err.println("O servico JavaSpace nao foi encontrado!");
//			System.err.println(e.getMessage());
//		}
//		
//		isConnected = false;
		
		// Inicializa lista de salas
		rooms.add(Constants.ROOM_COMMOM);
		rooms.add(Constants.ROOM_FOOTBALL);
		rooms.add(Constants.ROOM_FOOD);
		
		isConnected = true;
	}
	
	public boolean isConnected() {
		return isConnected;
	}

	// Implementacao JavaSpaces
//	private boolean inicializarSpace() throws Exception {
//		
//		LookupLocator ll = new LookupLocator(END_SERVER);
//		ServiceRegistrar sr = ll.getRegistrar();
//
//		Class[] classes = { JavaSpace.class };
//		Entry[] entries = {};
//
//		ServiceTemplate template = new ServiceTemplate(
//				null, classes, entries);
//
//		ServiceMatches sms = sr.lookup(template, 10);
//		
//		if (sms.items.length > 0) {
//			space = (JavaSpace) sms.items[0].service;
//			
//			return true;
//		}
//		
//		return false;
//	}

	/**
	 * Adiciona o Cliente no SPACE se ele nao existir
	 * 
	 * @param nickname
	 * @return true: se adicionou | false: se ja existir
	 * 
	 */
	public boolean addClient(String nickname) {
		try {
			// Implementacao JavaSpaces
//			if(space != null){
//
//				Client client = new Client(nickname);
//				Client clientFromSpace = (Client) space.take(client, null, Long.MAX_VALUE);
//				Client clientFromMap = clients.get(nickname);
//				
//				if (!clientExists(clientFromSpace) && !clientExists(clientFromMap)) {
//
//			        Client newClient = new Client(nickname);
//			        
//			        space.write(newClient, null, 60 * 1000);
//					clients.put(nickname, newClient);
//
//					return true;
//			    }
//			}
			
			Client clientFromMap = getClient(nickname);
			
			if (!clientExists(clientFromMap)) {
		        Client newClient = new Client(nickname);
				clients.put(nickname, newClient);

				return true;
		    }
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		
		return false;
	}
	
	/**
	 * Remove o Cliente do SPACE se ele existir
	 * 
	 * @param nickname
	 * @return true: se removeu | false: se ele nao existir
	 * 
	 */
	public boolean removeClient(String nickname) {
		try{
			// Implementacao JavaSpaces
//			if(space != null){
//	
//				Client client = new Client(nickname);
//				Client clientFromSpace = (Client) space.take(client, null, Long.MAX_VALUE);
//				Client clientFromMap = clients.get(nickname);
//				
//				if (!clientExists(clientFromSpace) && !clientExists(clientFromMap)) {
//	                return true;
//	            }
//			}
			
			Client clientFromMap = clients.remove(nickname);
			
			if (clientExists(clientFromMap)) {
				return true;
		    }
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		
		return false;
	}
	
	/**
	 * Adiciona a sala no SPACE se ela nao existir
	 * 
	 * @param nickname
	 * @return true: se removeu | false: se ele nao existir
	 * 
	 */
	public boolean addRoom(String roomName) {
		try{
			if(rooms.contains(roomName)){ // ja existe
				return false;
			}
			
			return rooms.add(roomName);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Remove a sala do SPACE se ela existir
	 * 
	 * @param nickname
	 * @return true: se removeu | false: se ele nao existir
	 * 
	 */
	public boolean delRoom(String roomName) {
		try{
			if (rooms.remove(roomName)) {
				return true;
		    }
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		
		return false;
	}
	
	/**
	 * Muda o cliente de sala
	 * 
	 * @param nickname
	 * @return true: se removeu | false: se ele nao existir
	 * 
	 */
	public boolean changeClientRoom(String clientName, String roomName) {
		try{
			if(!rooms.contains(roomName)){ // Ja existe
				return false;
			}

			Client clientFromMap = getClient(clientName);
			
			if (!clientExists(clientFromMap)) {
				return false;
		    }
			
			clientFromMap.setRoom(roomName);
			
			return true;
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public Client getClient(String nickname) {
		// Implementacao JavaSpaces
//		try{	
//			if(space != null){
//				Client client = new Client(nickname);
//				Client clientFromSpace = (Client) space.read(client, null, Long.MAX_VALUE);
//			}
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//			return null;
//		}
//		
//		return null;
		
		Client client = clients.get(nickname);
		return client;
	}
	
	public Map<String, Client> getClients() {
		return clients;
	}
	
	public List<String> getRooms() {
		return rooms;
	}

    private boolean clientExists(Client client) {
		if (client == null){
			return false;
		}
		
		return true;
    }
}
