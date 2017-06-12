package com.coviam.inventory.inventory.service;

import java.util.List;

import com.coviam.inventory.inventory.dto.ProductRatingReview;
import com.coviam.inventory.inventory.dto.RatingReview;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.inventory.inventory.dao.FeedbackDAO;
import com.coviam.inventory.inventory.entity.Feedback;

import javax.validation.constraints.Null;

@Component
public class FeedbackServiceImp implements FeedbackService{
	@Autowired
	FeedbackDAO feedback;

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public List<Feedback> getFeedbackByProductIdAndMerchantId(int prodId,int merchantId) {
		return feedback.findByProductIdAndMerchantId(prodId,merchantId);
	}

	@Override
	public List<Feedback> getFeedbackByMerchantId(int mercId) {
		return feedback.findByMerchantId(mercId);
	}

	@Override
	public void saveFeedback(Feedback feedBack) {
		feedback.save(feedBack);
	}

	@Override
    public double getAvgRating(int merchantId, int productId) {
        List<Integer> allRating = feedback.getRatingBymerchantIdAAndproductId(merchantId,productId);
        double sum = allRating.stream().mapToInt(Integer::intValue).sum();
        double avgrating = 0;
        if(allRating.size()!=0){
            avgrating = (double)sum/allRating.size();
        }
        return avgrating;
    }

    @Override
    public List<ProductRatingReview> getRatingAndReviewsBymerchantIdAndproductId(int merchantId, int productId) {
        return feedback.getRatingAndReviewsBymerchantIdAndproductId(merchantId,productId);
    }

    @Override
    public String getRatingReview(int productId, int merchantId, String custEmail) {
        System.out.println("hhhheree" + productId+"  " +merchantId + " " + custEmail);
        String ratingReview = null;
        try {
             ratingReview = objectMapper.writeValueAsString(
                    feedback.getRatingandReviewByProductIdAndMerchantIdAndCustEmail(productId,merchantId,custEmail));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ratingReview;
    }


}
