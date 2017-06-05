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
	/*
	@RequestMapping(value = "/createinventory/", method = RequestMethod.POST)
	public void create(@RequestBody com.coviam.inventory.inventory.entity.Inventory item){
		inventory.insertInventory(item);		
	}
	*/
	
	//list of merchants selling particular product.
	@RequestMapping(value = "/getmerchants/{key}", method = RequestMethod.GET)
	public List<Inventory> getMerchants(@PathVariable("key") int key){
		return inventory.getMerchants(key);
	}
	//list of products sold by particular merchants
	@RequestMapping(value = "/getproducts/{key}", method = RequestMethod.GET)
	public List<Inventory> getProducts(@PathVariable("key") int key){
		return inventory.getProducts(key);		
	}
	
	@RequestMapping(value = "/getprice/{prod_id}/{merc_id}", method = RequestMethod.GET)
	public int getPrice(@PathVariable("prod_id") int prod_id,@PathVariable("merc_id") int merc_id){
		return inventory.getPrice(prod_id, merc_id);		
	}
	@RequestMapping(value = "/getstock/{prod_id}/{merc_id}", method = RequestMethod.GET)
	public int getStock(@PathVariable("prod_id") int prod_id,@PathVariable("merc_id") int merc_id){
		return inventory.getStock(prod_id, merc_id);		
	}
}
