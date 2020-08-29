package percapitacls;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;

public class getData {

	
	public ArrayList  m1(int i) {
		ArrayList<TransactionFormat> al=new ArrayList();
		 double averageincome=0;
		 int j;
		 String city="",country="",gender="",currency="";
		 Map<String,Double> mp=new HashMap<>();
		 mp.put("INR", 66.0);
		 mp.put("HKD", 8.0);
		 mp.put("USD", 1.0);
		 mp.put("SGP", 1.5);
		 mp.put("GBP", 0.67);
		 
		try { 
			  String file="C:\\Users\\hp\\Desktop\\Sample input file Assignment 3.csv";
	        FileReader filereader = new FileReader(file); 
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) { 
	        	j=0;
	        	
	            for (String cell : nextRecord) { 
	            	
	            	switch(j) {
	            	case 0:
	            		city=cell;
	            		break;
	            	case 1:
	            		country=cell;
	            		
	            		break;
	            	case 2:
	            		gender=cell;
	            		
	            		break;
	            	case 3:
	            		
	            		currency=cell;
	            		break;
	            	case 4:
	            		if(currency.equals("GBP")) {
	            			System.out.println(Integer.parseInt(cell)+" --->"+mp.get(currency));
	            		}
	            		
	            		averageincome=Integer.parseInt(cell)/mp.get(currency);
	            		
	            		
	            		break;
	            		
	            	}
	            	j+=1;
	            	
	            	
	                //System.out.print(cell + "\t"); 
	            }
	            al.add(new TransactionFormat(city,country,gender,currency,averageincome));
	            //System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		return al;
	}
}

