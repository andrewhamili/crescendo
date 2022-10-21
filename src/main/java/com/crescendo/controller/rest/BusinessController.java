package com.crescendo.controller.rest;

import com.crescendo.entity.Business;
import com.crescendo.service.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BusinessController {

    @Autowired
    private BusinessServiceImpl businessService;

    @GetMapping("/businesses")
    public ResponseEntity<List<Business>> getAll(){
        return new ResponseEntity<>(businessService.list(), HttpStatus.OK);
    }

    @GetMapping("/businesses/{id}")
    public ResponseEntity<Business> getById(@PathVariable(name = "id") Long id){
        Business business = businessService.byId(id);
        if(business==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(business, HttpStatus.OK);
    }
    @PostMapping("/businesses/")
    public ResponseEntity<Business> create(@RequestBody Business param){
        return new ResponseEntity<>(businessService.create(param), HttpStatus.OK);
    }
    @PutMapping("/businesses/{id}")
    public ResponseEntity<Business> update(@PathVariable(name = "id") Long id, @RequestBody Business param){
        Business business = businessService.byId(id);
        if(business==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else{
            business.setBusinessName(param.getBusinessName());
            business.setAddress(param.getAddress());
            business.setPhone(param.getPhone());


        }
        return new ResponseEntity<>(businessService.update(business), HttpStatus.OK);
    }
    @DeleteMapping("/businesses/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        Business business = businessService.byId(id);
        if(business==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else{
            businessService.delete(business.getId());
        }
        return new ResponseEntity<>(httpStatus.getReasonPhrase(), httpStatus);
    }



}
