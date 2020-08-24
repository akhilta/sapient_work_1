package datechange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class requestAccepting {
	
	@Autowired
	private addDates ad;
	
	public addDates getAd() {
		return ad;
	}
	public void setAd(addDates ad) {
		this.ad = ad;
	}
	@RequestMapping(value="/date-time" , method=RequestMethod.GET)
	public String  m1() {
		return "InputFile";
	}
	@RequestMapping(value="/date-time" , method=RequestMethod.POST)
	public String  m2(@RequestParam String date1,String date2, String operation,ModelMap mp) {
		mp.put("date1",date1); 
		mp.put("date2", date2);
		mp.put("dateAddObj", ad);  
		if(operation.equals("ADD")) {
			mp.put("oper", 1);
		}
		else {
			mp.put("oper",0);
		}
		System.out.println(operation+"- ---------->>>>>"); 
		return "OutputFile";  
	}
}
