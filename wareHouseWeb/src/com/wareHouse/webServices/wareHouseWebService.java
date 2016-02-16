package com.wareHouse.webServices;

import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wareHouse.DAO.allTransactionsDAO;
import com.wareHouse.DAO.wareHouseTransactionsDAO;
import com.wareHouse.Models.allTransactionsModel;
import com.wareHouse.Models.warehouseModel;

@Path("/wareHouseWebService")
public class wareHouseWebService {
	
	@POST
	@Path("/formController")
	public Response formController(@QueryParam("dbName") String dbName,@QueryParam("name") String name,@QueryParam("amount") String amount){
		
		allTransactionsDAO trDao = new allTransactionsDAO();
		wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO(dbName);
		
		
		if(name==null || name.isEmpty()){
			return Response.ok().entity("empty Name").build();	

		}
		
		if(amount==null || amount.isEmpty()){
			return Response.ok().entity("empty amount").build();	

		}
		
		warehouseModel model = new warehouseModel(name, Integer.parseInt(amount));
		dao.add(model);
		trDao.add(new allTransactionsModel(dbName, name, "Create Product amount = "+amount, new Date().toString()));

		return Response.ok().entity(name + " " + amount + " add successfully").build();	
		
	}

	@GET
	@Path("/allProductsSilos")
//	@Produces ("application/xml,  application/json ; charset=utf-8")
	@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public List<warehouseModel> readProducts() {

		wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO("silos");
		return dao.read();
	}  
	
	
	@GET
	@Path("/allProductsLiquidTanks")
//	@Produces ("application/xml,  application/json ; charset=utf-8")
	@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public List<warehouseModel> readTanks() {

		wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO("liquid_tanks");
		return dao.read();
	}  
	
	@POST
	@Path("/delete")
	public Response deleteService(@QueryParam ("dbName") String dbName,@QueryParam ("id") int id ) {
		
		wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO(dbName);

		allTransactionsDAO trDao = new allTransactionsDAO();
		allTransactionsModel model = new allTransactionsModel();
		model.setProductGroup(dbName);
		model.setProductName(dao.getName(id));
		model.setTransaction("deleted product");
		model.setDate(new Date().toString());
		trDao.add(model);
		
		
		boolean silmeDurumu = dao.deleteProduct(id);
		
		if(silmeDurumu == false)
			return Response.ok().entity("DELETE successfully").build();	
		else
			return Response.ok().entity("DELETE unsuccessfully").build();	

	}  	
	
	@POST
	@Path("/updateProduct")
	public Response updateService(@QueryParam ("dbName") String dbName,@QueryParam ("id") int id ,@QueryParam ("amount") int amount) {
	
		
		wareHouseTransactionsDAO dao = new wareHouseTransactionsDAO(dbName);
		
		allTransactionsDAO trDao = new allTransactionsDAO();
		allTransactionsModel model = new allTransactionsModel();
		model.setProductGroup(dbName);
		model.setProductName(dao.getName(id));
		model.setTransaction("updated amount = "+amount);
		model.setDate(new Date().toString());
		trDao.add(model);
		
		boolean status = dao.updateProdcut(id, amount);
		
		if(status == true)
			return Response.ok().entity("update successfully").build();	
		else
			return Response.ok().entity("update unsuccessfully").build();
	
	}  	

}
