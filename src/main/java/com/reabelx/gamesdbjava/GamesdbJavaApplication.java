package com.reabelx.gamesdbjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/**
 * Generic Entry point that is considered to be the start of the Games DB
 * TODO: Learn the diff between Controller and RestController
 * @param name
 * @param model
 * @return
 */
@SpringBootApplication
@Controller
public class GamesdbJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesdbJavaApplication.class, args);
	};

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	};

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/error")
	public String error(@RequestParam(name="name", required=false, defaultValue="World") String name, Model errorModel) {
		errorModel.addAttribute("name", name);
		return "greeting";
	}
}
