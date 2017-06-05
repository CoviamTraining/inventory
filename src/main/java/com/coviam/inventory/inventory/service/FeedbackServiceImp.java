package com.coviam.inventory.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.inventory.inventory.dao.FeedbackDAO;
import com.coviam.inventory.inventory.entity.Feedback;

@Component
public class FeedbackServiceImp implements FeedbackService{
	@Autowired
	FeedbackDAO feedback;
	@Override
	public List<Feedback> getFeedbackByProductId(int prodId) {
		return feedback.findByProductId(prodId);
	}

	@Override
	public List<Feedback> getFeedbackByMerchantId(int mercId) {
		return feedback.findByMerchantId(mercId);
	}

	@Override
	public void saveFeedback(Feedback feedBack) {
		feedback.save(feedBack);
	}

}