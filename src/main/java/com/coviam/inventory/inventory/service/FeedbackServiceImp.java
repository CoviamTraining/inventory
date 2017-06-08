package com.coviam.inventory.inventory.service;

import java.util.List;

import com.coviam.inventory.inventory.entity.ProductRatingReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.inventory.inventory.dao.FeedbackDAO;
import com.coviam.inventory.inventory.entity.Feedback;

@Component
public class FeedbackServiceImp implements FeedbackService{
	@Autowired
	FeedbackDAO feedback;
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
        System.out.println("sum is ========= " +sum + "list size is +============+ " +allRating.size());
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


}
