package edu.java.lotto01;

import java.util.List;

public interface LottoDao {

	List<Lotto> select();
	
	Lotto select(int index);
	
	int insert(Lotto L);
	
	int auto(int index, Lotto lotto);
}
