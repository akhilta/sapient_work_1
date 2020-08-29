package percapitacls;

import java.io.IOException;
import java.util.ArrayList;

public class Manupulator {
	
	
		
		public static ArrayList<outputFormat> returnelements() throws IOException{
			getData g=new getData();
			ExecuteProcessing e=new ExecuteProcessing();
			ArrayList<TransactionFormat> al=g.m1(1);
			ArrayList<outputFormat> ans=e.m1(al);
			return ans;
		}
		public static void main(String[] args) throws IOException {
			returnelements();
		}
}
