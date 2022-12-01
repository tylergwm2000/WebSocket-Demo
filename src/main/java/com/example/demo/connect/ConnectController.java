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
    public void connect(@RequestParam(value = "uuid", required = true) String uuid) throws Exception {    	
		System.out.println(uuid + " REST API connected!");
    }

}
