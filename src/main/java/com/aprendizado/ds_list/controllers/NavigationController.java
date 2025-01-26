package com.aprendizado.ds_list.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class NavigationController {
	
	@GetMapping
	public String displayHomeLinksList() {
		return """
				Take a look on the return of endpoints:
				<ul>
					<li>
					 	<a href="localhost:8080/games"> See all games </a>
					</li>
				</ul>
				""";
	}
}
