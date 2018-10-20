package org.qimei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.qimei.validations.Validation;

public class Main {

	static Validation validation = new Validation();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file name: ");
        while (true) {
        	try {
    			String filename = br.readLine();
    			System.out.println(validation.checkFilenameFormart(filename));
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
        
	}

}
