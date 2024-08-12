package service;

import model.ReminderSettings;
import repo.ReminderRepository;

import java.util.Map;

/**
 * ReminderService class handles the operations related to managing reminders,
 * including setting, updating, and deleting reminders.
 * 
 * @author [Srinidhi]
 * @date [11-08-2024]
 */
public class ReminderService {

    // Repository to manage reminder data
    private ReminderRepository reminderRepository = new ReminderRepository();

    /**
     * Sets a new reminder if it doesn't already exist.
     * 
     * @param reminderSettings The settings for the reminder to be set.
     */
    public void setReminder(ReminderSettings reminderSettings) {
        // Validate if the reminder already exists
        if (reminderRepository.findById(reminderSettings.getReminderId()) != null) {
            System.out.println("Reminder with ID " + reminderSettings.getReminderId() + " already exists.");
        } else {
            // Save the new reminder
            reminderRepository.save(reminderSettings);
            System.out.println("Reminder set successfully: " + reminderSettings);
        }
    }

    /**
     * Updates an existing reminder.
     * 
     * @param reminderSettings The settings for the reminder to be updated.
     */
    public void updateReminder(ReminderSettings reminderSettings) {
        // Validate if the reminder exists
        if (reminderRepository.findById(reminderSettings.getReminderId()) != null) {
            // Update the reminder
            reminderRepository.save(reminderSettings);
            System.out.println("Reminder updated successfully: " + reminderSettings);
        } else {
            System.out.println("Reminder with ID " + reminderSettings.getReminderId() + " not found.");
        }
    }

    /**
     * Deletes an existing reminder.
     * 
     * @param reminderId The ID of the reminder to be deleted.
     */
    public void deleteReminder(int reminderId) {
        // Delete the reminder by ID
        reminderRepository.deleteById(reminderId);
        System.out.println("Reminder with ID " + reminderId + " deleted successfully.");
    }

    /**
     * Finds and returns all reminders.
     * 
     * @return A map of reminder IDs to their corresponding ReminderSettings objects.
     */
    public Map<Integer, ReminderSettings> findAllReminder() {
        // Retrieve all reminders
        return reminderRepository.findAll();
    }
}
