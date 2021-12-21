package edu.java.jdbc05;

import java.util.List;

// MVC 아키텍쳐에서 Controller를 구현하는 클래스
public class BlogDaoImpl implements BlogDao {

	// Singleton 패턴
	
	// Oracle JDBC를 사용
	@Override
	public List<Blog> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog select(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

}