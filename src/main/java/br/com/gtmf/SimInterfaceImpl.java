package br.com.gtmf;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

import org.geotools.referencing.GeodeticCalculator;

import br.com.gtmf.controller.JavaSpaceController;
import br.com.gtmf.model.Client;

@WebService(endpointInterface="br.com.gtmf.SimInterfaceImpl")
public class SimInterfaceImpl implements SimInterface{
	
	public String login(String nickname) {
		
		if(!JavaSpaceController.getInstance().isConnected()){
			System.err.println("[JAX-WS] JavaSpaces não está disponível!");
			return "error";
		}
		
		if(!JavaSpaceController.getInstance().addClient(nickname)){
			System.err.println("[JAX-WS] Usuário já existe!");
			return "error";
		}
		
		System.out.println("[JAX-WS] ADD: " + nickname);		
		return getRoom(nickname);
	}

	public String logout(String nickname) {
		
		if(!JavaSpaceController.getInstance().isConnected()){
			System.err.println("[JAX-WS] JavaSpaces não está disponível!");
			return "error";
		}
		
		if(!JavaSpaceController.getInstance().removeClient(nickname)){
			System.err.println("[JAX-WS] Não foi possível remover o usuário!");
			return "error";
		}
		
		System.out.println("[JAX-WS] DEL: " + nickname);		
		return nickname;
	}

	public String startRadar(String nickname, String location) {
		try {
			Client client = JavaSpaceController.getInstance().getClient(nickname);

			if (client == null){
				System.err.println("[JAX-WS] Não foi possível encontrar o usuário " + nickname + "!");
				return "error";
			}

			System.out.println("[JAX-WS] START RADAR: " + nickname + " " + location);
			client.locationToLatLng(location);
			
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			System.err.println("[JAX-WS] Não foi possível converter coordenadas para o tipo double");
			return "error";
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "error";
		}
		
		return toStringList(JavaSpaceController.getInstance().getRooms());
	}

	public String stopRadar(String nickname) {
		Client client = JavaSpaceController.getInstance().getClient(nickname);

		if (client == null){
			System.err.println("[JAX-WS] Não foi possível encontrar o usuário " + nickname + "!");
			return "error";
		}

		System.out.println("[JAX-WS] STOP RADAR: " + nickname);
		client.setLat(0.0);
		client.setLng(0.0);
		
		return nickname;
	}

	public String write(String from, String message) {
		Client client = JavaSpaceController.getInstance().getClient(from);

		if (client == null){
			System.err.println("[JAX-WS] Não foi possível encontrar o usuário " + from + "!");
			return "error";
		}

		System.out.println("[JAX-WS] (write) " + from + ": " + message);
		client.getMessages().add(message);
		
		return "ok";
	}

	public String writeTo(String from, String to, String message) {
		Client clientFrom = JavaSpaceController.getInstance().getClient(from);
		Client clientTo = JavaSpaceController.getInstance().getClient(to);

		if (clientFrom == null || clientTo == null){
			System.err.println("[JAX-WS] Não foi possível encontrar o usuário " + from + "!");
			return "error";
		}

		System.out.println("[JAX-WS] (writeTo) " + from + " -> " + to + ": " + message);
		clientFrom.getMessages().add(to + ": " + message);
		
		return "ok";
	}

	public String changeLocation(String nickname, String location) {
		// Obtem os clientes mais proximos
		Collection<Client> nearly;
		try {
			Client client = JavaSpaceController.getInstance().getClient(nickname);

			if (client == null){
				System.err.println("[JAX-WS] Não foi possível encontrar o usuário " + nickname + "!");
				return "error";
			}

			System.out.println("[JAX-WS] CHANGE LOCATION: " + nickname + " " + location);
			
			// atualiza a localizacao
			client.locationToLatLng(location);

			nearly = getNearlyClients(client);
			return toString(nearly);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "error";
		}
	}

	public String listNearlyClients(String nickname) {
		try{
			Client client = JavaSpaceController.getInstance().getClient(nickname);

			if (client == null){
				System.err.println("[JAX-WS] Não foi possível encontrar o usuário " + nickname + "!");
				return "error";
			}
			
			System.out.println("[JAX-WS] NEARLY CLIENTS FROM " + nickname);

			// Obtem os clientes mais proximos
			Collection<Client> nearly = getNearlyClients(client);
			return toString(nearly);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "error";
		}
	}

