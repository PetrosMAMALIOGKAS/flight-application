package co.simplon.dao;

import java.util.List;
import co.simplon.model.Site;

public interface SiteDao {
	
		void ajouter(Site site);
		List<Site> lister();
		void modifier(Site site);
		void supprimerSiteById(int site_id);
		Site getSiteById(int site_id);
		Site getSiteByVille(String ville);

}
