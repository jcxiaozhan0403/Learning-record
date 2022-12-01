package com.cn.pojo;
import java.util.Random;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/29  16:17
 * @Version 1.0
 * @Param $
 * @return $
 */
public abstract class Equation {
	private final int MAX = 100;
	private final int MIN = 0;
	//private final int COUNT = 50;
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public char getOp() {
		return op;
	}

	public void setOp(char op) {
		this.op = op;
	}

	private int left, right, result;
	private char op;

	/**
	 * 
	 */
	public Equation() {
		// TODO Auto-generated constructor stub

	}
	
	private int generateRandom(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	private boolean isBetween(int value, int min, int max) {
		return value >= min && value <= max;
	}
	
	protected abstract int calculate();
	
	public boolean isEqual(Equation e) {
		boolean b = false;
		if(e.getOp() != this.getOp()) {
			b = false;
		}
		else {
			b = e.getLeft() == this.getLeft() && e.getRight() == this.getRight();
		}
		return b;
	}

	public String toString() {
		return "" + this.getLeft() + this.getOp() + this.getRight();
	}
	public String toString2() {
		return toString()+"=";
	}
	public String toString3() {
		return toString2()+this.getResult();
	}
	
	public void generateEquation(char op) {
		do {
			left = generateRandom(MIN, MAX);
			right = generateRandom(MIN, MAX);
			result = calculate();
		}while(!isBetween(result, MIN, MAX));
		this.setOp(op);
	}
	
}
