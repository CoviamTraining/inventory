package com.coviam.inventory.inventory.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coviam.inventory.inventory.entity.Feedback;



public interface FeedbackDAO  extends CrudRepository<Feedback, Integer>{
	public List<Feedback> findByProductId(int productId);
	public List<Feedback> findByMerchantId(int merchantId);
}
