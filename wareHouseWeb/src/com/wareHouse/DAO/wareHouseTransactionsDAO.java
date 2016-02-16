package com.wareHouse.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.wareHouse.Models.warehouseModel;


public class wareHouseTransactionsDAO {
	
	String dbName=null;
	Connection con = null;
	
	public wareHouseTransactionsDAO(String dbName) {
		this.dbName=dbName;
	}
	
	public Connection connectionDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehousedb", "root", "root");
			
			if (!con.isClosed()) {
				System.out.println("successfully");
			}else{
				System.out.println("unsuccessfully");
			}
			
			
		} catch (Exception e) {
			System.out.println("error: "+e);
		}
		
		return con;
	}
	
	public ArrayList<warehouseModel> read() {
		connectionDB();
		
		ArrayList<warehouseModel> modelList = new  ArrayList<warehouseModel>();
		warehouseModel model = null;
		
		try {
			PreparedStatement  preparedStatement = con.prepareStatement("SELECT * FROM "+dbName);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){

				model = new warehouseModel(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3));
				modelList.add(model);
			}
			
			
		} catch (Exception e) {
		System.out.println("ERROR: "+e);
		}
	
		return modelList;
	}

	
	public boolean add(warehouseModel model) {
		connectionDB();
		
		boolean createSuccessful = false;
		String msg = "";		
		try {
			
			String query = "INSERT INTO "+dbName+" (name, amount) VALUES (?, ?)";

			PreparedStatement  preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, model.getName());
			preparedStatement.setInt(2, model.getAmount());
			
			createSuccessful = preparedStatement.execute();
			
			if(createSuccessful == false)
				msg = "successfully";
			else
				msg = "unsuccessfully";


		} catch (Exception e) {
		System.out.println("ERROR: "+e);
		}	
		
		return createSuccessful;

	}
	
	public boolean updateProdcut(int id,int amount) {
		connectionDB();
		
		boolean queryRes = false;
		String msg = "";		
				try {
					
				
				String query =	"UPDATE "+dbName
						+ " SET amount = ? "
							+ " WHERE id = ?";

					
					PreparedStatement  preparedStatement = con.prepareStatement(query);
					preparedStatement.setInt(1, amount);
					preparedStatement.setInt(2, id);
					
					int sorguSonucu = preparedStatement.executeUpdate();
					
					if(sorguSonucu == 1){
						msg = "update successfully";
						queryRes = true;
						}else{
						msg = "update unsuccessfully";
						queryRes = false;}


				} catch (Exception e) {
				System.out.println("HATA: "+e);
				}	
				
				
			
				return queryRes;	
			}

	public boolean deleteProduct(int id) {
		connectionDB();
		
		boolean status = false;
		String result = "";	
		
		try {
			
			String query = "DELETE FROM "+dbName+"  WHERE id=?";
			
			PreparedStatement  preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);

			status = preparedStatement.execute();
			
			if(status == false)
				result = "DELETE successfully";
			else
				result = "DELETE unsuccessfully";

		} catch (Exception e) {
		System.out.println("ERROR: "+e);
		}	
		
		return status;
		
		
	}
	
	public String getName(int id){
		String name="";
		connectionDB();
		
		
		try {
			
			String query = "SELECT * FROM "+dbName+" WHERE id=?";
			
			
			PreparedStatement  preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				name=resultSet.getString(2);
			}

		} catch (Exception e) {
		System.out.println("ERROR: "+e);
		}	
		
		return name;
	}
	
}
