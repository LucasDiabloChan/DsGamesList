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
					 	<a href="/"> This page (home) </a>
					</li>
					<li>
					 	<a href="/lists"> See all games genres </a>
					</li>
					<li>
					 	<a href="/lists/1/games"> See all games of an especific genre </a>
					 	<br>
					 	(1 - Adventure / 2 - Platform)
					</li>
					<li>
					 	<a href="/lists/1/replacement"> Change the position of a game in the list (this actually doesn't work because it needs a request body)</a>
					</li>
					<li>
					 	<a href="/games"> See all games (yes, again) </a>
					</li>
					<li>
					 	<a href="/games/2"> See an especific game </a>
					</li>
				</ul>
				
				<p>Obs: you can edit the numbers in the URL to change the return :) </p>
				""";
	}
}
