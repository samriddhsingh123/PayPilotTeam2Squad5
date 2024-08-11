package model;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
public class ReminderSettings {
    private int reminderId;
    private String reminderFrequency;
    private Date reminderStartDate;
    private String customMessage;
    private String notificationPref;

    // Simulated storage for reminders (in a real application, this would be a database)
    // private static Map<Integer, ReminderSettings> reminderStore = new HashMap<>();

    // Getter and Setter methods

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public String getReminderFrequency() {
        return reminderFrequency;
    }

    public void setReminderFrequency(String reminderFrequency) {
        this.reminderFrequency = reminderFrequency;
    }

    public Date getReminderStartDate() {
        return reminderStartDate;
    }

    public void setReminderStartDate(Date reminderStartDate) {
        this.reminderStartDate = reminderStartDate;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getNotificationPref() {
        return notificationPref;
    }

    public void setNotificationPref(String notificationPref) {
        this.notificationPref = notificationPref;
    }

    // Methods for managing reminders

//    public void setReminder() {
//        // Store the reminder in the simulated storage
//        reminderStore.put(this.reminderId, this);
//        System.out.println("Reminder set successfully: " + this);
//    }
//
//    public void updateReminder() {
//        if (reminderStore.containsKey(this.reminderId)) {
//            reminderStore.put(this.reminderId, this);
//            System.out.println("Reminder updated successfully: " + this);
//        } else {
//            System.out.println("Reminder with ID " + this.reminderId + " not found.");
//        }
//    }
//
//    public void deleteReminder() {
//        if (reminderStore.containsKey(this.reminderId)) {
//            reminderStore.remove(this.reminderId);
//            System.out.println("Reminder deleted successfully: ID " + this.reminderId);
//        } else {
//            System.out.println("Reminder with ID " + this.reminderId + " not found.");
//        }
//    }

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
