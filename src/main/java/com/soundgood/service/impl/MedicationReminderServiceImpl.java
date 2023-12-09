package com.soundgood.service.impl;

import com.soundgood.model.MedicationReminder;
import com.soundgood.repository.MedicationReminderRepository;
import com.soundgood.service.MedicationReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MedicationReminderServiceImpl implements MedicationReminderService {

    @Autowired
    private MedicationReminderRepository medicationReminderRepository;

    @Override
    public List<MedicationReminder> getAllMedicationReminders() {
        return medicationReminderRepository.findAll();
    }

    @Override
    public MedicationReminder getMedicationReminderById(Long id) {
        return medicationReminderRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public MedicationReminder createMedicationReminder(MedicationReminder reminder) {
        return medicationReminderRepository.save(reminder);
    }

    @Override
    public MedicationReminder updateMedicationReminder(Long id, MedicationReminder reminder) {
        getMedicationReminderById(id);
        reminder.setId(id);
        return medicationReminderRepository.save(reminder);
    }

    @Override
    public void deleteMedicationReminder(Long id) {
        medicationReminderRepository.deleteById(id);
    }
}
