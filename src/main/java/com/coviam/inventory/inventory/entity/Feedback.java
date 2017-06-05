package com.coviam.inventory.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	@Override
	public String toString() {
		return "Feedback [productId=" + productId + ", merchantId=" + merchantId + ", custEmail=" + custEmail
				+ ", rating=" + rating + ", review=" + review + "]";
	}
	@Column(name = "product_id")
	private int productId;
	@Column(name = "merchant_id")
	private int merchantId;
	@Column(name = "custEmail")
	private String custEmail;
	@Column(name = "rating")
	private int rating;
	@Column(name = "review")
	private String review;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
}
