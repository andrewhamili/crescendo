package com.crescendo.controller.rest;

import com.crescendo.entity.Review;
import com.crescendo.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @GetMapping("/businesses/{businessId}/reviews")
	public ResponseEntity<List<Review>> getReviewsByBusiness(@PathVariable(name = "businessId") Long businessId){
        List<Review> reviewList = reviewService.getByBusiness(businessId);
        if(reviewList.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviewList, HttpStatus.OK);
    }
    @PostMapping("/businesses/{businessId}/reviews")
    public ResponseEntity<Review> addReview(@PathVariable(name = "businessId") Long businessId, @RequestBody Review param){
        param.setBusinessId(businessId);
        Review review = reviewService.create(param);
        if(review == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(review, HttpStatus.ACCEPTED);
    }
}
