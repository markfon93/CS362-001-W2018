package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.EmptyStackException;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	@Test
	public void test01()  throws Throwable  {
		TimeTable testTable = new TimeTable();
		GregorianCalendar today = new GregorianCalendar(2018, 29, 11);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 28, 11);
		GregorianCalendar tomorrow = new GregorianCalendar(2018, 29, 11);
		testTable.deleteAppt(null, null);
	}
	@Test
	public void test02()  throws Throwable  {
		Calendar currentCalDay = Calendar.getInstance();
		int testYear = currentCalDay.get(Calendar.YEAR);
		int testMonth = currentCalDay.get(Calendar.MONTH);
		int testDay = currentCalDay.get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar today = new GregorianCalendar(testYear, testMonth, testDay);
		
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		GregorianCalendar nextDay = (GregorianCalendar)tomorrow.clone();
		nextDay.add(Calendar.DAY_OF_MONTH,2);
		GregorianCalendar yesterday = (GregorianCalendar)today.clone();
		yesterday.add(Calendar.DAY_OF_MONTH,-1);
		
	}
	@Test
	public void test03()  throws Throwable  {	
		TimeTable testTable = new TimeTable();
		GregorianCalendar today = new GregorianCalendar(2018, 11, 15);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 11, 16);
		GregorianCalendar tomorrow = new GregorianCalendar(2018, 11, 17);

		Appt appointment1 = new Appt(10, 11, 11, 11, 2024, "SOMETHING TODAY", "I forget what");
		Appt appointment2 = new Appt(10, 12, 12, 11, 2024, "SOMETHING TODAY", "I forget what");
		Appt appointment3 = new Appt(10, 13, 13, 11, 2024, "SOMETHING TODAY", "I forget what");

		LinkedList<Appt> list = new LinkedList<Appt>();
		list.add(appointment1);
		list.add(appointment2);
		list.add(appointment3);
		
		testTable.getApptRange(list, today, tomorrow);
		testTable.getApptRange(list, today, yesterday);
        
		testTable.deleteAppt(list, appointment1);
		testTable.deleteAppt(list, appointment2);
		testTable.deleteAppt(list, appointment3);
		
		assertNotNull(testTable);
		assertNotNull(list);
		assertNotNull(testTable.getApptRange(list, today, tomorrow));
		assertNotNull(testTable.getApptRange(list, today, yesterday));
	}

//add more unit tests as you needed
}