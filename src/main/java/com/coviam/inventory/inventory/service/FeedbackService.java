package com.coviam.inventory.inventory.service;

import java.util.List;

import com.coviam.inventory.inventory.entity.Feedback;

public interface FeedbackService {
	List<Feedback> getFeedbackByProductId(int prodId);
	List<Feedback> getFeedbackByMerchantId(int mercId);
	void saveFeedback(Feedback feedback);
	double getAvgRating(int merchantId);

}
