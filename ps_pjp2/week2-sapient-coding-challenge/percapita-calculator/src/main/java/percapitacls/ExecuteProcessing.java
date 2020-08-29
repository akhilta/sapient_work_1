package percapitacls;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVWriter;

public class ExecuteProcessing {
	String tempkey;
	int i, j;
	double d;
	public Map<String, Double> mp = new HashMap<>();
	public Map<String, Integer> mp1 = new HashMap<>();
	public DecimalFormat df = new DecimalFormat("###.##");
	public ArrayList<outputFormat> outt=new ArrayList<>();

	public ArrayList<outputFormat> m1(ArrayList<TransactionFormat> al) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\hp\\Desktop\\outputassngmnet3.csv")); 
		
		al.stream().forEach(a -> {
			if (a.country.equals("")) {
				tempkey=a.city+a.gender;
			}
			else {
				tempkey=a.country+a.gender;
			}
			if(mp.containsKey(tempkey)) {
				d=mp.get(tempkey);
				mp.put(tempkey, d+a.averageincome);
				j=mp1.get(tempkey);
				mp1.put(tempkey, j+1);
			}
			else {
				d=a.averageincome;
				mp.put(tempkey, d);
				mp1.put(tempkey, 1);
			}
		});
		System.out.println(mp+"-----------------\n"+mp1+"-----------\n");
		
		Set<String> keys = mp.keySet();
		String[] array = keys.toArray(new String[keys.size()]);
		Arrays.sort(array);
		String temp1,temp2;
		for(int k=0;k<array.length;k++) {
			
			j=mp1.get(array[k]);
			d=mp.get(array[k]);
			d=Double.parseDouble(df.format(d/j));
			mp.put(array[k], d);
			temp1=array[k].substring(0, array[k].length()-1);
			temp2=""+array[k].charAt(array[k].length()-1);
			String ars[]= {temp1,temp2,Double.toString(d)};
			outt.add(new outputFormat(ars[0], ars[1],d));
			writer.writeNext(ars);
			
		}
		  writer.close(); 
		System.out.println(mp);
		 return outt;
		

	}
}
