package service;

import dao.BoardDao;
import dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao;
	//singleton 패턴 적용 
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance(); 
	}
	
	private static BoardService boardService;
	
	public static BoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
}
