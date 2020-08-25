package ControllerPackage;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import feecalculator.Manupulator;
import feecalculator.TransactionFormat;

@Controller
public class RequestMappingController {

	@RequestMapping("/getfee")
	public String he(ModelMap mp) {
		Manupulator m=new Manupulator();
		ArrayList<TransactionFormat> al=m.returnElements();
		mp.put("list", al);
		return "outputfile";
	}
}
