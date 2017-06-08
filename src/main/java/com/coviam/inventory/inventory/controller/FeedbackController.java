package com.coviam.inventory.inventory.controller;

import java.io.IOException;
import java.util.List;

import com.coviam.inventory.inventory.entity.ProductRatingReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coviam.inventory.inventory.entity.Feedback;
import com.coviam.inventory.inventory.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedback;
	@RequestMapping(value = "/getproductfeedback/{productId}/{merchantId}", method = RequestMethod.GET)
	public List<Feedback> getProductFeedback(@PathVariable("productId") int productId, @PathVariable("merchantId")
            int merchantId){
		return feedback.getFeedbackByProductIdAndMerchantId(productId,merchantId);
	}

	@RequestMapping(value = "/getmerchantfeedback/{key}", method = RequestMethod.GET)
	public List<Feedback> getMerchantFeedback(@PathVariable("key") int key){
		return feedback.getFeedbackByMerchantId(key);
	}
	 @RequestMapping(value = "/addFeedback", method = RequestMethod.POST)
	        public String add(@RequestBody Feedback feed)
	                        throws IOException {
	                        feedback.saveFeedback(feed);
	                                return "Successfully Added";
	                
	         }

	@RequestMapping(value = "/getAvgRating/{merchantId}/{productId}")
	public double getAvgRating(@PathVariable int merchantId, @PathVariable int productId){
		return feedback.getAvgRating(merchantId,productId);
	}

	@RequestMapping(value = "/getMerchantProductRatingReview/{merchantId}/{productId}")
    public List<ProductRatingReview> getMerchantProductRatingReview(@PathVariable int merchantId, @PathVariable int productId){
	    return feedback.getRatingAndReviewsBymerchantIdAndproductId(merchantId,productId);
    }

}
