package com.cn.pojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/29  16:17
 * @Version 1.0
 * @Param $
 * @return $
 */
public class Answer {
	private int COLUMN_NUMBER =5;
	private ArrayList<Integer> answer;
	private int index;

	public ArrayList<Integer> getAnswer() {
		return answer;
	}

	public void setAnswer(ArrayList<Integer> answer) {
		this.answer = answer;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * 
	 */
	public Answer() {
		// TODO Auto-generated constructor stub
		answer = new ArrayList<Integer>();
		index = 0;
	}

	public void writeAnswerToFile(String fileName) {
		File exFile = new File(fileName);
		System.out.println(exFile);
		Writer out = null;
		try {
			out = new FileWriter(exFile, false);
			System.out.println(answer);
			int count =0;
			for(Integer i:answer) {
				count++;
				out.write(i + ",");
				//System.out.println("answer"+"I"+i);
				if(count%COLUMN_NUMBER==0 && count!=0){
					out.write(System.lineSeparator());
				}
			}

			out.flush();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//out.close();
		}
	}
	
	public void readAnswerFromFile(String fileName) {
		File exFile = new File(fileName);
		System.out.println("-----------------");
		System.out.println(exFile);
		String a;
		Scanner in = null;
		answer.clear();
		try {
			in = new Scanner(exFile);
			in.useDelimiter(",");
			while(in.hasNext()) {
				a = in.next().replaceAll("\\s", "");
				answer.add(Integer.parseInt(a));
			}
			//System.out.println(getAnswer());
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			in.close();
		}
	}
	
	public void scanAnswerFromKeyboard(int count) {
		Scanner sc = new Scanner(System.in);
		answer.clear();
		System.out.println("请按照题目序号依次输入答案后回车");
		for(int i = 1; i <= count; i++) {
			System.out.print("("+i+")");
			answer.add(sc.nextInt());
		}
		sc.close();
	}
	
	public void reset() {
		index = 0;
	}
	public boolean add(int a) {
		return answer.add(a);
	}
	public boolean hasNext() {
		return index < answer.size();
	}
	public int next() {
		if(index<answer.size()) {
			return answer.get(index++);
		}
		else {
			return -1;
		}
	}
	
	public int get(int index) {
		return answer.get(index);
	}

	public void set(int index, int x) {
		answer.set(index, x);
	}
}
