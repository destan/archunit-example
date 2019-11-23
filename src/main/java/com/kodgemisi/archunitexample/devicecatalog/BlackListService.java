package com.kodgemisi.archunitexample.devicecatalog;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
class BlackListService {

	BlackListQueryResult isBlackListed(Device device) {

		return new BlackListQueryResult(BlackListReason.OTHER, true);
	}

	void blacklist(@NonNull Device device, @NonNull BlackListReason reason) {

		//throw new UnsupportedOperationException("Not implemented");
		throw new RuntimeException("Not implemented");
	}

}
