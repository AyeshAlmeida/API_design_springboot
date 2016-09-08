package com.example.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
/**
 * Created by ayesh on 9/8/16.
 */
public interface TripDataRepository extends CrudRepository<TripData, Long> {
    TripData save(TripData td);

    TripData findOne(Long aLong);

    void delete(Long aLong);

    @Query("select p  from TripData p where p.s_location = :start")
    List<TripData> findByStart(@Param("start") String start);

    @Query("select p from TripData p where p.e_location = :ends")
    List<TripData> findByEnd(@Param("ends") String ends);

    @Query("select p from TripData p where p.t_class= :t_class")
    List<TripData> findByClass(@Param("t_class") int t_class);

    @Query("select p from TripData p where p.t_date = :date")
    List<TripData> findByDate(@Param("date") Date date);

    @Query("select p from TripData p where p.t_date = :date and p.t_class = :t_class and p.s_location = :start and p.e_location = :ends")
    List<TripData> findByQuery(@Param("date") Date date,@Param("t_class") int t_class,@Param("start") String start,@Param("ends") String ends);

}
