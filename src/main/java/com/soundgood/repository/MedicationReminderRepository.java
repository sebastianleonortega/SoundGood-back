package com.soundgood.repository;

import com.soundgood.model.MedicationReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationReminderRepository extends JpaRepository<MedicationReminder, Long>{
}
