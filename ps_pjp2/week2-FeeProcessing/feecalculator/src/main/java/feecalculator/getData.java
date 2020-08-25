package feecalculator;

import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class getData {

	
	public ArrayList  m1(int i) {
		ArrayList<TransactionFormat> al=new ArrayList();
		 double marketValue=0;
		 int j;
		 String secid="",type="",date="",priority="",identifier="",clientid="",tranid="";
		try { 
			  String file="C:\\Users\\hp\\Desktop\\certificates\\clients.csv";
	        FileReader filereader = new FileReader(file); 
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) { 
	        	j=0;
	        	identifier="";
	        	
	            for (String cell : nextRecord) { 
	            	
	            	switch(j) {
	            	case 0:
	            		tranid=cell;
	            		break;
	            	case 1:
	            		clientid=cell;
	            		identifier=identifier+cell;
	            		break;
	            	case 2:
	            		secid=cell;
	            		identifier=identifier+cell;
	            		break;
	            	case 3:
	            		type=cell;
	            		break;
	            	case 4:
	            		date=cell;
	            		identifier=identifier+cell;
	            		break;
	            	case 5:
	            		marketValue=Double.parseDouble(cell);
	            		break;
	            	case 6:
	            		priority=cell;
	            		
	            	}
	            	j+=1;
	            	
	            	
	                System.out.print(cell + "\t"); 
	            }
	            al.add(new TransactionFormat(tranid, clientid, marketValue, secid, type, date, priority,identifier));
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		return al;
	}
}
