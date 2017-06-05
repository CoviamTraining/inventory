package com.coviam.inventory.inventory.service;

import java.util.List;
//import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.inventory.inventory.dao.InventoryDAO;
import com.coviam.inventory.inventory.entity.Inventory;

@Component
public class InventoryServiceImp implements InventoryService {
	
	@Autowired
	InventoryDAO inventory;
	@Override
	public List<Inventory> getMerchants(int product_id) {
		return inventory.findByProductId(product_id);
	}

	@Override
	public List<Inventory> getProducts(int merchant_id) {
		return inventory.findByMerchantId(merchant_id);
	}

	@Override
	public int getPrice(int product_id, int merchant_id) {
		return inventory.findByProductIdAndMerchantId(product_id, merchant_id).getPrice();
	}

	@Override
	public int getStock(int product_id, int merchant_id) {
		 return inventory.findByProductIdAndMerchantId(product_id, merchant_id).getStock();
	}
	/*
	@Override
	public void insertInventory(Inventory item){
		inventory.save(item);
	}*/
}
