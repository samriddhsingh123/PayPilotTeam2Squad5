package model;

import java.util.Date;

/**
 * The ReminderSettings class represents the settings for a reminder,
 * including frequency, start date, custom message, and notification preferences.
 * 
 * @author [Srinidhi]
 * @date [11-08-2024]
 */
public class ReminderSettings {
    
    // Unique identifier for the reminder
    private int reminderId;

    // Frequency of the reminder (e.g., daily, weekly, monthly)
    private String reminderFrequency;

    // Start date for the reminder
    private Date reminderStartDate;

    // Custom message to be displayed with the reminder
    private String customMessage;

    // Notification preference (e.g., email, SMS)
    private String notificationPref;

    // Constructor
    public ReminderSettings() {
        // Default constructor
    }

    // Getter and Setter methods

    /**
     * Gets the unique identifier for the reminder.
     * 
     * @return the reminderId
     */
    public int getReminderId() {
        return reminderId;
    }

    /**
     * Sets the unique identifier for the reminder.
     * 
     * @param reminderId the unique identifier to set
     */
    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    /**
     * Gets the frequency of the reminder.
     * 
     * @return the reminderFrequency
     */
    public String getReminderFrequency() {
        return reminderFrequency;
    }

    /**
     * Sets the frequency of the reminder.
     * 
     * @param reminderFrequency the frequency to set
     */
    public void setReminderFrequency(String reminderFrequency) {
        this.reminderFrequency = reminderFrequency;
    }

    /**
     * Gets the start date of the reminder.
     * 
     * @return the reminderStartDate
     */
    public Date getReminderStartDate() {
        return reminderStartDate;
    }

    /**
     * Sets the start date of the reminder.
     * 
     * @param reminderStartDate the start date to set
     */
    public void setReminderStartDate(Date reminderStartDate) {
        this.reminderStartDate = reminderStartDate;
    }

    /**
     * Gets the custom message for the reminder.
     * 
     * @return the customMessage
     */
    public String getCustomMessage() {
        return customMessage;
    }

    /**
     * Sets the custom message for the reminder.
     * 
     * @param customMessage the custom message to set
     */
    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    /**
     * Gets the notification preference for the reminder.
     * 
     * @return the notificationPref
     */
    public String getNotificationPref() {
        return notificationPref;
    }

    /**
     * Sets the notification preference for the reminder.
     * 
     * @param notificationPref the notification preference to set
     */
    public void setNotificationPref(String notificationPref) {
        this.notificationPref = notificationPref;
    }

    // Override the toString() method to provide a string representation of the object
    @Override
    public String toString() {
        return "ReminderSettings{" +
                "reminderId=" + reminderId +
                ", reminderFrequency='" + reminderFrequency + '\'' +
                ", reminderStartDate=" + reminderStartDate +
                ", customMessage='" + customMessage + '\'' +
                ", notificationPref='" + notificationPref + '\'' +
                '}';
    }
}
