package com.coviam.inventory.inventory.service;


import java.util.List;

import com.coviam.inventory.inventory.entity.Inventory;

public interface InventoryService {
	List<Inventory> getMerchants( int product_id);
	List<Inventory> getProducts(int merchant_id);
	int getPrice(int product_id,int merchant_id);
	int getStock(int product_id,int merchant_id);
}
