package com.coviam.inventory.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coviam.inventory.inventory.entity.Feedback;
import com.coviam.inventory.inventory.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedback;
	@RequestMapping(value = "/getproductfeedback/{key}", method = RequestMethod.GET)
	public List<Feedback> getProductFeedback(@PathVariable("key") int key){
		return feedback.getFeedbackByProductId(key);
	}
	@RequestMapping(value = "/getmerchantfeedback/{key}", method = RequestMethod.GET)
	public List<Feedback> getMerchantFeedback(@PathVariable("key") int key){
		return feedback.getFeedbackByMerchantId(key);
	}
	@RequestMapping(value = "/savefeedback/{prod_id}/{merc_id}/{email}/{rating}/{review}", method = RequestMethod.GET)
	public String saveFeedback(@PathVariable("prod_id") int prod_id,@PathVariable("merc_id") int merc_id,@PathVariable("email") String email,@PathVariable("rating") int rating,@PathVariable("review") String review){
		Feedback newObj= new Feedback();
		newObj.setProductId(prod_id);
		newObj.setMerchantId(merc_id);
		newObj.setCustEmail(email);
		newObj.setRating(rating);
		newObj.setReview(review);
		feedback.saveFeedback(newObj);
		
		return newObj.toString();
	}
	

}