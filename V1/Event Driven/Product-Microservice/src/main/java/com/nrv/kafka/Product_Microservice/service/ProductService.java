package com.nrv.kafka.Product_Microservice.service;

import com.nrv.kafka.Product_Microservice.model.CreateProductRestModel;

import java.util.concurrent.ExecutionException;

public interface ProductService {
    String createProduct(CreateProductRestModel productRestModel) throws Exception;
}
