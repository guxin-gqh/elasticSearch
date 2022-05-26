package com.example.lowdemo.service.Impl;

import com.example.lowdemo.service.MeetElasticSearchService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author qihong_gu
 * @Title: serviceimpl
 * @Package
 * @Description:
 * @date 2022/5/2610:48
 */
@Service
public class ServiceImpl implements MeetElasticSearchService {
    private static Log log= LogFactory.getLog(MeetElasticSearchService.class);
    private RestClient restClient;
    @Override
    public void initES() {
        RestClient.builder(new HttpHost("localhost",9200,"http"),new HttpHost("localhost",9201,"http")).build();
        log.info("ElasticSearch init in service");
    }

    @Override
    public void closeEs() {
        try {
            restClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String executeRequest() {
        Request request = new Request("GET", "/");
        try {
            Response response = restClient.performRequest(request);
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            restClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Get Result Failed";
    }
}
