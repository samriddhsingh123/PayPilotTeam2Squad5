package controller;
import service.ReminderService;
import model.ReminderSettings;
import java.util.Date;
public class ReminderController {
    
    private ReminderService reminderService = new ReminderService();

    // Method to handle the request for setting a new reminder
    public void setReminder(int reminderId, String reminderFrequency, Date reminderStartDate, 
                            String customMessage, String notificationPref) {
        
        // Create a new ReminderSettings object with the provided details
        ReminderSettings reminderSettings = new ReminderSettings();
        reminderSettings.setReminderId(reminderId);
        reminderSettings.setReminderFrequency(reminderFrequency);
        reminderSettings.setReminderStartDate(reminderStartDate);
        reminderSettings.setCustomMessage(customMessage);
        reminderSettings.setNotificationPref(notificationPref);

        // Call the service to set the reminder
        reminderService.setReminder(reminderSettings);
    }

    // Method to handle the request for updating an existing reminder
    public void updateReminder(int reminderId, String reminderFrequency, Date reminderStartDate, 
                               String customMessage, String notificationPref) {
        
        // Create a new ReminderSettings object with the updated details
        ReminderSettings reminderSettings = new ReminderSettings();
        reminderSettings.setReminderId(reminderId);
        reminderSettings.setReminderFrequency(reminderFrequency);
        reminderSettings.setReminderStartDate(reminderStartDate);
        reminderSettings.setCustomMessage(customMessage);
        reminderSettings.setNotificationPref(notificationPref);

        // Call the service to update the reminder
        reminderService.updateReminder(reminderSettings);
    }

    // Method to handle the request for deleting an existing reminder
    public void deleteReminder(int reminderId) {
        // Call the service to delete the reminder
        reminderService.deleteReminder(reminderId);
    }

 }

