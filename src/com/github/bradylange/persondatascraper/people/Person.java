/*
 * Developer: Brady Lange
 * Course: CSIS 162 - Programming II
 * Institution: University of Wisconsin-River Falls
 * Class: Person
 * Development Language: Java
 * Copyright Notice: MIT License, Copyright (c) 2019 Brady Lange
 */

package com.github.bradylange.persondatascraper.people;

// Import io library - missing file exception, file reader, text writer
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
// Import util library - console scanner
import java.util.Scanner;

/**
 * <p>
 * 		Uses an input text file to instantiate person information and then
 * 		writes the person's properties formatted to a new text file. Calculates
 * 		multiple peoples average grade point average collectively.
 * </p>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" 
 *                           target = "_blank">LinkedIn</a>
 * @version  1.0.1, 01/13/2019
 * @since  1.0, 03/07/2017
 */
public class Person 
{ 
	// ------------------------------------------------------------------------
	// Instance Variables 
	// ------------------------------------------------------------------------
	/**
	 * A personal name given to someone at birth or baptism and used before 
	 * a family name.
	 */
	private String firstName; 														 
	/**
	 * Surname.
	 */
	private String lastName;  														
	/**
	 * The length of time that a person has lived.
	 */
	private int age;          														
	/**
	 * An indication of a student's academic achievement at a college or 
	 * university, calculated as the total number of grade points received 
	 * over a given period divided by the total number of credits awarded.
	 */
	private double gpa; 															
	/**
	 * The particulars of the place where someone lives or an organization is 
	 * situated.
	 */
	private String address; 														
	/**
	 *  A number assigned to a telephone line for a specific phone or set 
	 *  of phones (as for a residence) that is used to call that phone. 
	 */
	private String mobileNumber; 													
	
