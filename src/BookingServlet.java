import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public BookingServlet() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String indate = request.getParameter("indate");
		String outdate = request.getParameter("outdate");
		String username1 = request.getParameter("username");
		String rooms = request.getParameter("rooms"); 
		UserDao userDao = new UserDao();

		try {
			int booking = 0 ;
			boolean ifavailable = userDao.checkDate(indate, outdate,Integer.parseInt(rooms));
			String destPage = "booking.jsp";
			HttpSession session = request.getSession();
			if(ifavailable == true) {
				userDao.BookRoom(indate, outdate, username1, rooms);
				booking = userDao.getDetails(indate, outdate);
				session.setAttribute("booking", booking);
				session.setAttribute("indate",indate);
				session.setAttribute("outdate",outdate);
				destPage = "booking.jsp";
			}else {

				destPage = "count.jsp";
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);

		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}    
}