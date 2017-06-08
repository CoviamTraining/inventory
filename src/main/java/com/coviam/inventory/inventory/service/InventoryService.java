package com.coviam.inventory.inventory.service;


import java.util.List;

import com.coviam.inventory.inventory.entity.Inventory;

public interface InventoryService {
	List<Inventory> getMerchants( int product_id);
	List<Inventory> getProducts(int merchant_id);
	int getPrice(int product_id,int merchant_id);
	int getStock(int productId, int merchantId);
	int getStockAfterUpdateStock(int product_id,int merchant_id,int quantity);
	String validateOrder(int productId, int merchantId, int quantity);
	public String rollbackUpdatedStockAndSoldUpdate(int product_id, int merchant_id,int quantity);
    int rollBackStockUpdate(int productId, int merchantId, int quantity);

    }
