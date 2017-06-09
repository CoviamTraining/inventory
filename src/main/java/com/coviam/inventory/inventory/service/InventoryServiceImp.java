package com.coviam.inventory.inventory.service;

import java.net.Inet4Address;
import java.util.List;
//import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.coviam.inventory.inventory.dao.InventoryDAO;
import com.coviam.inventory.inventory.entity.Inventory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryServiceImp implements InventoryService {
	
	@Autowired
	InventoryDAO inventory;

	@Value("${merchantUri}")
	String merchantUri;

	private RestTemplate restTemplate = new RestTemplate();

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
		int price = inventory.findByProductIdAndMerchantId(product_id, merchant_id).getPrice();
		return price;
	}

	@Override
	public int getStock(int productId, int merchantId ) {
		return inventory.findByProductIdAndMerchantId(productId,merchantId).getStock();
	}

	@Override
	@Transactional(readOnly = false)
	public int getStockAfterUpdateStock(int product_id, int merchant_id,int quantity) {
		Inventory inventoryObject = inventory.findByProductIdAndMerchantId(product_id, merchant_id);
		int stock = inventoryObject.getStock();
		int remainStock = stock-quantity;
		if (remainStock >=0){
			inventoryObject.setStock(remainStock);
			inventory.save(inventoryObject);
			return remainStock;
		}
		else{
			return remainStock;
		}
	}

	@Override
	public String validateOrder(int productId, int merchantId, int quantity ) {

		int remainStock = getStockAfterUpdateStock(productId,merchantId,quantity);

		if(remainStock<0){
			return "Not Success";
		}else{
			String updateSold = restTemplate.getForObject(merchantUri+"updateSoldDistinctOnOrderPlace/"+productId+"/"
					+merchantId+"/"+quantity+"/"+remainStock,String.class);
			// TODO if transaction abort then ???
			return "success";
		}

	}

	@Override
	public int rollBackStockUpdate(int productId, int merchantId, int quantity){
		Inventory inventoryObject = inventory.findByProductIdAndMerchantId(productId, merchantId);
		int stock = inventoryObject.getStock();
		int remainStock = stock+quantity;
		inventoryObject.setStock(remainStock);
		inventory.save(inventoryObject);
		return remainStock;
	}

	@Override
	public String rollbackUpdatedStockAndSoldUpdate(int productId, int merchantId, int quantity ) {

		int remainStock = rollBackStockUpdate(productId,merchantId,quantity);

		String updateSold = restTemplate.getForObject(merchantUri+"updateSoldDistinctOnOrderPlace/"+productId+"/"
				+merchantId+"/"+quantity+"/"+remainStock,String.class);
		return "Done rollback";
	}


}
