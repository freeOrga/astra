package com.younes.app.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.younes.app.IDisplayer;


@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages="com.younes")
public class MySampleController {
	@Autowired
	private IDisplayer displayer;
	

	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "<H2>hello"
				+displayer.getInfo()
				+"</H2>";
	}
		public static void main(String[] args) throws Exception {
		    SpringApplication sa=new 
		              SpringApplication(MySampleController.class);
		    sa.run(args);
	}
}
