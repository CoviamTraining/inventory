package com.coviam.inventory.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column(name = "merchant_id")
	private int merchantId;
	@Column(name = "price")
	private int price;
	@Column(name = "stock")
	private int stock;
	
	
	@Override
	public String toString() {
		return "Inventory [product_id=" + productId + ", merchant_id=" + merchantId + ", price=" + price + ", stock="
				+ stock + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int product_id) {
		this.productId = product_id;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchant_id) {
		this.merchantId = merchant_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
