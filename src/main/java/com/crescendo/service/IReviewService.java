package com.crescendo.service;

import com.crescendo.entity.Review;

import java.util.List;

public interface IReviewService {

    List<Review> getByBusiness(Long business_id);
    Review create(Review review);
    void deleteByBusiness(Long business_id);
	
}
