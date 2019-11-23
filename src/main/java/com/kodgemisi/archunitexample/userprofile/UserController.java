package com.kodgemisi.archunitexample.userprofile;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class UserController {

	@GetMapping
	ResponseEntity<Iterable<User>> list() {
		return ResponseEntity.ok(null);
	}

}
