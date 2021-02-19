package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Site;
import co.simplon.model.Vol;

public class SiteDaoImpl implements SiteDao {
	
	private DaoContext daocontext;
	
	public SiteDaoImpl(DaoContext daocontext) {
		this.daocontext = daocontext;
	}

	@Override
	public void ajouter(Site site) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO site VALUES (null , ?);";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, site.getVille());
			
			preparedStatement.executeUpdate();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("le Site  " + site.getVille() + " a ete ajoute dans La BDD");
		
	}

	@Override
	public List<Site> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifier(Site site) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerSiteById(int site_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Site getSiteById(int site_id) {
		Site site = new Site.Builder()
							.site_id(site_id)
							.build();
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM site WHERE site_id = ?;";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, site_id);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {

				site.setVille(result.getString(2));
			}
			
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return site;
	}

	@Override
	public Site getSiteByVille(String ville) {
		Site site = new Site.Builder()
				.ville(ville)
				.build();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM site WHERE ville = ?;";
		
		try {
		
		connection = DaoContext.getConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, ville);
		result = preparedStatement.executeQuery();
		
		while(result.next()) {
		
			site.setSite_id(result.getInt(1));
		}
		
		connection.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return site;
		
	}

}
		
		

