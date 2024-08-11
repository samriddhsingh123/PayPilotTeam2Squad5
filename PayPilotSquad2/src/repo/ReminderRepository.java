package repo;
import model.ReminderSettings;
import java.util.HashMap;
import java.util.Map;

public class ReminderRepository {
    
    // Simulated storage for reminders
    private Map<Integer, ReminderSettings> reminderStore = new HashMap<>();

    // Save or update a reminder in the store
    public void save(ReminderSettings reminderSettings) {
        reminderStore.put(reminderSettings.getReminderId(), reminderSettings);
        System.out.println("Reminder saved/updated: " + reminderSettings);
    }

    // Find a reminder by its ID
    public ReminderSettings findById(int reminderId) {
        return reminderStore.get(reminderId);
    }

    // Delete a reminder by its ID
    public void deleteById(int reminderId) {
        if (reminderStore.containsKey(reminderId)) {
            reminderStore.remove(reminderId);
            System.out.println("Reminder deleted successfully: ID " + reminderId);
        } else {
            System.out.println("Reminder with ID " + reminderId + " not found.");
        }
    }

    // Get all reminders (optional)
    public Map<Integer, ReminderSettings> findAll() {
        return reminderStore;
    }
    
 // Method to get the next available reminder ID
//    public int getNextReminderId(int reminderId) {
//        return reminderId+1;
//    }
}
