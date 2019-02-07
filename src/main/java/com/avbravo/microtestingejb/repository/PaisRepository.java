/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.repository;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.avbravo.ejbjmoordb.mongodb.repository.Repository;
import com.avbravo.microtestingejb.entity.Pais;
import com.avbravo.microtestingejb.provider.MongoClientProvider;
import com.mongodb.MongoClient;

/**
 *
 * @author avbravo
 */
@Stateless
public class PaisRepository extends Repository<Pais> {

    @EJB
    MongoClientProvider mongoClientProvider;
    @Override
    protected MongoClient getMongoClient() {
       return mongoClientProvider.getMongoClient();
    }
    public PaisRepository(){
        super(Pais.class,"microtesting","pais");
    }
   

}
