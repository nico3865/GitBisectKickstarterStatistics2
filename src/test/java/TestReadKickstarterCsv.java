import static org.junit.Assert.*;

import org.junit.Test;

import csv.CsvReader;

public class TestReadKickstarterCsv {

	@Test
	public void testThatItPrintsSomething() {
		CsvReader classUnderTest = new CsvReader();
        assertNotNull("making sure reading the csv file prints something", classUnderTest.getListOfRecordsFromCsv());
	}

}
