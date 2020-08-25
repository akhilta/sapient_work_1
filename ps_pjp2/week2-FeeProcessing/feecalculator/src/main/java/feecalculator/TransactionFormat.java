package feecalculator;

public class TransactionFormat {
public double marketValue,processingfee;
public String secid,type,date,priority,identifier,clientid,tranid;
public boolean flag;
public TransactionFormat(String tranid, String clientid, double marketValue, String secid, String type, String date,
		String priority,String identifier) {
	super();
	this.tranid = tranid;
	this.clientid = clientid;
	this.marketValue = marketValue;
	this.secid = secid;
	this.type = type;
	this.date = date;
	this.priority = priority;
	this.identifier=identifier; 
}


}
