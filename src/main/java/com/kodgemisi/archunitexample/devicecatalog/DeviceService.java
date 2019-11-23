package com.kodgemisi.archunitexample.devicecatalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class DeviceService {

	private final DeviceRepository deviceRepository;

	Device create(Device device) {
		return device;
	}

}
