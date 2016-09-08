package com.example.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * Created by ayesh on 9/8/16.
 */
public interface TripDataRepository extends CrudRepository<TripData, Long> {
    TripData save(TripData petData);

    TripData findOne(Long aLong);

    void delete(Long aLong);
}
