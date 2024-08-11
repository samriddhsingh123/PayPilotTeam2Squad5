package test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import service.ReminderService;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import model.ReminderSettings;

public class ReminderTest {
	
	private ReminderService reminderservice;
	
	@Before
	public void setUp() throws Exception {
		reminderservice = new ReminderService();
		
	}
	
	//tests SetReminder method of the service class
	@Test
	public void testSetReminder() {
		Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2024, Calendar.DECEMBER, 12);
        Date afterDate1 = calendar1.getTime();
		ReminderSettings reminderSetting1= new ReminderSettings();
		reminderSetting1.setReminderId(1);
		reminderSetting1.setCustomMessage("Time to Pay the bill");
		reminderSetting1.setNotificationPref("");
		reminderSetting1.setReminderFrequency("Five");
		reminderSetting1.setReminderStartDate(afterDate1);
		
		Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2024, Calendar.OCTOBER, 12);
        Date afterDate2 = calendar2.getTime();
		ReminderSettings reminderSetting2= new ReminderSettings();
		reminderSetting2.setReminderId(2);
		reminderSetting2.setCustomMessage("Time to Pay the bill Soon");
		reminderSetting2.setNotificationPref("");
		reminderSetting2.setReminderFrequency("Ten");
		reminderSetting2.setReminderStartDate(afterDate2);
		// sets the reminder
		reminderservice.setReminder(reminderSetting1);
		reminderservice.setReminder(reminderSetting2);
		
		//Verify that the reminder was set
		Map<Integer, ReminderSettings> reminderList = reminderservice.findAllReminder();
		assertEquals(2,reminderList.size());
	}
	
	//tests UpdateReminder method of the service class
	@Test 
	public void testUpdateReminder() {
		Calendar calendar = Calendar.getInstance();
	    calendar.set(2024, Calendar.DECEMBER, 12);
	    Date startDate = calendar.getTime();

	    ReminderSettings reminderSetting = new ReminderSettings();
	    reminderSetting.setReminderId(1);
	    reminderSetting.setCustomMessage("Time to Pay the bill");
	    reminderSetting.setNotificationPref("");
	    reminderSetting.setReminderFrequency("Five");
	    reminderSetting.setReminderStartDate(startDate);

	    reminderservice.setReminder(reminderSetting);

	    // Update the reminder
	    reminderSetting.setCustomMessage("Updated Reminder Message");
	    reminderservice.updateReminder(reminderSetting);

	    // Verify that the reminder was updated
	    ReminderSettings updatedReminder = reminderservice.findAllReminder().get(1);
	    assertEquals("Updated Reminder Message", updatedReminder.getCustomMessage());
	}

	//tests DeleteReminder method of the service class
	@Test
	public void testDeleteReminder() {
		Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.DECEMBER, 12);
        Date startDate = calendar.getTime();

        ReminderSettings reminderSetting = new ReminderSettings();
        reminderSetting.setReminderId(1);
        reminderSetting.setCustomMessage("Time to Pay the bill");
        reminderSetting.setNotificationPref("");
        reminderSetting.setReminderFrequency("Five");
        reminderSetting.setReminderStartDate(startDate);

        reminderservice.setReminder(reminderSetting);

        // Delete the reminder
        reminderservice.deleteReminder(1);

        // Verify the reminder was deleted
        Map<Integer, ReminderSettings> reminders = reminderservice.findAllReminder();
        assertEquals(0, reminders.size());
	}

}
