package service;
import model.ReminderSettings;
import java.util.Map;

import repo.ReminderRepository;
public class ReminderService {
    
    private ReminderRepository reminderRepository = new ReminderRepository();

    // Method to set a new reminder
    public void setReminder(ReminderSettings reminderSettings) {
        if (reminderRepository.findById(reminderSettings.getReminderId()) != null) {
            System.out.println("Reminder with ID " + reminderSettings.getReminderId() + " already exists.");
        } else {
            reminderRepository.save(reminderSettings);
            System.out.println("Reminder set successfully: " + reminderSettings);
        }
    }

    // Method to update an existing reminder
    public void updateReminder(ReminderSettings reminderSettings) {
        if (reminderRepository.findById(reminderSettings.getReminderId()) != null) {
            reminderRepository.save(reminderSettings);
            System.out.println("Reminder updated successfully: " + reminderSettings);
        } else {
            System.out.println("Reminder with ID " + reminderSettings.getReminderId() + " not found.");
        }
    }

    // Method to delete an existing reminder
    public void deleteReminder(int reminderId) {
        reminderRepository.deleteById(reminderId);
    }
    // Method to find all reminders
    public Map<Integer, ReminderSettings> findAllReminder() {
        return reminderRepository.findAll();
    }
    
}
