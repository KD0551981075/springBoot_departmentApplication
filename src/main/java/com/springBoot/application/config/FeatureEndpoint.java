package com.springBoot.application.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@Endpoint(id = "features")
public class FeatureEndpoint {

    public Map<String, feature> featureMap = new ConcurrentHashMap<String, feature>();

    public FeatureEndpoint() {
        featureMap.put("organization name", new feature(true));
        featureMap.put("department name", new feature(false));
        featureMap.put("department code", new feature(false));
    }

    @ReadOperation
    public Map<String, feature> getFeatures()
    {
        return featureMap;
    }

     @Data
     @AllArgsConstructor
     private static class feature
     {

         public boolean active;

     }


 }
