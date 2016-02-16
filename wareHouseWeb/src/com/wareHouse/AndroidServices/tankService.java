package com.wareHouse.AndroidServices;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.wareHouse.DAO.allTransactionsDAO;
import com.wareHouse.DAO.wareHouseTransactionsDAO;
import com.wareHouse.Models.allTransactionsModel;
import com.wareHouse.Models.warehouseModel;

@Path("/android")
public class tankService {
	
	//http://localhost:8080/wareHouseWeb/rest/android/allTransactions
	@GET
	@Path("/liquid_tanks")
	@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public List<warehouseModel> readProducts() {

		wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO("liquid_tanks");
		return dao.read();
	}  
	
		//http://localhost:8080/wareHouseWeb/rest/android/liquid_tanks
		@POST
		@Path("/liquid_tanks")
		@Consumes ({MediaType.APPLICATION_JSON + ";charset=utf-8"}) 
		public Response tankAdd(warehouseModel model ) {
			
			wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO("liquid_tanks");
			boolean status = dao.add(model);
			if(status == false){
				
				allTransactionsModel allTrModel = new allTransactionsModel();
				
				allTrModel.setProductGroup("liquid_tanks");
				allTrModel.setProductName(model.getName());
				allTrModel.setTransaction("created " + model.getName());
				allTrModel.setDate(new Date().toString());
				
				allTransactionDao(allTrModel);
		
				return Response.status(201).build();
			}
			else
				return Response.status(204).build();
			} 
		
		
		//http://localhost:8080/wareHouseWeb/rest/android/liquid_tanks
		@PUT
		@Path("/liquid_tanks")
		@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
		@Consumes ({MediaType.APPLICATION_JSON + ";charset=utf-8"}) 
		public warehouseModel tankUpdate(warehouseModel model) {
			
			
			wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO("liquid_tanks");
			boolean updateStatus = dao.updateProdcut(model.getId(), model.getAmount());
			
			if(updateStatus == true){
				
				allTransactionsModel allTrModel = new allTransactionsModel();
				
				allTrModel.setProductGroup("liquid_tanks");
				allTrModel.setProductName(model.getName());
				allTrModel.setTransaction("updated amount = " + model.getAmount());
				allTrModel.setDate(new Date().toString());
				
				allTransactionDao(allTrModel);
				
				
				return model;}
			else
				return null;
		}  	
		
		//http://localhost:8080/wareHouseWeb/rest/android/liquid_tanks
		@DELETE
		@Path("/liquid_tanks")
		@Consumes ({MediaType.APPLICATION_JSON + ";charset=utf-8"}) 
		public Response tankDelete(warehouseModel model) {
			
			wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO("liquid_tanks");
			boolean deleteStatus = dao.deleteProduct(model.getId());
			
			if(deleteStatus == false){
				
			allTransactionsModel allTrModel = new allTransactionsModel();
			
			allTrModel.setProductGroup("liquid_tanks");
			allTrModel.setProductName(model.getName());
			allTrModel.setTransaction("deleted " + model.getName());
			allTrModel.setDate(new Date().toString());
			
			allTransactionDao(allTrModel);
			
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