	// ========================================================================
	// Default Constructor
	// ========================================================================
	/**
	 * Constructs a {@link Person} object by reading the text from an input 
	 * text file, then formats it and writes it to a new text file.
	 * 
	 * @throws FileNotFoundException  if invalid file path or missing file
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public Person() throws FileNotFoundException 							
	{
		// Instantiate default properties
	    firstName = "";															
	    lastName = "";															
	    age = 0;																
	    gpa = 0;																	
	    address = "";															
	    mobileNumber = "";															
	    
	    // Grade point average total
	    double sum = 0;	
	    // Average grade point average 
	    double gpaAverage = 0;	
	    // Total amount of people
	    int numberOfStudents = 0;									
	    
	    // Create an input stream
		Scanner inFile = new Scanner(new FileReader("./data/inFile.txt"));		
		// Create an output stream
		PrintWriter outFile = new PrintWriter("./data/outFile.txt");		
		outFile.println("Class Roster | Developer: Brady Lange");
		outFile.println("***************************************************"
		                + "*************************************************"
		                + "*************************************************");
		// Format header - 18 spaces after each String
		outFile.printf("%-18s%-18s%-18s%-18s%-19s%-18s", 
		               "First", "Last", "Age", "GPA", "Mobile Number", 
		               "Address");
		outFile.println("\n***************************************************"
		                + "*************************************************"
                        + "*************************************************");
		
		// Read file until no more characters  
		while (inFile.hasNext())									
		{
			// Scrape person's first name
			firstName = scrapeFirstName(inFile);
			// Format person's first name - 18 spaces after String
			outFile.printf("%-18s", firstName);
			// Scrape person's last name
			lastName = scrapeLastName(inFile);
			// Format person's last name - 18 spaces after String
			outFile.printf("%-18s", lastName);
			// Scrape person's age
			age = scrapeAge(inFile);	
			// Format person's age - 18 spaces after String 
			outFile.printf("%-18s", age);	
			// Retrieve person's grade point average
			gpa = scrapeGPA(inFile);	
			// Format person's grade point average - 18 spaces after String
			outFile.printf("%-18s", gpa);
			// Add person's grade point average to total GPA for class
			sum = sum + gpa; 		
			// Scrape person's mobile phone number
			mobileNumber = scrapeMobileNumber(inFile);	
			// Format person's mobile number - 18 spaces after String 
			outFile.printf("%-18s", mobileNumber);	
			// Scrape person's home address
			address = scrapeAddress(inFile);
			// Format person's home address - 18 spaces after String
			outFile.printf("%-18s", address);
			// Go to next line for each person
			outFile.println(); 	
			// Increment the number of people
			numberOfStudents++;										 
		} 
		outFile.println("***************************************************"
                        + "*************************************************"
                        + "*************************************************"); 
		
		// Find average grade point average for all of the people
		gpaAverage = sum / 6.0;								
		// Format average grade point average to two decimal places
		String cAvgGPA = String.format("%.2f", gpaAverage);			
		outFile.println("There are " + numberOfStudents + " students in the "
		                + "class and the average GPA for those students is " 
		                + cAvgGPA);
		// Close input file 
		inFile.close(); 	
		// Close output file 
		outFile.close();											
	}
	
	// ========================================================================
	// Scrape First Name Method
	// ========================================================================
	/**
	 * Scrapes the {@link Person}'s {@link #firstName} from the input text 
	 * file and returns the text.
	 * 
	 * @param inFile  the text file to be scraped
	 * 
	 * @return  the {@link #firstName}
	 * 
	 * @throws FileNotFoundException  if invalid file path or missing file
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String scrapeFirstName(Scanner inFile) throws FileNotFoundException	
	{
		// Scrape person's first name from file
		String fName = inFile.next();	
		// Return person's first name	
		return fName;																				
	} 
	
	// ========================================================================
	// Scrape Last Name Method
	// ========================================================================
	/**
	 * Scrapes the {@link Person}'s {@link #lastName} from the input text file 
	 * and returns the text.
	 * 
	 * @param inFile  the text file to be scraped
	 * 
	 * @return  the {@link #lastName}
	 * 
	 * @throws FileNotFoundException  if invalid file path or missing file
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String scrapeLastName(Scanner inFile) throws FileNotFoundException		
	{	
		// Scrape person's last name from file
		String lName = inFile.next();	
		// Return person's last name
		return lName;												
	}
	
	// ========================================================================
	// Scrape Age Method
	// ========================================================================
	/**
	 * Scrapes the numeric {@link Person}'s {@link #age} from the input text 
	 * file and returns the text.
	 * 
	 * @param inFile  the text file to be scraped
	 * 
	 * @return  the {@link #age}
	 * 
	 * @throws FileNotFoundException  if invalid file path or missing file
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public int scrapeAge(Scanner inFile) throws FileNotFoundException					
	{
		// Scrape person's age from file
		int age = inFile.nextInt();	
		// Return person's age
		return age;													
	}
	
	// ========================================================================
	// Scrape Grade Point Average Method
	// ========================================================================
	/**
	 * Scrapes the {@link Person}'s grade point average ({@link #gpa}) from the 
	 * input text file and returns the text.
	 * 
	 * @param inFile  the text file to be scraped
	 * 
	 * @return  the grade point average ({@link #gpa})
	 * 
	 * @throws FileNotFoundException  if invalid file path or missing file
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public double scrapeGPA(Scanner inFile) throws FileNotFoundException				
	{
		// Scrape person's grade point average from file 	
		double gpa = inFile.nextDouble();	
		// Format person's grade point average to two decimal places
		String gpaStr = String.format("%.2f", gpa);		
		// Convert person's grade point average from String to Double
		gpa = Double.parseDouble(gpaStr);
		// Return person's grade point average						
		return gpa;													
	}
	
	// ========================================================================
	// Scrape Address Method
	// ========================================================================
	/**
	 * Scrapes the {@link Person}'s home {@link #address} from the input text 
	 * file and returns the text.
	 * 
	 * @param inFile  the text file to be scraped
	 * 
	 * @return  the home {@link #address}
	 * 
	 * @throws FileNotFoundException  if invalid file path or missing file
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String scrapeAddress(Scanner inFile) throws FileNotFoundException			
	{
		// Scrape person's home address (nextLine - scrape more than one word)
		String address = inFile.nextLine(); 	
		// Return person's home address 
		return address;												
	}
	
	// ========================================================================
	// Scrape Mobile Number Method
	// ========================================================================
	/**
	 * Scrapes the {@link Person}'s {@link #mobileNumber} from the input text 
	 * file and returns the text.
	 * 
	 * @param inFile  the text file to be scraped
	 * 
	 * @return  the {@link #mobileNumber}
	 * 
	 * @throws FileNotFoundException  if invalid file path or missing file
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String scrapeMobileNumber(Scanner inFile) throws FileNotFoundException		
	{
		// Scrape person's mobile phone number 
		String mobileNumber = inFile.next();	
		// Return person's mobile phone number 
		return mobileNumber;										 
	}
	
	// ========================================================================
	// Set First Name Method
	// ========================================================================
	/**
	 * Sets the {@link Person}'s {@link #firstName}.
	 * 
	 * @param fName  the {@link #firstName}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public void setFirstName(String fName)
	{
		// Set person's first name
		firstName = fName;											
	}
	
	// ========================================================================
	// Set Last Name Method
	// ========================================================================
	/**
	 * Sets the {@link Person}'s {@link #lastName}.
	 * 
	 * @param lName  the {@link #lastName}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public void setLastName(String lName)
	{
		// Set person's last name
		lastName = lName;											
	}
	
	// ========================================================================
	// Set Age Method
	// ========================================================================
	/**
	 * Sets the {@link Person}'s {@link #age}.
	 * 
	 * @param age  the {@link #age}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public void setAge(int age)
	{
		// Set person's age
		this.age = age;												 
	}
	   
	// ========================================================================
	// Set Grade Point Average Method
	// ========================================================================
    /**
     * Sets the {@link Person}'s grade point average ({@link #gpa}).
     * 
     * @param gpa  the grade point average ({@link #gpa})
     * 
     * @version  1.0.1, 01/13/2019
     * @since  1.0, 03/07/2017
     */
	public void setGPA(double gpa)
	{
		// Set person's grade point average
		this.gpa = gpa;												
	}
	
