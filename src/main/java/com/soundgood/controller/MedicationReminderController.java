package com.soundgood.controller;

import com.soundgood.model.MedicationReminder;
import com.soundgood.service.MedicationReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medication-reminders")
public class MedicationReminderController {

    @Autowired
    private MedicationReminderService medicationReminderService;

    @GetMapping
    public ResponseEntity<List<MedicationReminder>> getAllMedicationReminders() {
        List<MedicationReminder> reminders = medicationReminderService.getAllMedicationReminders();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationReminder> getMedicationReminderById(@PathVariable Long id) {
        MedicationReminder reminder = medicationReminderService.getMedicationReminderById(id);
        return ResponseEntity.ok(reminder);
    }

    @PostMapping
    public ResponseEntity<MedicationReminder> createMedicationReminder(@RequestBody MedicationReminder reminder) {
        MedicationReminder createdReminder = medicationReminderService.createMedicationReminder(reminder);
        return new ResponseEntity<>(createdReminder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationReminder> updateMedicationReminder(@PathVariable Long id, @RequestBody MedicationReminder reminder) {
        MedicationReminder updatedReminder = medicationReminderService.updateMedicationReminder(id, reminder);
        return ResponseEntity.ok(updatedReminder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicationReminder(@PathVariable Long id) {
        medicationReminderService.deleteMedicationReminder(id);
        return ResponseEntity.noContent().build();
    }
}

