package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void test01()  throws Throwable  {
		GregorianCalendar newDay = new GregorianCalendar(2018, 04, 11); 
		CalDay calendarDay = new CalDay(newDay);
		Calendar testCurrent = Calendar.getInstance();
		assertTrue(calendarDay.isValid());
		assertEquals(11, calendarDay.getDay());
		assertEquals(04, calendarDay.getMonth());
		assertEquals(2018, calendarDay.getYear());
	 }
	@Test
	public void test02()  throws Throwable  {
		GregorianCalendar newDay = new GregorianCalendar(2018, 04, 11); 
		CalDay calendarDay = new CalDay(newDay);
		Calendar testCurrent = Calendar.getInstance();
		assertTrue(calendarDay.isValid());
		assertEquals(11, calendarDay.getDay());
		assertEquals(04, calendarDay.getMonth());
		assertEquals(2018, calendarDay.getYear());
		
		Appt appointment1 = new Appt(7, 1, 5, 10, 2010, "birthday party", "my birthday party is today");
		assertTrue(appointment1.getValid());
		calendarDay.addAppt(appointment1);
		calendarDay.toString();
	}
	@Test
	public void test03()  throws Throwable  {
		
		Calendar testCurrent = Calendar.getInstance();
		int thisMonth = testCurrent.get(Calendar.MONTH);
		int thisYear = testCurrent.get(Calendar.YEAR);
		int thisDay = testCurrent.get(Calendar.DAY_OF_MONTH); 
		
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		CalDay calendarDay = new CalDay(today);
		
		assertEquals(true, calendarDay.isValid());
		
		assertNotNull(calendarDay.getAppts());
		assertNotNull(calendarDay.getAppts());
		assertNotNull(calendarDay.getAppts());
		assertNotNull(calendarDay.getSizeAppts());
		assertNotNull(calendarDay.toString());
		assertNotNull(calendarDay.iterator());
		assertNotNull(calendarDay.getAppts());
	}
	@Test
	public void test04()  throws Throwable  {
		Appt appointment1 = new Appt(12, 22, 22, 11, 2018, "meeting", "work meeting");
		Appt appointment2 = new Appt(13, 22, 22, 11, 2018, "meeting", "work meeting");
		Appt appointment3 = new Appt(14, 22, 22, 11, 2018, "meeting", "work meeting");

		assertTrue(appointment1.getValid());
		assertTrue(appointment2.getValid());
		assertTrue(appointment3.getValid());
		
		Calendar current = Calendar.getInstance();
		int thisMonth = current.get(Calendar.MONTH)+1;
		int thisYear = current.get(Calendar.YEAR);
		int thisDay = current.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		CalDay calendarDays = new CalDay(today);
		assertEquals(true, calendarDays.isValid());
		
		calendarDays.addAppt(appointment1);
		assertNotNull(calendarDays.getAppts());
		calendarDays.addAppt(appointment2);
		assertNotNull(calendarDays.getAppts());
		calendarDays.addAppt(appointment3);
		assertNotNull(calendarDays.getAppts());
	}
}
