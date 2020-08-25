package feecalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ExecuteProcessingRules {

	
	public ArrayList<TransactionFormat> processing(ArrayList<TransactionFormat> al) {
		
		Comparator<TransactionFormat> c1=(a,b)->{
			
			if(a.identifier.compareTo(b.identifier) <=0) {
				return -1;
			}
			else {
				return 1;
			}
		};
		
		ArrayList<TransactionFormat> l=(ArrayList<TransactionFormat>) al.stream().sorted(c1).collect(Collectors.toList());
		System.out.println(l.hashCode()+" ---->> "+al.hashCode());
		int i=1;
		String s1="",s2="";
		TransactionFormat temp,temp1;
		for(i=1;i<l.size();i++) {
			temp=l.get(i-1);
			temp1=l.get(i);
			s1=temp.type+temp1.type;
			//System.out.println(temp.identifier+"  "+temp1.identifier+" "+temp.type+" "+temp1.type);
			if(temp1.identifier.equals(temp.identifier) && (s1.startsWith("SELLBUY") || s1.startsWith("BUYSELL"))) {
				System.out.println("came here dddd");
				temp.processingfee=10;
				temp1.processingfee=10;
				i=i+1;
				temp.flag=true;
				temp1.flag=true;
			}
		}
		for(TransactionFormat t:l) {
			if(!t.flag) {
				if(t.priority.equals("Y")) {
					t.processingfee=500;
				}
				else if(t.type.equals("SELL") || t.type.equals("WITHDRAW")) {
					t.processingfee=100;
				}
				else {
					t.processingfee=50;
				}
			}
		}
		
		
		
		
		
		
		
		return al;
	}
}
