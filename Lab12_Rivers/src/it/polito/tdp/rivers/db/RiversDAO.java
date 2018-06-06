package it.polito.tdp.rivers.db;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.Risultato;
import it.polito.tdp.rivers.model.River;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RiversDAO {

	public List<River> getAllRivers() {
		
		final String sql = "SELECT id, name FROM river ORDER BY name ASC";

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				rivers.add(new River(res.getInt("id"), res.getString("name")));
			}
			
			

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return rivers;
	}
public Risultato getRisultato(River r) {
	
       Risultato risultato = null;	
       int idRiver = r.getId();	
       LocalDate startDate;
       LocalDate endDate;
       int numMeas = 0;
       float portata = 0;
       float avg = 0;
	    
		final String sql = "SELECT day, flow FROM flow WHERE flow.river = ? ORDER BY day ASC";

		List<Flow> flows = new LinkedList<Flow>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idRiver);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				flows.add(new Flow(res.getDate("day").toLocalDate(), res.getFloat("flow"), r));
				numMeas++;
				portata += res.getFloat("flow");
			}

			conn.close();
			
			
				startDate = flows.get(0).getDay();
				endDate = flows.get(flows.size()-1).getDay();
				avg = portata/numMeas;
			
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
		
		if(startDate != null && endDate != null) {
			risultato = new Risultato(startDate, endDate, numMeas, avg);
		}
		
        risultato.setFlussi(flows);

		return risultato;
	}
	
}

