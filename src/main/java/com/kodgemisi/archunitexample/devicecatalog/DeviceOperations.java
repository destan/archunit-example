package com.kodgemisi.archunitexample.devicecatalog;

import com.kodgemisi.archunitexample.userprofile.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class DeviceOperations {

	private final DeviceRepository deviceRepository;

	//private final DeviceService deviceService;

	Iterable<Device> askForAvailableDevices() {

		//deviceService.create(null);

		return deviceRepository.findAll();
	}

	Iterable<Device> askForAvailableDevicesOf(User user) {

		return deviceRepository.findAll();
	}
}
