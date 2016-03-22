package ca.uwo.csd.cs2212.team05;

import java.io.File;

/**
 /**
 * Data class stores several variables (date and a value).
 * 
 * 
 * @author Peter Valovcik, modified by Justin Grant
 * @version 1.0
 * 
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Data implements Serializable {

		protected static final long serialVersionUID = 1L;
		protected String simpleDataFormat;
		protected String path;
		
		/* Constructor sets all variables to inputs.
		 * @param v, double representing the value to store
		 * @param y, integer representing the year
		 * @param m, integer representing the month
		 * @param d, integer representing the day */
		public Data(String simpleDataFormat){
			this.simpleDataFormat = simpleDataFormat;
			this.path = setPath();
		}

		public String setPath(){
			String result;
			final String PATH = "src/main/resources/";
			String dataType = this.getClass().getSimpleName();
			String name = dataType + simpleDataFormat + ".dat";
			result = PATH + dataType + "/"+ name;
			return result;
		}
		
		public String getSimpleDataFormat() {
			return simpleDataFormat;
		}
		

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public void setSimpleDataFormat(String simpleDataFormat) {
			this.simpleDataFormat = simpleDataFormat;
		}
		
		public void writeData(){
		      try
		      {
		    	  File output = new File(path);
		    	  output.createNewFile();
		         FileOutputStream fileOut =new FileOutputStream(output);
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(this);
		         out.close();
		         fileOut.close();
		         System.out.println("Serialized data is saved in path");
		      }catch(IOException i)
		      {
		          i.printStackTrace();
		      }
		}
		
		public Object readDate() {
			Object output;
			try{
				FileInputStream fileIn = new FileInputStream(path);
				 ObjectInputStream read = new ObjectInputStream(fileIn);
				 output = read.readObject();
				 read.close();
				 fileIn.close();
				 System.out.println("Data file was read successfully");
				 return output;
			}catch(IOException i){
				i.printStackTrace();
				return null;
			}catch(ClassNotFoundException c){
				System.out.println("Data file was not found");
				c.printStackTrace();
				return null;
			}	 	
		}
		
	}