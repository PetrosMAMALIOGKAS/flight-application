package co.simplon.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.dao.DaoContext;
import co.simplon.dao.SiteDao;
import co.simplon.dao.VolDao;
import co.simplon.model.Site;
import co.simplon.model.Vol;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VolDao volDao;
	private SiteDao siteDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init() {	 
    	DaoContext daoContext = new DaoContext();
    	this.volDao = daoContext.getVolDao();
    	this.siteDao = daoContext.getSiteDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String execute = request.getParameter( "execute" );
		
		switch (execute) {
			
		case "lister" :
			ArrayList<Vol> listVols =  (ArrayList<Vol>) volDao.lister();
			for (Vol vol : listVols) {
				Site siteArriver = siteDao.getSiteById( vol.getVille_arriver().getSite_id() );
				Site siteDepart = siteDao.getSiteById( vol.getVille_depart().getSite_id() );
				
				vol.setVille_arriver(siteArriver);
				vol.setVille_depart(siteDepart);
			}
			request.setAttribute("listVols", listVols);
			response.setCharacterEncoding("UTF-8");
			
			this.getServletContext().getRequestDispatcher("/listerVols.jsp").forward(request, response);
			
			break;
		case "ajouterSite" :
			response.setCharacterEncoding("UTF-8");
			this.getServletContext().getRequestDispatcher("/ajouterSite.jsp").forward(request, response);
			
		break;
		
			
		default :
			System.out.println( " deafult *********************");
		break;
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String execute = request.getParameter( "execute" );
		
		switch (execute) {
		
		case "ajouterSite" :
			String ville = request.getParameter( "ville" );
			ville = ville.toUpperCase();
			Site site = siteDao.getSiteByVille(ville);
			
			if ( site.getSite_id() == 0 ) {
				siteDao.ajouter( site );
			}
			else {
				System.out.println( "le site " + ville + " existe déjà dans la BDD");
			}
			
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		break;
		default :
			System.out.println( " deafult POST*********************");
		break;
		}
		
	}

}
