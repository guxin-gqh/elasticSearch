package com.example.lowdemo.service;

/**
 * @author qihong_gu
 * @Title: service
 * @Package
 * @Description:
 * @date 2022/5/2610:47
 */
public interface MeetElasticSearchService {
    public  void initES();
    public void closeEs();
    public String executeRequest();
}
