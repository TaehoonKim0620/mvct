package com.web.repository2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.config.SessionFactory;
import com.web.dto2.UserInfoDTO;

public class UserInfoRepository {
	public List<UserInfoDTO> selectUserInfos(UserInfoDTO userInfo){
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectList("mvc.UserInfoMapper.selectUserInfos");
		}
	}
	public UserInfoDTO selectUserInfo(int uiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectOne("mvc.UserInfoMapper.selectUserInfo",uiNum);
		}
	}
	public int insertUserInfo(UserInfoDTO userInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.insert("mvc.UserInfoMapper.insertUserInfo",userInfo);
		}
	}
	public int updateUserInfo(UserInfoDTO userInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.update("mvc.UserInfoMapper.updateUserInfo",userInfo);
		}
	}
	public int deleteUserInfo(int uiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.delete("mvc.UserInfoMapper.deleteUserInfo",uiNum);
		}
	}
	public static void main(String[] args) {
		UserInfoRepository uiRepo = new UserInfoRepository();
		UserInfoDTO userInfo = new UserInfoDTO();
		userInfo.setUiName("김기믹미");
		userInfo.setUiId("gd");
		userInfo.setUiPwd("dg");
		List<UserInfoDTO> userInfos = uiRepo.selectUserInfos(userInfo);
		for(UserInfoDTO userInfoo: userInfos) {
			System.out.println(userInfoo);
		}
		
	}
}
