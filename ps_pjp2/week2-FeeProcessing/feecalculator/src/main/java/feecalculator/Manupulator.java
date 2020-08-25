package feecalculator;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import org.springframework.stereotype.Component;
public class Manupulator {
	
	private ArrayList<TransactionFormat> al;
	 Date d1 ;
     Date d2 ;
	public ArrayList<TransactionFormat> returnElements(){
		
		 // Create SimpleDateFormat object 
        SimpleDateFormat 
            sdfo 
            = new SimpleDateFormat("dd-MM-yyyy"); 
  
        
       
		getData gd=new getData();
		al=gd.m1(1);
		ExecuteProcessingRules ep=new ExecuteProcessingRules();
		ep.processing(al);
		al.stream().forEach(i1->System.out.println(i1.clientid+" "+i1.secid+" "+i1.date+" "+i1.processingfee));
		//cal
		Comparator<TransactionFormat> c=(a,b)->{
			if(a.clientid.compareTo(b.clientid)<0) {
				return -1;
			}
			else if(a.clientid.compareTo(b.clientid)>0) {
				return 1;
			}
			else {
				int val=0;
				try {
					d1=sdfo.parse(a.date);
					d2=sdfo.parse(b.date);
					
					if(d1.compareTo(d2)>0) {
						val= 1;
					}
					else {
						val= -1;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return val;
				
			}
		};
		al.sort(c);           
		return al;
	}

}
