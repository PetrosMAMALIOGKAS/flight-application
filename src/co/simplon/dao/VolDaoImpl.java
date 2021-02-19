package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Site;
import co.simplon.model.Vol;

public class VolDaoImpl implements VolDao {
	

		private DaoContext daocontext;
		
		public VolDaoImpl(DaoContext daocontext) {
			this.daocontext = daocontext;
		}
		
	
		
		
		@Override
		public List<Vol> lister() {
			
			List<Vol> listVols = new ArrayList<Vol>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet result = null;
			String query = "SELECT * FROM vol;";
			
			try {
				
				connection = DaoContext.getConnection();
				preparedStatement = connection.prepareStatement(query);
				result = preparedStatement.executeQuery();
				
				while(result.next()) {
					listVols.add(new Vol.Builder()
											.vol_id(result.getString(1))
											.avion(result.getInt(2))
											.pilote(result.getInt(3))
											.ville_depart(new Site.Builder()
																  .site_id(result.getInt(4))
																  .build()
															)
											.ville_arriver(new Site.Builder()
																   .site_id(result.getInt(5))
																   .build()
															)
											.build());  
				}
				
				connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
			return listVols;
		}




		@Override
		public void ajouter(Vol vol) {
			// TODO Auto-generated method stub
			
		}




		@Override
		public void modifier(Vol vol) {
			// TODO Auto-generated method stub
			
		}




		@Override
		public void supprimerVolById(String vol_id) {
			// TODO Auto-generated method stub
			
		}
		
		
	 
	
	 
	
	

		
	

}
