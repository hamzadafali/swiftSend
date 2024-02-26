package ch.swiftsend.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class HelloController {


	@GetMapping
	public String sayHello() {
		return "Hello from basic Controller";
	}
}
