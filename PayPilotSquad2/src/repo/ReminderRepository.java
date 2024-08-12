package repo;

import model.ReminderSettings;
import java.util.HashMap;
import java.util.Map;

/**
 * The ReminderRepository class is responsible for storing, retrieving, and
 * managing reminder settings in a simulated storage.
 * 
 * @author [Srinidhi]
 * @date [11-08-2024]
 */
public class ReminderRepository {

    // Simulated storage for reminders (in a real application, this would be a database)
    private Map<Integer, ReminderSettings> reminderStore = new HashMap<>();

    /**
     * Saves or updates a reminder in the store.
     * 
     * @param reminderSettings The ReminderSettings object to be saved or updated.
     */
    public void save(ReminderSettings reminderSettings) {
        reminderStore.put(reminderSettings.getReminderId(), reminderSettings);
        System.out.println("Reminder saved/updated: " + reminderSettings);
    }

    /**
     * Finds a reminder by its ID.
     * 
     * @param reminderId The ID of the reminder to find.
     * @return The ReminderSettings object associated with the ID, or null if not found.
     */
    public ReminderSettings findById(int reminderId) {
        return reminderStore.get(reminderId);
    }

    /**
     * Deletes a reminder by its ID.
     * 
     * @param reminderId The ID of the reminder to delete.
     */
    public void deleteById(int reminderId) {
        if (reminderStore.containsKey(reminderId)) {
            reminderStore.remove(reminderId);
            System.out.println("Reminder deleted successfully: ID " + reminderId);
        } else {
            System.out.println("Reminder with ID " + reminderId + " not found.");
        }
    }

    /**
     * Retrieves all reminders from the store.
     * 
     * @return A Map containing all reminders, where the key is the reminder ID and the value is the ReminderSettings object.
     */
    public Map<Integer, ReminderSettings> findAll() {
        return reminderStore;
    }
}
