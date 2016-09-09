package com.example.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by ayesh on 9/9/16.
 */
public interface UserDataRepository  extends CrudRepository<UserData, String>{
    UserData save(UserData ud);
    UserData findOne(String astring);
    void delete(String astring);
}
