package com.sport.app.repository;

import com.sport.app.repository.entity.ApplicationUser;
import com.sport.app.repository.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
//    @Query("select au.id from ApplicationUser as au")
//    public List<Integer> getLastFour();

//    List<ApplicationUser> findTop4OrderByIdDesc();


}
