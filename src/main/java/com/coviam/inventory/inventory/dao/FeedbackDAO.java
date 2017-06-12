package com.coviam.inventory.inventory.dao;

import java.util.List;

import com.coviam.inventory.inventory.dto.ProductRatingReview;
import com.coviam.inventory.inventory.dto.RatingReview;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coviam.inventory.inventory.entity.Feedback;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FeedbackDAO  extends CrudRepository<Feedback, Integer>{
	public List<Feedback> findByProductIdAndMerchantId(int productId, int merchantId);
	public List<Feedback> findByMerchantId(int merchantId);

	@Query("select f.rating from Feedback f where f.merchantId = :merchantId and f.productId = :productId ")
    public List<Integer> getRatingBymerchantIdAAndproductId(@Param("merchantId") int merchantId,
                                                            @Param("productId") int productId);

    @Query("select new com.coviam.inventory.inventory.dto.ProductRatingReview(f.rating, f.review) " +
            " from Feedback f where f.merchantId = :merchantId and f.productId = :productId ")
    public List<ProductRatingReview> getRatingAndReviewsBymerchantIdAndproductId(@Param("merchantId") int merchantId,
                                                                                  @Param("productId") int productId);

    @Query("select new com.coviam.inventory.inventory.dto.RatingReview(f.rating,f.review) from Feedback f where " +
            "f.productId= :productId and f.merchantId = :merchantId and f.custEmail = :custEmail ")
    public RatingReview  getRatingandReviewByProductIdAndMerchantIdAndCustEmail(@Param("productId") int productId,
                                                 @Param("merchantId") int merchantId, @Param("custEmail") String custEmail);
}
