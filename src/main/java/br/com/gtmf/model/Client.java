package br.com.gtmf.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gtmf.utils.Constants;
import net.jini.core.entry.Entry;

public class Client implements Entry{

	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private double lat = 0.0;
	private double lng = 0.0;
	private double distance = 0.0;
	private String room = Constants.ROOM_COMMOM;
	private List<String> messages = new ArrayList<String>();

	public Client() {
	}
	
	public Client(String nickname) {
		this.nickname = nickname;
	}

	public Client(String nickname, double lat, double lng) {
		this.nickname = nickname;
		this.lat = lat;
		this.lng = lng;
	}

	public Client(String nickname, String location) {
		this.nickname = nickname;
		locationToLatLng(location);
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public String getRoom() {
		return room;
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	// Modelo: -3,85678,-3898768
	public void locationToLatLng(String location) throws NumberFormatException{
		String [] split = location.split(",");
		
		lat = Double.parseDouble(split[0]);
		lng = Double.parseDouble(split[1]);
	}
}
