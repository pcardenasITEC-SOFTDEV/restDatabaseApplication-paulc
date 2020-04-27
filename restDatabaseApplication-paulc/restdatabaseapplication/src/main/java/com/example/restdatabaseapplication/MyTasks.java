package com.example.hellorestdatabase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyTasks {

    private RestTemplate restTemplate = new RestTemplate();
    private int id = 1;

    @Scheduled(fixedRate = 1000)
    public void addVehicle() throws IOException {
        String postURL = ("http://localhost:8080/addVehicle");
        int year = RandomUtils.nextInt(1986, 2017);
        double retailPrice = (double) RandomUtils.nextInt(15000, 45001);
        String makeModel = RandomStringUtils.randomAlphabetic(5,10);
        Vehicle autoVehicle = new Vehicle(id++, makeModel, year, retailPrice);
        restTemplate.postForLocation(postURL, autoVehicle);

    }

   @Scheduled(fixedRate = 10000)
    public void deleteVehicle() throws IOException {
        int randomID = RandomUtils.nextInt(11, 19);
        String deleteURL = ("http://localhost:8080/getVehicle/" + randomID);
        restTemplate.delete(deleteURL);
    }

    @Scheduled(fixedRate = 20000)
    public void updateVehicle() throws IOException {
        int randomID = RandomUtils.nextInt(1, 10);
        String updateURL = ("http://localhost:8080/updateVehicle");
        String getURL = ("http://localhost:8080/getVehicle/" + randomID);
        Vehicle v = restTemplate.getForObject(getURL, Vehicle.class);
        int year = RandomUtils.nextInt(2017, 2020);
        double updateRetailPrice = (double) RandomUtils.nextInt(50000, 55000);
        String makeModel = RandomStringUtils.randomAlphabetic(11,15);
        v.setYear(year);
        v.setRetailPrice(updateRetailPrice);
        v.setMakeModel(makeModel);
        restTemplate.put(updateURL, v);

    }

    @Scheduled(fixedRate = 100000)
    public void getLatestRecords() throws IOException {
        String recordsURL = ("http://localhost:8080/getLatestVehicles");
        Vehicle records = restTemplate.getForObject(recordsURL, Vehicle.class);
        System.out.println(records);
    }



}
