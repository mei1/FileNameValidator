package org.qimei.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qimei.constants.MessagesConstants;
import org.qimei.validations.Validation;

public class FileValidatorTest {

	String filename;
	Validation validation;

	@Before
	public void setUp() {
		filename = null;
		validation = new Validation();
	}

	@Test
	public void testPassValidation() {
		filename = "Test_A_07121987_01.csv";
		System.out.println(validation.checkFilenameFormart(filename) + "\n");
		// expected result: pass all validation
		Assert.assertTrue(validation.checkFilenameFormart(filename).contains(MessagesConstants.VALIDATION_PASSED));
	}

	@Test
	public void testPortfolioCodeValidation() {
		filename = "Test_E_07121987_01.csv";
		System.out.println(validation.checkFilenameFormart(filename) + "\n");
		// expected result: failed when validating portfolio code
		Assert.assertTrue(validation.checkFilenameFormart(filename).contains(MessagesConstants.INVALID_PORTFOLIO_CODE));
	}

	@Test
	public void testDateFormatValidation() {
		filename = "Test_A_12131987_01.csv";
		System.out.println(validation.checkFilenameFormart(filename) + "\n");
		// expected result: failed when validating date format
		Assert.assertTrue(validation.checkFilenameFormart(filename).contains(MessagesConstants.INVALID_DATE_FORMAT));
	}

	@Test
	public void testPrefixValidation() {
		filename = "Hello_A_07121987_01.csv";
		System.out.println(validation.checkFilenameFormart(filename) + "\n");
		// expected result: failed when validating prefix
		Assert.assertTrue(validation.checkFilenameFormart(filename).contains(MessagesConstants.INVALID_PREFIX));
	}

	@Test
	public void testFileExtValidation() {
		filename = "Test_A_07121987_01.txt";
		System.out.println(validation.checkFilenameFormart(filename) + "\n");
		// expected result: failed when validating file extension
		Assert.assertTrue(validation.checkFilenameFormart(filename).contains(MessagesConstants.INVALID_FILE_EXTENSION));
	}

	@Test
	public void testFileFormatValidation() {
		filename = "Test.txt";
		System.out.println(validation.checkFilenameFormart(filename) + "\n");
		// expected result: failed when validating file format without "_" and required number of elements for filename
		Assert.assertTrue(validation.checkFilenameFormart(filename).contains(MessagesConstants.INVALID_FILENAME_FORMAT));
	}

	@Test
	public void test2DigitSequenceNumber() {
		filename = "Test_A_07121987_ab.csv";
		System.out.println(validation.checkFilenameFormart(filename) + "\n");
		// expected result: failed when validating sequence number
		Assert.assertTrue(validation.checkFilenameFormart(filename).contains(MessagesConstants.INVALID_SEQUENCE_NUMBER));
	}

}
