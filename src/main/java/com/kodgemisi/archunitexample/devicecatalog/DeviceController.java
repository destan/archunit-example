package com.kodgemisi.archunitexample.devicecatalog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
class DeviceController {

	private final DeviceService deviceService;

	@GetMapping
	ResponseEntity<List<Device>> list() {
		return ResponseEntity.ok(null);
	}

	@PostMapping
	ResponseEntity<List<Device>> create(@Validated Device device) {
		return ResponseEntity.ok(null);
	}

}
