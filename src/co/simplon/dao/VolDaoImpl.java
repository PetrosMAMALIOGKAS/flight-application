package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Vol;

public class VolDaoImpl implements VolDao {
	

		private DaoContext daocontext;
		
		public VolDaoImpl(DaoContext daocontext) {
			this.daocontext = daocontext;
		}
		
		@Override
		public void ajouter(Vol vol) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String query = "INSERT INTO livre VALUES (null, ?,?,?);";
			
			try {
				
				connection = DaoContext.getConnection();
				preparedStatement = connection.prepareStatement(query);
			//	preparedStatement.setString(1, livre.getTitre());
			//	preparedStatement.setInt(2, Integer.parseInt(livre.getAuteur().getId_auteur()));
			//	preparedStatement.setInt(3, Integer.parseInt(livre.getGenre().getGenre_id()));
				preparedStatement.executeUpdate();
				connection.close();
				
			} catch (SQLException e) {
				
				
				e.printStackTrace();
				
			}
			
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
											.ville_depart(result.getInt(4))
											.ville_arriver(result.getInt(5))
											.build());  
				}
				
				connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
			return listVols;
		}
		
		
	 
	
	 
		@Override
		public void modifier(Vol vol) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String query = "UPDATE  livre SET titre = ?, auteur= ?, genre =? WHERE livre_id = ?;";
			
			try {
				
				connection = DaoContext.getConnection();
				preparedStatement = connection.prepareStatement(query);
			//	preparedStatement.setInt(4, Integer.parseInt(livre.getId()));
			//	preparedStatement.setString(1, livre.getTitre());
			//	preparedStatement.setInt(2, Integer.parseInt(livre.getAuteur().getId_auteur()));
			//	preparedStatement.setInt(3, Integer.parseInt(livre.getGenre().getGenre_id()));
				preparedStatement.executeUpdate();
				connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
	 
		@Override
		public void supprimerVolById(String vol_id) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String query = "DELETE FROM livre WHERE livre_id = ?;";
			
			try {
				connection = DaoContext.getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(vol_id));
				preparedStatement.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}

		}

		
	

}
