## File Name Validator

#### Goals:
Given a file location, the program should validate the filename. If the file is invalid, it should print the error details along with the status of the file as passed or failed. The file name format should:
`Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv`

#### Instructions:
1. Run using CLI
    - Run Main.java class as java application
    - Enter the filename in the console and the application will validate the given input
    - It will print success message if the filename is valid or print an error message if the file name is invalid along with error details.

2. Run using JUnit
	- Run Maven clean + install and ensure build is successful
    - Run FileValidaterTest.java as JUnit Test with pre-written test cases
    - All the JUnit tests should pass
    
#### Solution:
- Get the input and split it into 2 parts with file extension and filename
- Split the filename in to 4 parts to ensure that it has all the required parts to match with the given format
- Validate each part to match expected string or format
	- first part of filename should be prefix 'Test'
	- second part of filename should be portfolio code that is only 'A'/'B'/'C'
	- third part of filename should be date in format of 'ddmmyyyy'
	- fourth part of filename should be sequence number that only accept 2 digit number
	
#### Assumption:
- Only filename string is passed to method for validations

#### Enhancement:
- To accept file objects or full file path