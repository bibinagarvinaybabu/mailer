package com.example.JavaMailProject.Mailer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;


public class BaseClass {
	
	public Properties LoapProperties() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/JavaMailProject/src/main/resources/Address.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
