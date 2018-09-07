package dao;

public class BoardDaoImpl implements BoardDao {
	//singleton 패턴 적용 
	
	//1. 생성자를 private으로 해서 다른 곳에서 new를 이용한 인스턴스 생성을 못하게 합니다. 
	private BoardDaoImpl() {
		
	}
	
	//2. 자신의 인스턴스를 저장할 수 있는 static 인스턴스 변수 만들기
	private static  BoardDao boardDao; 
	
	//3. 인스턴스 하나만 생성할 수 있는 static 메소드를 생성
	public static BoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}

}
