package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.models.Product;



/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        
    	String Name = request.getParameter("pName");
    	String Colour = request.getParameter("pColour");
    	String Desc = request.getParameter("pDesc");
    	String Quantity = request.getParameter("pQuantity");
    	String CostPrice = request.getParameter("pCostPrice");
    	String SalePrice = request.getParameter("pSalePrice");
   
    	if (Name.isEmpty() ||
    		Desc.isEmpty() ||
    		Colour.isEmpty() ||
    		Quantity.isEmpty() ||
    		CostPrice.isEmpty() ||
    		SalePrice.isEmpty()
    		) {

	        // Save session values
	        session.setAttribute("sName",  request.getParameter("pName"));
	        session.setAttribute("sColour",  request.getParameter("pColour"));
	        session.setAttribute("sDesc",  request.getParameter("pDesc"));
	        session.setAttribute("sQuantity",  request.getParameter("pQuantity"));
	        session.setAttribute("sCostPrice",  request.getParameter("pCostPrice"));
	        session.setAttribute("sSalePrice",  request.getParameter("pSalePrice"));
	        
    	    request.getRequestDispatcher("ProductInput.jsp").include(request, response);
    	    
    		out.print("<br> Input Error: <br>");
    		
	        if (Name.isEmpty()) {
	        	out.print("<br> Missing product name");
	        }
	        if (Desc.isEmpty()) {
	        	out.print("<br> Missing product description");
	        }
	        if (Colour.isEmpty()) {
	        	out.print("<br> Missing product colour");
	        }
	        if (Quantity.isEmpty()) {
	        	out.print("<br> Missing product quantity");
	        }
	        if (CostPrice.isEmpty()) {
	        	out.print("<br> Missing product cost price");
	        }
	        if (SalePrice.isEmpty()) {
	        	out.print("<br> Missing product sale price");
	        }
	        
	        out.print("<br> Please try again ... <br>");
       
    	}
    	else {
 
            Product product = new Product (0, Name, Desc, Colour, Quantity, CostPrice, SalePrice); 
    		
    		SessionFactory sessionFactory = new Configuration()
    				.configure("com/simplilearn/hibernate/hibernate.cfg.xml")
    				.buildSessionFactory();
    		Session sessionF = sessionFactory.openSession();
    		Transaction transaction = sessionF.beginTransaction();

    		sessionF.save(product);
    		transaction.commit();

    		// Clear session values    		
            session.invalidate();
            
    	    request.getRequestDispatcher("ProductInput.jsp").include(request, response);
    	    
        	out.print("<br> Product Added");
    	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.print("<br>");
        out.print("Here in doPost");
		
	}
	
}
