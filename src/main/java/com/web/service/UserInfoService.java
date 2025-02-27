package com.web.service;

import java.util.List;

import com.web.dto.UserInfoDTO;
import com.web.repository.UserInfoRepository;

public class UserInfoService {
	private UserInfoRepository uiRepo = new UserInfoRepository();
	
	public List<UserInfoDTO> getUserInfos(UserInfoDTO userInfo){
		return uiRepo.selectUserInfos(userInfo);
	}
	
	public static void main(String[] args) {
		UserInfoService uiService = new UserInfoService();
		List<UserInfoDTO> userInfos = uiService.getUserInfos(null);
		for(UserInfoDTO userInfo : userInfos) {
			System.out.println(userInfo);
		}
		
	}
}
