package it.polito.tdp.rivers.model;

import java.util.List;
import java.util.PriorityQueue;

import com.sun.xml.internal.fastinfoset.stax.events.ProcessingInstructionEvent;

public class Simulatore {
	
	//Coda eventi
	private PriorityQueue<Event> coda;
	
	//Modello del mondo
	private float c; //q.tà acqua nel bacino da aggiornare gg per gg
	private float f_out_min; //erogazione minima
	private List<Flow> flussi;
	private EventType tipo;
	
	//Parametri simulazione
	private float cMax; //capienza massima
	
	//Variabili output
	private float cMed; //occupazione media
	private int ggOff; 

	public void init(float q, Risultato res) {
		this.flussi = res.getFlussi();
		cMax = q;
		c=q/2;
		cMed=0;
		ggOff= 0;
		f_out_min = (float)0.8*res.getAvgFlow();
		coda = new PriorityQueue<Event>();
		if(c+flussi.get(0).getFlow() < cMax) {
		coda.add(new Event(c+flussi.get(0).getFlow(), res.getFlussi().get(0).getDay(), EventType.NORMALE));
		
		}
		else {
			coda.add(new Event(c+flussi.get(0).getFlow(), res.getFlussi().get(0).getDay(), EventType.TRACIMAZIONE));
		}
		
	}

	public void run() {
		
		Event e ;
		while( (e=coda.peek())!=null) {
			processEvent(e);
			
		}
		
		
	}

	private void processEvent(Event e) {
	
		switch (e.getTipo()) {
			
			case NORMALE: //c<cMAX aggunto al bacino
				cMed += e.getPortata();
				
				if(e.getPortata()<f_out_min) {
					ggOff++;
				}
				
				
				break;
				
			case TRACIMAZIONE: //c>cMAX scaricato
				
				break;
		
	}
	}
}
