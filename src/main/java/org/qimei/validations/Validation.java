package org.qimei.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.qimei.constants.MessagesConstants;

public class Validation {

	private static String prefixTest = "Test";
	private static String[] portfolioCodes = { "A", "B", "C" };
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
	private static String fileExtensionCsv = "csv";

	public String checkFilenameFormart(String filename) {

		// first check if the filename has "_" and "." to validate the file format
		if (filename.contains("_") && filename.contains(".")) {
			
			// split the filename by "." to name and extension, then split the name by "_" to validate each element
			String[] filenameAndFileExtArray = filename.split("\\.");
			String[] filenameArray = filenameAndFileExtArray[0].split("_");
			
			if (filenameAndFileExtArray.length == 2) {
				
				// validate file extension
				if (!checkFileExtension(filenameAndFileExtArray[1])) {
					return "File '" + filename + "' failed validation. \n" + MessagesConstants.INVALID_FILE_EXTENSION
							+ "'" + filenameAndFileExtArray[1] + "'";
				}
			} else {
				return "File '" + filename + "' failed validation. \n" + MessagesConstants.INVALID_FILENAME_FORMAT;
			}
			
			if (filenameArray.length == 4) {
				
				// validate the filename prefix
				if (!checkFilenamePrefix(filenameArray[0])) {
					return "File '" + filename + "' failed validation. \n" + MessagesConstants.INVALID_PREFIX + "'"
							+ filenameArray[0] + "'";
				}
				
				// validate portfolio code
				if (!checkPortfolioCode(filenameArray[1])) {
					return "File '" + filename + "' failed validation. \n" + MessagesConstants.INVALID_PORTFOLIO_CODE + "'"
							+ filenameArray[1] + "'";
				}
				
				// validate date format
				if (!checkDateFormat(filenameArray[2])) {
					return "File '" + filename + "' failed validation. \n" + MessagesConstants.INVALID_DATE_FORMAT;
				}
				
				// validate sequence number
				if (!check2DigitSeqNum(filenameArray[3])) {
					return "File '" + filename + "' failed validation. \n" + MessagesConstants.INVALID_SEQUENCE_NUMBER
							+ "'" + filenameArray[3] + "'";
				}
				
				return "File '" + filename + "' " + MessagesConstants.VALIDATION_PASSED;
			} else {
				return "File '" + filename + "' failed validation. \n" + MessagesConstants.INVALID_FILENAME_FORMAT;
			}

		} else {
			return "File '" + filename + "' failed validation. \n" + MessagesConstants.INVALID_FILENAME_FORMAT;

		}

	}
	
	public boolean checkFilenamePrefix (String prefix) {
		if (null != prefix && prefix.equals(prefixTest)){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkPortfolioCode (String code) {
		if (Arrays.asList(portfolioCodes).contains(code)){
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDateFormat(String dateStr) {
		try {
			simpleDateFormat.setLenient(false);
			simpleDateFormat.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public boolean checkFileExtension(String fileExtension) {
		if (null != fileExtension && fileExtension.equals(fileExtensionCsv)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean check2DigitSeqNum(String num) {
		if (num.length() == 2) {
			try {
				Integer.parseInt(num);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
