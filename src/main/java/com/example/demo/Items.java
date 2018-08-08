package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ITEMS")
public class Items {
	
	@Id
	int id;
	
	@Column(name="NAME",nullable=false)
	String name;
	
	@Column(name="AMOUNT")
	int amount;
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Column(name="INV_CODE")
	String inventoryCode;
	public Items() {
		super();
	}
	public Items(int id, String name, int amount, String inventoryCode) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAmount() {
		return amount;
	}
	public String getInventoryCode() {
		return inventoryCode;
	}
	@Override
	public String toString() {
		return "items [id=" + id + ", name=" + name + ", amount=" + amount + ", inventoryCode=" + inventoryCode + "]";
	}
	
}
