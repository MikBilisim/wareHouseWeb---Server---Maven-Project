package com.wareHouse.webServices;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.wareHouse.DAO.allTransactionsDAO;
import com.wareHouse.Models.allTransactionsModel;

@Path("/allTransactionsWebService")
public class allTransactionsWebService {

	@GET
	@Path("/allTransactions")
	@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public List<allTransactionsModel> readProducts() {

		allTransactionsDAO dao = new allTransactionsDAO();
		return dao.read();
	}  

	@GET
	@Path("/{productName}")
	@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public List<allTransactionsModel> readProducts(@PathParam ("productName") String productName) {

		allTransactionsDAO dao = new allTransactionsDAO();
		return dao.readProdcutName(productName);
	}  
	
	@POST
	@Path("/delete")
	public Response deleteService(@QueryParam ("id") int id ) {
		
		allTransactionsDAO dao = new allTransactionsDAO();
		boolean deleteStatus = dao.deleteTransaction(id);
		
		if(deleteStatus == false){
			return Response.status(200).build();
			}
		else
			return Response.status(204).build();

	}  
	
	public void allTransactionDao(allTransactionsModel model){
		allTransactionsDAO dao = new allTransactionsDAO();
		dao.add(model);
	}
}