	// ========================================================================
	// Set Address Method
	// ========================================================================
	/**
	 * Sets the {@link Person}'s home {@link #address}.
	 * 
	 * @param address  the home {@link #address}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public void setAddress(String address)
	{
		// Set person's home address
		this.address = address;										
	}
	
	// ========================================================================
	// Set Mobile Number Method
	// ========================================================================
	/**
	 * Sets the {@link Person}'s {@link #mobileNumber}.
	 * 
	 * @param mobileNumber  the {@link #mobileNumber}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public void setMobileNumber(String mobileNumber)
	{
		// Set person's mobile phone number
		this.mobileNumber = mobileNumber;							
	}
	
	// ========================================================================
	// Get First Name Method
	// ========================================================================
	/**
	 * Returns the {@link Person}'s {@link #firstName}.
	 * 
	 * @return  the {@link #firstName}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String getFirstName()
	{
		// Return person's first name
	    return firstName;																			
	}
	
	// ========================================================================
	// Get Last Name Method
	// ========================================================================
	/**
	 * Returns the {@link Person}'s {@link #lastName}.
	 * 
	 * @return  the {@link #lastName}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String getLastName()
	{	
		// Return person's last name
	    return lastName;																						
	} 
	
	// ========================================================================
	// Get Age Method
	// ========================================================================
	/**
	 * Returns the {@link Person}'s {@link #age}.
	 * 
	 * @return  the {@link #age}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public int getAge()
	{	
		// Return person's age 
		return age;																		
	}
	
	// ========================================================================
	// Get Grade Point Average Method
	// ========================================================================
	/**
	 * Returns the {@link Person}'s grade point average's ({@link #gpa}).
	 * 
	 * @return  the grade point average ({@link #gpa})
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public double getGPA()
	{
		// Return person's grade point average	
		return gpa;																							
	}
	
	// ========================================================================
	// Get Address Method
	// ========================================================================
	/**
	 * Returns the {@link Person}'s home {@link #address}.
	 * 
	 * @return  the home {@link #address}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String getAddress()
	{
		// Return person's home address
		return address;												
	}
	
	// ========================================================================
	// Get Mobile Number Method
	// ========================================================================
	/**
	 * Returns the {@link Person}'s {@link #mobileNumber}.
	 * 
	 * @return  the {@link #mobileNumber}
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String getMobileNumber()
	{
		// Return person's mobile phone number
		return mobileNumber;										 
	}

	// ========================================================================
	// To String Method
	// ========================================================================
	/**
	 * Returns the String representation of the {@link Person} object's 
	 * properties.
	 * 
	 * @return  the properties of the {@link Person} object as a String
	 * 
	 * @version  1.0.1, 01/13/2019
	 * @since  1.0, 03/07/2017
	 */
	public String toString()
	{
		// Person properties
		String data = "First name: " + firstName + " Last name: " + lastName 
		              + " Age: " + age + " gpa: " + gpa + " Address: " 
		              + address + " Mobile number: " + mobileNumber;
		// Return person's properties
		return data;												 
	}	
}