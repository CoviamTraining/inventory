package com.coviam.inventory.inventory.service;

import java.util.List;

import com.coviam.inventory.inventory.entity.Feedback;
import com.coviam.inventory.inventory.dto.ProductRatingReview;

public interface FeedbackService {
	List<Feedback> getFeedbackByProductIdAndMerchantId(int prodId, int merchantId);
	List<Feedback> getFeedbackByMerchantId(int mercId);
	void saveFeedback(Feedback feedback);
	double getAvgRating(int merchantId, int productId);
    List<ProductRatingReview> getRatingAndReviewsBymerchantIdAndproductId(int merchantId, int productId);
}
