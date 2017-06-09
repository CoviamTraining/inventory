package com.coviam.inventory.inventory.dao;
import java.util.List;
import java.util.spi.LocaleServiceProvider;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.coviam.inventory.inventory.entity.Inventory;

@Repository
public interface InventoryDAO extends CrudRepository<Inventory, Integer> {
	public List<Inventory> findByMerchantId(int merchantId);
	public List<Inventory> findByProductId(int productId);

	@Query("select i from  Inventory  i where i.productId = :productId and i.merchantId = :merchantId")
	public Inventory findByProductIdAndMerchantId(@Param("productId") int productId,@Param("merchantId") int merchantId);
	
}
