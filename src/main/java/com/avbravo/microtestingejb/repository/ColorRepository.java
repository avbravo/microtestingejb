/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtestingejb.repository;

import com.avbravo.ejbjmoordb.mongodb.repository.Repository;
import com.avbravo.microtestingejb.entity.Color;
import com.avbravo.microtestingejb.provider.MongoClientProvider;
import com.mongodb.MongoClient;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author avbravo
 */
@Stateless
public class ColorRepository extends Repository<Color> {
    @EJB
    MongoClientProvider mongoClientProvider;

    public ColorRepository() {
        super(Color.class, "microtesting", "color");
    }

    @Override
    protected MongoClient getMongoClient() {
        return mongoClientProvider.getMongoClient();
    }

    @Override
    public Object findById(String key, String value) {
       return search(key,value); 
    }
    @Override
    public Object findById(String key, Integer value) {
        return search(key,value);
    }
}
