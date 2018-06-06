package it.polito.tdp.rivers.model;

import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	private RiversDAO dao;
	private List<River> fiumi;
	private Risultato res;
	private Simulatore sim;

	public Model() {
		
		dao = new RiversDAO();
		fiumi = dao.getAllRivers();
	}

	public List<River> getFiumi() {
		return fiumi;
	}

	public Risultato getRisultati(River r) {
		res = dao.getRisultato(r);
		return res;
	}

	public void simula(int k) {
		float q = 30*k*(res.getAvgFlow()/(24*3600));
		sim = new Simulatore();
		sim.init(q, res);
		sim.run();
		
		
	}
	
	

}
