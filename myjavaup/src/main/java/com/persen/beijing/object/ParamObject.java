package com.persen.beijing.object;

/**
 * Created by persen on 2016/11/9.
 */


public class ParamObject {


	static public void main(String[] args) {
		Param pp = null;
		test tt = new test();
		tt.func(pp);
		System.out.print(pp);
	}


}

class test {
	public void func(Param pp) {
		pp = new Param();
	}
}

class Param {
	int i = 0;
}