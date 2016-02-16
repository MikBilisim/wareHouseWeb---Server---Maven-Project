package com.wareHouse.Models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="warehouse")
public class warehouseModel {
	int id;
	String name;
	int amount;
	
	public warehouseModel(){
		
	}
	public warehouseModel(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	public warehouseModel(int id, String name, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@XmlElement
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "warehouseModel [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	

}
