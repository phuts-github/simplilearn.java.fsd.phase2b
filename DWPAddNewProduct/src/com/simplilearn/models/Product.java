package com.simplilearn.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pName;
	private String pColour;
	private String pDesc;
	private String pQuantity;
	private String pCostPrice;
	private String pSalePrice;

	public Product () {}
	
	public Product(int id, String pName, String pColour, String pDesc, String pQuantity, String pCostPrice, String pSalePrice) {
		super();
		this.id = id;
		this.pName = pName;
		this.pColour = pColour;
		this.pDesc = pDesc;
		this.pQuantity = pQuantity;
		this.pCostPrice = pCostPrice;
		this.pSalePrice = pSalePrice;

	}	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpColour() {
		return pColour;
	}
	public void setpColour(String pColour) {
		this.pColour = pColour;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public String getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(String pQuantity) {
		this.pQuantity = pQuantity;
	}
	public String getpCostPrice() {
		return pCostPrice;
	}
	public void setpCostPrice(String pCostPrice) {
		this.pCostPrice = pCostPrice;
	}
	public String getpSalePrice() {
		return pSalePrice;
	}
	public void setpSalePrice(String pSalePrice) {
		this.pSalePrice = pSalePrice;
	}






}
