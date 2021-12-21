package edu.java.lotto01;

import java.util.Date;

public class Lotto {

private int lottonum;
private String autonum;

public Lotto() {}


public Lotto(int lottonum, String autonum) {
	
	this.lottonum = lottonum;
	this.autonum = autonum;
}


public int getLottonum() {
	return lottonum;
}


public void setLottonum(int lottonum) {
	this.lottonum = lottonum;
}


public String getAutonum() {
	return autonum;
}


public void setAutonum(String autonum) {
	this.autonum = autonum;
}


@Override
public String toString() {
	return "Lotto [자동번호=" + lottonum + ", 수동번호=" + autonum + "]";
}

}
