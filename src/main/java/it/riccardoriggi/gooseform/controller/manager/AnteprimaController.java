package it.riccardoriggi.gooseform.controller.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/anteprima")
public class AnteprimaController {



	@GetMapping("/")
	public ResponseEntity<Object> rootPage(HttpServletRequest request){
		return new ResponseEntity<Object>("GOOSEEEE",HttpStatus.OK);
	}



}
