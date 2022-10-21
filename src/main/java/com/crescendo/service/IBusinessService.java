package com.crescendo.service;

import com.crescendo.entity.Business;

import java.util.List;

public interface IBusinessService {

    List<Business> list();
    Business byId(Long id);

    Business create(Business business);
    Business update(Business business);
    void delete(Long id);
	
}
