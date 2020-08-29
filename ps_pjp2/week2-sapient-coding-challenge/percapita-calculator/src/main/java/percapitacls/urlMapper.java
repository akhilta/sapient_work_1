package percapitacls;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class urlMapper {

	@RequestMapping("/getaverage")
	public String  m1(ModelMap m) throws IOException {
		Manupulator obj1=new Manupulator();
		ArrayList<outputFormat> al=obj1.returnelements();
		m.addAttribute("list", al);
		return "outputfile";
	}
}
