package edu.java.lotto01;

import java.util.List;

public class LottoDaoImpl implements LottoDao {

	private List<Lotto> lottos;
	
	private static LottoDaoImpl instance = null;
	static LottoDaoImpl getInstance() {
		if (instance == null) {
			instance = new LottoDaoImpl();
		}
		return instance;
	}
	@Override
	public List<Lotto> select() {
		return lottos;
	}

	@Override
	public Lotto select(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Lotto L) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int auto(int index, Lotto lotto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
