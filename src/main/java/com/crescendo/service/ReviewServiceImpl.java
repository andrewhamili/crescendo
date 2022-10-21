package com.crescendo.service;

import com.crescendo.entity.Business;
import com.crescendo.entity.Review;
import com.crescendo.repository.BusinessRepository;
import com.crescendo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BusinessServiceImpl businessService;

    @Override
    public List<Review> getByBusiness(Long business_id) {
        Business business = businessService.byId(business_id);
        if(business==null){
            return null;
        }else{
            return reviewRepository.getAllByBusinessId(business_id).orElse(null);
        }
    }

    @Override
    public Review create(Review review) {
        Business business = businessService.byId(review.getBusinessId());
        if(business == null){
            return null;
        }else{
            return reviewRepository.save(review);
        }
    }

    @Override
    public void deleteByBusiness(Long business_id) {

    }
}
