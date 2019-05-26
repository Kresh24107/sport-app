package com.sport.app.repository;

import com.sport.app.repository.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> getEventsByApplicationUserId(int id);

//    List<Event> findByTimeIsContaining(Date date);

//    List<Event> findAllByTime(Date time);

    @Query("select e from Event e where e.time <= :time")
    List<Event> findAllWithCreationDateTimeBefore(@Param("time") Date time);

}

