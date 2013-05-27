


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class InfoController {
	

	
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET )
	public String helloworld(@PathVariable String name, Model model){
		model.addAttribute("name", name);
		return "hello";
	}
	@RequestMapping(value="/",method=RequestMethod.GET )
	public String helloworld(){
		return "hello";
	}
 
}