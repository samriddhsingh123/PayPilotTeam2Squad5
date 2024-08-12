package controller;

// Importing required service and model classes
import service.ReminderService;
import model.ReminderSettings;
import java.util.Date;

/**
 * ReminderController class is responsible for handling requests related to setting, updating,
 * and deleting reminders. It interacts with the ReminderService to perform these operations.
 * 
 * @author [Srinidhi]
 * @date [11-08-2024]
 */
public class ReminderController {

    // Instance of ReminderService to manage reminder operations
    private ReminderService reminderService = new ReminderService();

    /**
     * Handles the request for setting a new reminder.
     * 
     * @param reminderId          the unique identifier for the reminder
     * @param reminderFrequency   the frequency of the reminder (e.g., daily, weekly)
     * @param reminderStartDate   the start date of the reminder
     * @param customMessage       a custom message to be included with the reminder
     * @param notificationPref    the preferred method of notification (e.g., email, SMS)
     */
    public void setReminder(int reminderId, String reminderFrequency, Date reminderStartDate, 
                            String customMessage, String notificationPref) {
        
        // Create and configure a new ReminderSettings object
        ReminderSettings reminderSettings = new ReminderSettings();
        reminderSettings.setReminderId(reminderId);
        reminderSettings.setReminderFrequency(reminderFrequency);
        reminderSettings.setReminderStartDate(reminderStartDate);
        reminderSettings.setCustomMessage(customMessage);
        reminderSettings.setNotificationPref(notificationPref);

        // Delegate to the service to set the reminder
        reminderService.setReminder(reminderSettings);
    }

    /**
     * Handles the request for updating an existing reminder.
     * 
     * @param reminderId          the unique identifier for the reminder to be updated
     * @param reminderFrequency   the updated frequency of the reminder
     * @param reminderStartDate   the updated start date of the reminder
     * @param customMessage       the updated custom message
     * @param notificationPref    the updated preferred method of notification
     */
    public void updateReminder(int reminderId, String reminderFrequency, Date reminderStartDate, 
                               String customMessage, String notificationPref) {
        
        // Create and configure a new ReminderSettings object with updated details
        ReminderSettings reminderSettings = new ReminderSettings();
        reminderSettings.setReminderId(reminderId);
        reminderSettings.setReminderFrequency(reminderFrequency);
        reminderSettings.setReminderStartDate(reminderStartDate);
        reminderSettings.setCustomMessage(customMessage);
        reminderSettings.setNotificationPref(notificationPref);

        // Delegate to the service to update the reminder
        reminderService.updateReminder(reminderSettings);
    }

    /**
     * Handles the request for deleting an existing reminder.
     * 
     * @param reminderId  the unique identifier for the reminder to be deleted
     */
    public void deleteReminder(int reminderId) {
        // Delegate to the service to delete the reminder
        reminderService.deleteReminder(reminderId);
    }

}
