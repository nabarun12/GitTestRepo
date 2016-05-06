package controller;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.c
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.FalloutPart;
import data.PartFalloutVO;
import data.PartOutputVO;
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
/*	
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
    }*/
    
    @RequestMapping(
    	    value = "/cellular", 
    	method = RequestMethod.POST,
    	    consumes = "application/json")

    	public @ResponseBody PartOutputVO fallOutCalculation(@RequestBody PartFalloutVO partVo) throws Exception {

    	FalloutPart outPart = new FalloutPart();
    	outPart.setPartID("68823531");
    	processor.getInput(partVo);
		return processor.processFallout(outPart);
			
    	}
    
    @RequestMapping(
    	    value = "/favorite", 
    	method = RequestMethod.POST,
    	    consumes = "application/json")

    	public void favorite(@RequestBody PartFalloutVO partVo) throws Exception {

    	
    	try {
		
			processor.writeFavortie(partVo);;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	logger.info("Finally Here");
       
    	
    	}
    	
    @RequestMapping(
    	    value = "/readFavorite", 
    	method = RequestMethod.POST)

    	public @ResponseBody PartFalloutVO readFavorite() throws Exception {

    	
    	return processor.readFromCSV();
       
    	
    	}
    

}
