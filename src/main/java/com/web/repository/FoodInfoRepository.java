package com.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.config.SessionFactory;
import com.web.dto.FoodInfoDTO;
import com.web.service.FoodInfoService;

public class FoodInfoRepository {
	public List<FoodInfoDTO> selectFoodInfos(FoodInfoDTO foodInfo){
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectList("mvc.FoodInfoMapper.selectFoodInfos");
		}
	}
	public FoodInfoDTO selectFoodInfo(int fiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectOne("mvc.FoodInfoMapper.selectFoodInfo",fiNum);
		}
	}
	public int insertFoodInfo(FoodInfoDTO foodInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.insert("mvc.FoodInfoMapper.insertFoodInfo",foodInfo);
		}
	}
	public int updateFoodInfo(FoodInfoDTO foodInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.update("mvc.FoodInfoMapper.updateFoodInfo",foodInfo);
		}
	}
	public int deleteFoodInfo(int fiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.delete("mvc.FoodInfoMapper.deleteFoodInfo",fiNum);
		}
	}
	public static void main(String[] args) {
		FoodInfoRepository fiRepo = new FoodInfoRepository();
		FoodInfoDTO foodInfo2 = new FoodInfoDTO();
		foodInfo2.setFiName("태훈");
		foodInfo2.setFiPrice(10000);
		foodInfo2.setFiNum(4);
		
		List<FoodInfoDTO> foodInfos = fiRepo.selectFoodInfos(foodInfo2);
		for(FoodInfoDTO foodInfo: foodInfos) {
			System.out.println(foodInfo);
		}
		
		int result = fiRepo.insertFoodInfo(foodInfo2);
		System.out.println("insert : " +result);
		result = fiRepo.updateFoodInfo(foodInfo2);
		System.out.println("update : " + result);
		result = fiRepo.deleteFoodInfo(4);
		System.out.println("delete : " + result);
		
	}
}
