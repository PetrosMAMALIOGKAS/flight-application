package co.simplon.dao;

import java.util.List;

import co.simplon.model.Vol;

public interface VolDao {
	
		 
	void ajouter(Vol vol);
	List<Vol> lister();
	void modifier(Vol vol);
	void supprimerVolById(String vol_id);
	
}
