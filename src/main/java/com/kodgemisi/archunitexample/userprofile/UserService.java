package com.kodgemisi.archunitexample.userprofile;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
class UserService {

	@Transactional
	public void batchCreate(Iterable<User> users) {

	}

}
