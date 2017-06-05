package com.coviam.inventory.inventory.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.coviam.inventory.inventory.entity.Inventory;

@Repository
public interface InventoryDAO extends CrudRepository<Inventory, Integer> {
	public List<Inventory> findByMerchantId(int merchantId);
	public List<Inventory> findByProductId(int productId);
	public Inventory findByProductIdAndMerchantId(int productId,int merchant_id);
	
	
	
	
}
