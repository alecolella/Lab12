package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Event implements Comparable<Event>{

	private double portata;
	private LocalDate data;
	private EventType tipo;
	
	
	
	public Event(double portata, LocalDate data, EventType tipo) {
		super();
		this.portata = portata;
		this.data = data;
		this.tipo = tipo;
	}
	public double getPortata() {
		return portata;
	}
	public void setPortata(float portata) {
		this.portata = portata;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Event [portata=" + portata + ", data=" + data + "]";
	}
	@Override
	public int compareTo(Event other) {
		// TODO Auto-generated method stub
		return this.data.compareTo(other.data);
	}
	public EventType getTipo() {
		return tipo;
	}
	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}
	
	
}
