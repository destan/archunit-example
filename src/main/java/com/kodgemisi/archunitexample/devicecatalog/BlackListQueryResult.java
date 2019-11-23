package com.kodgemisi.archunitexample.devicecatalog;

import lombok.Getter;

import java.util.Optional;

@Getter
class BlackListQueryResult {

	private final Optional<BlackListReason> blackListReason;

	private final boolean blackListed;

	BlackListQueryResult(BlackListReason blackListReason, boolean blackListed) {
		this.blackListReason = Optional.ofNullable(blackListReason);
		this.blackListed = blackListed;
	}
}
