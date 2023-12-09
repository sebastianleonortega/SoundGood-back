package com.soundgood.repository;

import com.soundgood.model.Appointment;
import com.soundgood.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    @Query("SELECT COUNT(a) > 0 FROM Appointment a WHERE a.doctor = :doctor AND a.date = :date AND a.time = :time")
    boolean existsByDoctorAndDateAndTime(
            @Param("doctor") Doctor doctor,
            @Param("date") Date date,
            @Param("time") String time
    );
}
