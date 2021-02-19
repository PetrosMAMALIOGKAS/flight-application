package co.simplon.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.dao.DaoContext;
import co.simplon.dao.LivreDao;
import co.simplon.dao.VolDao;
import co.simplon.model.Livre;
import co.simplon.model.Vol;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VolDao volDao;
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter( "action" );
		
		switch (action) {
			
		case "lister" :
			System.out.println( " lister  *********************");
			ArrayList<Vol> listVols =  (ArrayList<Vol>) volDao.lister();
			request.setAttribute("listVols", listVols);
			response.setCharacterEncoding("UTF-8");
			
			this.getServletContext().getRequestDispatcher("/listerVols.jsp").forward(request, response);
			
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
