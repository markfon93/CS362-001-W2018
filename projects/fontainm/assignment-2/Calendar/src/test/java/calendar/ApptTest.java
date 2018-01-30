package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	@Test
	public void test01()  throws Throwable  {
	int testMinute = 30;	 
	int testHour = 21;
	int testDay = 15;
	int testMonth = 01;
	int testYear = 2018;
	String title = "Birthday Party";
	String description = "This is my birthday party.";
	Appt appointment = new Appt(testHour,
	    testMinute,
	    testDay,
	    testMonth,
	    testYear,
	    title,
	    description);
	 assertTrue(appointment.getValid());
	 assertEquals(30, appointment.getStartMinute());
	 assertEquals(21, appointment.getStartHour());
	 assertEquals(15, appointment.getStartDay());
	 assertEquals(01, appointment.getStartMonth());
	 assertEquals(2018, appointment.getStartYear());
	 assertEquals("Birthday Party", appointment.getTitle());
	 assertEquals("This is my birthday party.", appointment.getDescription());         		
	}
	
	@Test
	public void test02()  throws Throwable  {
	Appt appointment = new Appt(1, 1, 1, 1, 1, "", "");
	
	assertTrue(appointment.getValid());
	assertEquals(1, appointment.getStartMinute());
	assertEquals(1, appointment.getStartHour());
	assertEquals(1, appointment.getStartDay());
	assertEquals(1, appointment.getStartMonth());
	assertEquals(1, appointment.getStartYear());
	assertEquals("", appointment.getTitle());
	assertEquals("", appointment.getDescription());         		
	}
	
	@Test
	public void test03()  throws Throwable  {

		Appt appointment = new Appt(17, 44, 11, 11, 2021, "Meet John", "At the park.");
		assertEquals(2, appointment.getRecurBy());	
		assertEquals(true, appointment.getValid());
		assertEquals(0, appointment.getRecurIncrement());
		assertEquals(0, appointment.getRecurNumber());
		assertEquals(false, appointment.isRecurring());
		
		assertNotNull(appointment.getRecurDays());
		appointment.setStartHour(17);
		assertEquals("	11/11/2021 at 5:44pm ,Meet John, At the park.\n", appointment.toString());
		appointment.setStartMinute(44);                              
		assertEquals("	11/11/2021 at 5:44pm ,Meet John, At the park.\n", appointment.toString());
		appointment.setStartDay(11);                                 
		assertEquals("	11/11/2021 at 5:44pm ,Meet John, At the park.\n", appointment.toString());
		appointment.setStartMonth(11);                               
		assertEquals("	11/11/2021 at 5:44pm ,Meet John, At the park.\n", appointment.toString());
		appointment.setStartYear(2021);                              
		assertEquals("	11/11/2021 at 5:44pm ,Meet John, At the park.\n", appointment.toString());
		appointment.setTitle("");
		assertEquals("	11/11/2021 at 5:44pm ,, At the park.\n", appointment.toString());
		appointment.setDescription("");
		assertEquals("	11/11/2021 at 5:44pm ,, \n", appointment.toString());
	}
	
}
