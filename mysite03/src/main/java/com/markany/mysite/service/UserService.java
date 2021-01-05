package com.markany.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markany.mysite.repository.UserRepository;
import com.markany.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public boolean join(UserVo vo) {
		System.out.println("before--->" + vo);
		int count = userRepository.insert(vo);
		System.out.println("after--->" + vo);

		return count == 1;
	}

	public UserVo getUser(UserVo vo) {
		// System.out.println("findbyEmail-->" + userRepository.findByEmail(vo.getEmail()));
		// return userRepository.findByEmailAndPassword2(vo);
		return userRepository.findByEmailAndPassword(vo);
	}

	public UserVo getUser(Long no) {
		return userRepository.findByNo(no);
	}

	public boolean updateUser(UserVo vo) {
		int count = userRepository.update(vo);
		return count == 1;
	}
	
	
}