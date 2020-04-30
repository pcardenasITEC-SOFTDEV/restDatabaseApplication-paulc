package com.example.restdatabaseapplication;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class VehicleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Vehicle vehicle){
        entityManager.persist(vehicle);
        return;
    }

    public Vehicle getById(int id){
        return entityManager.find(Vehicle.class, id);
    }

    public void update(Vehicle vehicle){
        entityManager.merge(vehicle);
        return;
    }

    public void delete(Vehicle vehicle){
        entityManager.remove(vehicle);
        return;
    }


}
