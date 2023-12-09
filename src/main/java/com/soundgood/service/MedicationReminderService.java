package com.soundgood.service;

import com.soundgood.model.MedicationReminder;

import java.util.List;

public interface MedicationReminderService {

    List<MedicationReminder> getAllMedicationReminders();
    MedicationReminder getMedicationReminderById(Long id);
    MedicationReminder createMedicationReminder(MedicationReminder reminder);
    MedicationReminder updateMedicationReminder(Long id, MedicationReminder reminder);
    void deleteMedicationReminder(Long id);
}
