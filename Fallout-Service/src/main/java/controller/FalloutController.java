package controller;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.c
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.FalloutPart;
import service.FalloutProcessor;


@CrossOrigin()
@RestController
public class FalloutController {
	
	private FalloutProcessor processor = new FalloutProcessor();
	
	protected Logger logger = Logger.getLogger(FalloutController.class.getName());
	
	@RequestMapping(value ="/billing/ping",
			method = RequestMethod.GET)
	
	public String findContractById() {
		return "Ping Successful";
	}
	
    @RequestMapping("/cellular")
    public String index() {
    	FalloutPart outPart = new FalloutPart();
    	outPart.setPartID("68823531");
    	try {
			processor.getInput();
			return processor.processFallout(outPart)+" ";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	logger.info("Finally Here");
        return "Greetings from Spring Boot!";
    }

}
