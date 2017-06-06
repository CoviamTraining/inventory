package com.coviam.inventory.inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coviam.inventory.inventory.entity.Feedback;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FeedbackDAO  extends CrudRepository<Feedback, Integer>{
	public List<Feedback> findByProductId(int productId);
	public List<Feedback> findByMerchantId(int merchantId);

	@Query("select f.rating from Feedback f where f.merchantId = :merchantId ")
    public List<Integer> getRatingBymerchantId(@Param("merchantId") int merchantId);

}
