package com.cn.pojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import com.cn.Exercise;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/29  16:17
 * @Version 1.0
 * @Param $
 * @return $
 */
public class Check {
	private int count;
	private int right;
	private int wrong;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getWrong() {
		return wrong;
	}

	public void setWrong(int wrong) {
		this.wrong = wrong;
	}

	/**
	 * 
	 */
	public Check() {
		// TODO Auto-generated constructor stub
		right = 0;
		wrong = 0;
	}
	
	public void check(Exercise ex, Answer an) {
		count = ex.size();
		int wrong = 0, right = 0;
		ex.setIndex(0);
		an.reset();
		while(ex.hasNext()) {
			if(ex.next().getResult() == an.next()) {
				right++;
			}
			else {
				wrong++;
			}
			
		}
		setRight(right);
		setWrong(wrong);
	}
	
	public void writeCheckToFile(String fileName) {
		File exFile = new File(fileName);
		Writer out;
		try {
			out = new FileWriter(exFile, true);
			out.write("算式总数:" + count + ";\r\n");
			out.write("正确：" + right + ";\r\n");
			out.write("错误：" + wrong + ";\r\n");
			out.flush();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printCheck() {
		System.out.println("本次练习批改结果：");
		System.out.println("算式总数：" + count);
		System.out.println("正确：" + right);
		System.out.println("错误：" + wrong);
	}

}
