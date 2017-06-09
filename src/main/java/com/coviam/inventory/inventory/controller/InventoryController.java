package com.coviam.inventory.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coviam.inventory.inventory.entity.Inventory;
import com.coviam.inventory.inventory.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	InventoryService inventory;

	@RequestMapping(value = "/getmerchants/{productId}", method = RequestMethod.GET)
	public List<Inventory> getMerchants(@PathVariable("productId") int productId){
		return inventory.getMerchants(productId);
	}

	@RequestMapping(value = "/getproducts/{merchantId}", method = RequestMethod.GET)
	public List<Inventory> getProducts(@PathVariable("merchantId") int merchantId){
		return inventory.getProducts(merchantId);
	}
	
	@RequestMapping(value = "/getprice/{prod_id}/{merc_id}", method = RequestMethod.GET)
	public int getPrice(@PathVariable("prod_id") int prod_id,@PathVariable("merc_id") int merc_id){
		return inventory.getPrice(prod_id, merc_id);		
	}
	@RequestMapping(value = "/getstock/{prod_id}/{merc_id}", method = RequestMethod.GET)

	public int getStock(@PathVariable("prod_id") int prod_id,@PathVariable("merc_id") int merc_id){
		return inventory.getStock(prod_id, merc_id);
	}

	@RequestMapping(value = "/validateOrder/{productId}/{merchantId}/{quantity}")
	public String getStockAndUpdateStock(@PathVariable int productId, @PathVariable int merchantId,
										 @PathVariable int quantity){
		return inventory.validateOrder(productId,merchantId,quantity);
	}

	@RequestMapping(value = "/rollbackUpdatedStockAndSoldUpdate/{productId}/{merchantId}/{quantity}")
	public String rollbackUpdatedStockAndSoldUpdate(@PathVariable int productId, @PathVariable int merchantId,
													@PathVariable int quantity){
		return inventory.rollbackUpdatedStockAndSoldUpdate(productId,merchantId,quantity);
	}
}
