package com.wareHouse.AndroidServices;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.wareHouse.DAO.allTransactionsDAO;
import com.wareHouse.Models.allTransactionsModel;


@Path("/android")
public class allTransactionService {
	//http://localhost:8080/wareHouseWeb/android/allTransactions
		@GET
		@Path("/allTransactions")
		@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
		public List<allTransactionsModel> readProducts() {

			allTransactionsDAO dao = new allTransactionsDAO();
			return dao.read();
		}  
		//http://localhost:8080/wareHouseWeb/rest/allTransactionsWebService/product3
		@GET
		@Path("/allTransactions/{productName}")
		@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
		public List<allTransactionsModel> readProducts(@PathParam ("productName") String productName) {

			allTransactionsDAO dao = new allTransactionsDAO();
			return dao.readProdcutName(productName);
		}  
		
	//  http://localhost:8080/wareHouseWeb/rest/android/allTransaction
			@DELETE
			@Path("/allTransactions")
			@Consumes ({MediaType.APPLICATION_JSON + ";charset=utf-8"}) 
			public Response transactionDelete(allTransactionsModel model) {
				
				allTransactionsDAO dao = new allTransactionsDAO();
				boolean deleteStatus = dao.deleteTransaction(model.getId());
				
				if(deleteStatus == false){
					return Response.status(200).build();
					}
				else
					return Response.status(204).build();

			}  	
			
}
