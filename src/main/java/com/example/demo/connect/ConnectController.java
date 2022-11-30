package com.example.demo.connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ConnectController extends Controller{
	
	private final ControllerService cService;
	
	@Autowired
    public ConnectController(ControllerService cService) {
        this.cService = cService;
    }
	
	@PostMapping("/demo/connect")
    public void connect(@RequestPart("config") MultipartFile f_config, @RequestParam(value = "iterations", required = false) Long n_iterations,
    					@RequestParam(value = "duration", required = false) Double n_duration) 
    								   			   throws Exception {    	

    	ZipFile zf = this.sService.SimulateZip(f_config, n_iterations, n_duration);
		
    	return FilesResponse.build("simulation_results.zip", zf.toByteArray());
    }

}
