package com.example.hellorestdatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleDAO vehicleDAO;
    @RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
    public Vehicle addVehicle(@RequestBody Vehicle newVehicle) throws IOException {
        Vehicle addedVehicle = new Vehicle(newVehicle.getId(), newVehicle.getMakeModel(), newVehicle.getYear(), newVehicle.getRetailPrice());
        vehicleDAO.create(addedVehicle);
        return addedVehicle;
    }

    @RequestMapping(value = "/getVehicle/{id}", method = RequestMethod.GET)
    public Vehicle getVehicle(@PathVariable("id") int id) throws IOException {
        return vehicleDAO.getById(id);
    }

    @RequestMapping(value = "/updateVehicle", method = RequestMethod.PUT)
    public Vehicle updateVehicle(@RequestBody Vehicle newVehicle) throws IOException {
        Vehicle updateVehicle = vehicleDAO.getById(newVehicle.getId());
        vehicleDAO.update(updateVehicle);
        return updateVehicle;
    }

    @RequestMapping(value = "/deleteVehicle/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") int id) throws IOException {
        if(id==0){
            return new ResponseEntity<String>("Sorry vehicle ID not found", HttpStatus.NOT_FOUND);
        } else {
            vehicleDAO.delete(vehicleDAO.getById(id));
            return new ResponseEntity<String>("Vehicle Deleted", HttpStatus.FOUND);
        }
    }

    @RequestMapping(value = "/getLatestVehicles", method = RequestMethod.GET)
    public List<Vehicle> getLatestVehicles() throws IOException{
        List<Vehicle> tenVehiclesList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            tenVehiclesList.add(vehicleDAO.getById(i));
            System.out.println(tenVehiclesList.get(i));
        }
        return tenVehiclesList;
    }





}
