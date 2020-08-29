package datechange;

import org.springframework.stereotype.Component;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
@Component
public class addDates {

	
	public String addDate(String s1,String s2,int oper ) throws ParseException {
		
		
        SimpleDateFormat d1=new SimpleDateFormat("dd-M-yyyy");
        Date d2=d1.parse(s1);
        Date d3=d1.parse(s2);
        if(oper==1) {
        	Date d4=new Date(d2.getTime() +d3.getTime());
            String ans;
            Calendar c1=Calendar.getInstance();
            c1.setTime(d2);
            Calendar c2=Calendar.getInstance();
            c2.setTime(d3);
            Calendar cTotal = (Calendar) c1.clone();
            
            cTotal.add(Calendar.YEAR, c2.get(Calendar.YEAR));
            cTotal.add(Calendar.MONTH, c2.get(Calendar.MONTH) + 1); // Months are zero-based!
            cTotal.add(Calendar.DATE, c2.get(Calendar.DATE));
            cTotal.add(Calendar.HOUR_OF_DAY, c2.get(Calendar.HOUR_OF_DAY));
            cTotal.add(Calendar.MINUTE, c2.get(Calendar.MINUTE));
            cTotal.add(Calendar.SECOND, c2.get(Calendar.SECOND));
            cTotal.add(Calendar.MILLISECOND, c2.get(Calendar.MILLISECOND));
            System.out.println(cTotal.getTime()+"  ---------------->"); // Correct!
            d4=cTotal.getTime();
            ans=d1.format(d4);
    		return ans;
        }
        else {
        	DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
        	long diff = d2.getTime() - d3.getTime();
        	 
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			System.out.println("difference between days: " + diffDays);
 
			int diffhours = (int) (diff / (60 * 60 * 1000));
			System.out.println("difference between hours: " + crunchifyFormatter.format(diffhours));
 
			int diffmin = (int) (diff / (60 * 1000));
			System.out.println("difference between minutues: " + crunchifyFormatter.format(diffmin));
 
			int diffsec = (int) (diff / (1000));
			System.out.println("difference between seconds: " + crunchifyFormatter.format(diffsec));
			String ans= "difference between days:  "+Integer.toString(diffDays)
			+"difference between hours:  "+Integer.toString(diffhours)
			+"difference between minutes:  "+Integer.toString(diffmin)
			+"difference between seconds:  "+Integer.toString(diffsec);
			return ans;
        }
        
	}
	
	
}
