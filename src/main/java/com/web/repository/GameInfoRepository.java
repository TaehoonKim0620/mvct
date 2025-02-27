package com.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.config.SessionFactory;
import com.web.dto.GameInfoDTO;

public class GameInfoRepository {

	public List<GameInfoDTO> selectGameInfos(GameInfoDTO gameInfo){
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectList("mvc.GameInfoMapper.selectGameInfos");
		}
	}
	public GameInfoDTO selectGameInfo(int giNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectOne("mvc.GameInfoMapper.selectGameInfo",giNum);
		}
	}
	public int insertGameInfo(GameInfoDTO gameInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.insert("mvc.GameInfoMapper.insertGameInfo",gameInfo);
		}
	}
	public int updateGameInfo(GameInfoDTO gameInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.update("mvc.GameInfoMapper.updateGameInfo",gameInfo);
		}
	}
	public int deleteGameInfo(int giNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.delete("mvc.GameInfoMapper.deleteGameInfo",giNum);
		}
	}
	public static void main(String[] args) {
		GameInfoRepository giRepo = new GameInfoRepository();
		GameInfoDTO gameInfo = new GameInfoDTO();
		gameInfo.setGiName("김기믹미");
		gameInfo.setGiPrice(1000);
		gameInfo.setGiGenre("rpg");
		gameInfo.setGiDesc("재밌다");
//		List<GameInfoDTO> gameInfos = giRepo.selectGameInfos(gameInfo);
//		for(GameInfoDTO gameInfoo: gameInfos) {
//			System.out.println(gameInfoo);
//		}
		
	}
}