	public String addRoom(String roomName) {
		if(!JavaSpaceController.getInstance().isConnected()){
			System.err.println("[JAX-WS] JavaSpaces não está disponível!");
			return "error";
		}
		
		if(!JavaSpaceController.getInstance().addRoom(roomName)){
			System.err.println("[JAX-WS] Sala já existe!");
			return "error";
		}
		
		System.out.println("[JAX-WS] ADD ROOM: " + roomName);
		
		return toStringList(JavaSpaceController.getInstance().getRooms());
	}

	public String getRoom(String clientName) {
		if(!JavaSpaceController.getInstance().isConnected()){
			System.err.println("[JAX-WS] JavaSpaces não está disponível!");
			return "error";
		}
		
		Client client = JavaSpaceController.getInstance().getClient(clientName);

		if (client == null){
			System.err.println("[JAX-WS] Não foi possível encontrar o usuário " + clientName + "!");
			return "error";
		}
		
		System.out.println("[JAX-WS] GET ROOM: " + clientName + " " + client.getRoom());
		
		return client.getRoom();
	}

	public String listRooms() {
		if(!JavaSpaceController.getInstance().isConnected()){
			System.err.println("[JAX-WS] JavaSpaces não está disponível!");
			return "error";
		}
		
		return toStringList(JavaSpaceController.getInstance().getRooms());
	}

	public String changeClientRoom(String clientName, String roomName) {
		try {
			if(!JavaSpaceController.getInstance().isConnected()){
				System.err.println("[JAX-WS] JavaSpaces não está disponível!");
				return "error";
			}
			
			if(!JavaSpaceController.getInstance().changeClientRoom(clientName, roomName)){
				System.err.println("[JAX-WS] Não foi possível mudar o cliente de sala!");
				return "error";
			}
			
			Client client = JavaSpaceController.getInstance().getClient(clientName);

			if (client == null){
				System.err.println("[JAX-WS] Não foi possível encontrar o usuário " + clientName + "!");
				return "error";
			}
			
			Collection<Client> nearly = getNearlyClients(client);
			
			return toString(nearly);
			
		} catch (Exception e) {
			System.err.println("[JAX-WS] Não foi possível mudar o cliente de sala!");
			return "error";
		}
	}

	/**
	 * 
	 * @param nickname
	 * @param me
	 * @return
	 * @throws Exception
	 */
	private Collection<Client> getNearlyClients(Client me) throws Exception {
		Collection<Client> tmpUsersON = JavaSpaceController.getInstance().getClients().values();
		
		Collection<Client> nearlyClients = new ArrayList<Client>();
					
		for (Client other : tmpUsersON) {
//			System.out.println(other.getNickname() + " " + other.getLat() + " " + other.getLng());
			
			if(!other.equals(me) && other.getLat() != 0.0 && other.getLng() != 0.0
					&& other.getRoom().equals(me.getRoom())){
				
				// calcula a distancia entre os usuarios
				int totalmeters = calcDistance(
						me.getLat(), me.getLng(),
						other.getLat(), other.getLng());
				
				boolean isNearly = totalmeters <= 20000;				
//				System.out.println(isNearly + " " + totalmeters);
				
				if(isNearly){
					other.setDistance(totalmeters);
					nearlyClients.add(other);
				}
			}
		}
		
		return nearlyClients;
	}

	/**
	 * Calcula a distancia entre duas coordenadas
	 * utilizando uma biblioteca de mapas
	 * 
	 * @param latBegin
	 * @param lngBegin
	 * @param latEnd
	 * @param lngEnd
	 * @return
	 */
	public static int calcDistance(double latBegin, double lngBegin, double latEnd, double lngEnd) {
		GeodeticCalculator gc = new GeodeticCalculator(); 
		gc.setStartingGeographicPoint(lngBegin, latBegin); 
		gc.setDestinationGeographicPoint(lngEnd, latEnd);
		double distance = gc.getOrthodromicDistance(); 
		
		int totalmeters = (int) distance;
//		int km = totalmeters / 1000;
		
		return totalmeters;
	}

	public String toStringList(List<String> list) {
		StringBuffer arr = new StringBuffer();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String item = (String) iterator.next();
			
			arr.append(item);
			
			if(iterator.hasNext()){
				arr.append(";");
			}
		}
	    
	    return arr.toString().trim();
	}

	public String toString(Collection<Client> clients) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		StringBuffer arr = new StringBuffer();

		for (Iterator iterator = clients.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			
			arr.append(client.getNickname()
					+ " " + df.format(client.getDistance()) + " m"
			);
			
			if(iterator.hasNext()){
				arr.append(";");
			}
		}
	    
	    return arr.toString().trim();
	}

}
