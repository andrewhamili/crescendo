package com.crescendo.service;

import com.crescendo.entity.Business;
import com.crescendo.entity.Review;
import com.crescendo.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements IBusinessService{

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private ReviewServiceImpl reviewService;

    @Override
    public List<Business> list() {
        return businessRepository.findAll();
    }

    @Override
    public Business byId(Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    @Override
    public Business create(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public Business update(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public void delete(Long id) {
        //reviewService
        businessRepository.deleteById(id);
    }
}
