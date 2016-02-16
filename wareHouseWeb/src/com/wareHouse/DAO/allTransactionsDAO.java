package com.wareHouse.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.wareHouse.Models.allTransactionsModel;

public class allTransactionsDAO {
	
	
	Connection con = null;
	

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
	
	
	
	public boolean add(allTransactionsModel model) {
		connectionDB();
		
		boolean createSuccessful = false;
				
		try {
			
			String query = "INSERT INTO transactions (productGroup, productName,transaciton,date) VALUES (?, ?, ?, ?)";

			PreparedStatement  preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, model.getProductGroup());
			preparedStatement.setString(2, model.getProductName());
			preparedStatement.setString(3, model.getTransaction());
			preparedStatement.setString(4, model.getDate());
			
			createSuccessful = preparedStatement.execute();

		} catch (Exception e) {
		System.out.println("ERROR: "+e);
		}	
		return createSuccessful;

	}
	
	
	public ArrayList<allTransactionsModel> read() {
		connectionDB();
		
		ArrayList<allTransactionsModel> modelList = new  ArrayList<allTransactionsModel>();
		allTransactionsModel model = null;
		
		try {
			PreparedStatement  preparedStatement = con.prepareStatement("SELECT * FROM transactions");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){

				model = new allTransactionsModel(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
				modelList.add(model);
			}
			
			
		} catch (Exception e) {
		System.out.println("ERROR: "+e);
		}

		
		return modelList;
	}
	
	public ArrayList<allTransactionsModel> readProdcutName(String productName) {
		connectionDB();
		
		ArrayList<allTransactionsModel> modelList = new  ArrayList<allTransactionsModel>();
		allTransactionsModel model = null;
		
		try {
			
			PreparedStatement  preparedStatement = con.prepareStatement("SELECT * FROM transactions WHERE productName=?");
			preparedStatement.setString(1, productName);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){

				model = new allTransactionsModel(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
				modelList.add(model);
			}
			
			
		} catch (Exception e) {
		System.out.println("ERROR: "+e);
		}

		
		return modelList;
	}
	
	public boolean deleteTransaction(int id) {
		connectionDB();

		boolean status = false;
		String result = "";	
		
		try {
			
			String query = "DELETE FROM transactions WHERE id=?";
			
			PreparedStatement  preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);

			status = preparedStatement.execute();
			
			if(status == false)
				result = "DELETE successfully";
			else
				result = "DELETE unsuccessfully.";
			
			

		} catch (Exception e) {
		System.out.println("ERROR: "+e);
		}		
		return status;	
	}

}
