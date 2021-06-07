package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtil;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CSRF対策
        request.setAttribute("_token", request.getSession().getId());

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messages/search.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token = request.getParameter("_token");
		if(_token != null && _token.equals(request.getSession().getId())){
			EntityManager em = DBUtil.createEntityManager();

			String title = request.getParameter("title");
			String content = request.getParameter("content");

			if(title.equals("")&&content.equals("")){

			}else if(title != null){
				List<String> rtitle = getTitle(title,em);
				request.setAttribute("rtitle",rtitle);
				em.close();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messages/searchResult.jsp");
		rd.forward(request, response);
	}

	public static List<String> getTitle(String title,EntityManager em){
		Query query = em.createQuery("SELECT m FROM Message AS m WHERE m.title = :title");
		query.setParameter("title", title);
		return query.getResultList();
	}

}
