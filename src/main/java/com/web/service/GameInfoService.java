package com.web.service;

import java.util.List;

import com.web.dto.GameInfoDTO;
import com.web.dto.UserInfoDTO;
import com.web.repository.GameInfoRepository;

public class GameInfoService {
	private GameInfoRepository giRepo = new GameInfoRepository();

	public List<GameInfoDTO> getGameInfos(GameInfoDTO gameInfo) {
		return giRepo.selectGameInfos(gameInfo);
	}

	public GameInfoDTO getGameInfo(int giNum) {
		return giRepo.selectGameInfo(giNum);
	}

	public int insertGameInfo(GameInfoDTO gameInfo) {
		return giRepo.insertGameInfo(gameInfo);
	}

	public int updateGameInfo(GameInfoDTO gameInfo) {
		return giRepo.updateGameInfo(gameInfo);
	}

	public int deleteGameInfo(int giNum) {
		return giRepo.deleteGameInfo(giNum);
	}

	public static void main(String[] args) {
		GameInfoService giService = new GameInfoService();
		List<GameInfoDTO> gameInfos = giService.getGameInfos(null);
		for (GameInfoDTO gameInfo : gameInfos) {
			System.out.println(gameInfo);
		}
		GameInfoDTO gameInfo = giService.getGameInfo(2);
		System.out.println(gameInfo);
	}
}
