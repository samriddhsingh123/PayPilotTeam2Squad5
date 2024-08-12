package test;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import model.ReminderSettings;
import service.ReminderService;

import static org.junit.Assert.*;

/**
 * The ReminderTest class tests the functionality of the ReminderService class,
 * including setting, updating, and deleting reminders.
 * 
 * Author: [Gaurav Gupta, Sravani]
 * Date: [11-08-2024]
 */
public class ReminderTest {

    // Instance of ReminderService to be tested
    private ReminderService reminderService;

    /**
     * Sets up the test environment by initializing the ReminderService instance.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        reminderService = new ReminderService();
    }

    /**
     * Tests the setReminder method of the ReminderService class.
     * It verifies that reminders are correctly added to the service.
     */
    @Test
    public void testSetReminder() {
        // Setting up the first reminder
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2024, Calendar.DECEMBER, 12);
        Date afterDate1 = calendar1.getTime();

        ReminderSettings reminderSetting1 = new ReminderSettings();
        reminderSetting1.setReminderId(1);
        reminderSetting1.setCustomMessage("Time to Pay the bill");
        reminderSetting1.setNotificationPref("");
        reminderSetting1.setReminderFrequency("Five");
        reminderSetting1.setReminderStartDate(afterDate1);

        // Setting up the second reminder
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2024, Calendar.OCTOBER, 12);
        Date afterDate2 = calendar2.getTime();

        ReminderSettings reminderSetting2 = new ReminderSettings();
        reminderSetting2.setReminderId(2);
        reminderSetting2.setCustomMessage("Time to Pay the bill Soon");
        reminderSetting2.setNotificationPref("");
        reminderSetting2.setReminderFrequency("Ten");
        reminderSetting2.setReminderStartDate(afterDate2);

        // Setting reminders in the service
        reminderService.setReminder(reminderSetting1);
        reminderService.setReminder(reminderSetting2);

        // Verifying that both reminders were added
        Map<Integer, ReminderSettings> reminderList = reminderService.findAllReminder();
        assertEquals(2, reminderList.size());
    }

    /**
     * Tests the updateReminder method of the ReminderService class.
     * It verifies that reminders are correctly updated in the service.
     */
    @Test
    public void testUpdateReminder() {
        // Setting up the reminder
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.DECEMBER, 12);
        Date startDate = calendar.getTime();

        ReminderSettings reminderSetting = new ReminderSettings();
        reminderSetting.setReminderId(1);
        reminderSetting.setCustomMessage("Time to Pay the bill");
        reminderSetting.setNotificationPref("");
        reminderSetting.setReminderFrequency("Five");
        reminderSetting.setReminderStartDate(startDate);

        reminderService.setReminder(reminderSetting);

        // Updating the reminder
        reminderSetting.setCustomMessage("Updated Reminder Message");
        reminderService.updateReminder(reminderSetting);

        // Verifying that the reminder was updated
        ReminderSettings updatedReminder = reminderService.findAllReminder().get(1);
        assertEquals("Updated Reminder Message", updatedReminder.getCustomMessage());
    }

    /**
     * Tests the deleteReminder method of the ReminderService class.
     * It verifies that reminders are correctly deleted from the service.
     */
    @Test
    public void testDeleteReminder() {
        // Setting up the reminder
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.DECEMBER, 12);
        Date startDate = calendar.getTime();

        ReminderSettings reminderSetting = new ReminderSettings();
        reminderSetting.setReminderId(1);
        reminderSetting.setCustomMessage("Time to Pay the bill");
        reminderSetting.setNotificationPref("");
        reminderSetting.setReminderFrequency("Five");
        reminderSetting.setReminderStartDate(startDate);

        reminderService.setReminder(reminderSetting);

        // Deleting the reminder
        reminderService.deleteReminder(1);

        // Verifying that the reminder was deleted
        Map<Integer, ReminderSettings> reminders = reminderService.findAllReminder();
        assertEquals(0, reminders.size());
    }
}
