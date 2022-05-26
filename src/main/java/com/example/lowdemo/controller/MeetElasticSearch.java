package com.example.lowdemo.controller;

import com.example.lowdemo.service.MeetElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qihong_gu
 * @Title: meetelasticsearch
 * @Package
 * @Description:
 * @date 2022/5/2610:40
 */
@RestController
public class MeetElasticSearch {
    @Autowired
    MeetElasticSearchService meetElasticSearchService;
   @RequestMapping("/init")
    public String initElasticSearch(){
       meetElasticSearchService.initES();
       return "Init ElasticSearch Over";
   }
   @RequestMapping("/buildRequest")
    public String executeElasticSearcg(){
       return  meetElasticSearchService.executeRequest();
   }
}
