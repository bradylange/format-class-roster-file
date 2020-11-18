/*
 * Developer: Brady Lange
 * Course: CSIS 162 - Programming II
 * Institution: University of Wisconsin-River Falls
 * Class: Driver
 * Development Language: Java
 * Copyright Notice: MIT License, Copyright (c) 2019 Brady Lange
 */

package com.github.bradylange.persondatascraper.applications;

// Import io library - missing file exception
import java.io.FileNotFoundException;

import com.github.bradylange.persondatascraper.people.Person;

/**
 * <p>
 * 		Constructs a {@link Person} object then prints the person's attributes 
 * 		formatted to a new text file. Contains the {@link #main} method and 
 *      "glues" other classes together.
 * </p>
 * <p>
 * 		Depends on:
 * </p>
 * <ul>
 * 		<li>
 * 			{@link Person}
 * 		</li>
 * </ul>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" 
 *                           target = "_blank">LinkedIn</a>
 * @version  1.0.1, 01/11/2019
 * @since  1.0, 03/07/2017
 */
public class Driver 
{ 
	// ========================================================================
	// Main Method
	// ========================================================================
	/**
	 * Instantiates and sets up a {@link Person} object.
	 * 
	 * @param args  the array of command line arguments to be passed
	 * 
	 * @throws FileNotFoundException  if invalid file path or missing file
	 * 
	 * @version  1.0.1, 01/11/2019
	 * @since  1.0, 03/07/2017
	 */
	public static void main(String[] args) throws FileNotFoundException 	
	{
		System.out.println("************************************************");
		System.out.println("Writing Person Data to a File:");
		System.out.println("************************************************");
		System.out.println("Writing object data to output file...");
		// Write person properties to an output text file 
		@SuppressWarnings("unused")											
		Person csis162 = new Person();			
		System.out.println("Success!");	
		System.out.println("************************************************\n");
	}
}