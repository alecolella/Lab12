package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Risultato {
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int numMeasurement;
	private float fMed; 
	private List<Flow> flussi;
	
	public Risultato(LocalDate startDate, LocalDate endDate, int numMeasurement, float avgFlow) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.numMeasurement = numMeasurement;
		this.fMed = avgFlow;		
		this.flussi = new ArrayList<Flow>();
		
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getNumMeasurement() {
		return numMeasurement;
	}
	public void setNumMeasurement(int numMeasurement) {
		this.numMeasurement = numMeasurement;
	}
	public float getAvgFlow() {
		return fMed;
	}
	public void setAvgFlow(float avgFlow) {
		this.fMed = avgFlow;
	}
	
	
	public List<Flow> getFlussi() {
		return flussi;
	}
	public void setFlussi(List<Flow> flussi) {
		this.flussi = flussi;
	}
	@Override
	public String toString() {
		return "Risultato [startDate=" + startDate + ", endDate=" + endDate + ", numMeasurement=" + numMeasurement
				+ ", avgFlow=" + fMed + "]";
	}
	
	
	

}
