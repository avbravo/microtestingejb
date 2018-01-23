/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.repository;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.avbravo.ejbjmoordb.mongodb.repository.Repository;
import com.avbravo.microtestingejb.entity.Bodega;
import com.avbravo.microtestingejb.provider.MongoClientProvider;
import com.mongodb.MongoClient;

/**
 *
 * @author avbravo
 */
@Stateless
public class BodegaRepository extends Repository<Bodega> {

    @EJB
    MongoClientProvider mongoClientProvider;
    @Override
    protected MongoClient getMongoClient() {
       return mongoClientProvider.getMongoClient();
    }
    public BodegaRepository(){
        super(Bodega.class,"microtesting","bodega");
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
