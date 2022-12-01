package com.cn.file;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cn.*;
import javafx.scene.Parent;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/29  16:17
 * @Version 1.0
 * @Param $
 * @return $
 */
public class ExerciseFileDAO extends ExerciseSheet {
	/**
	 * 
	 */
	public ExerciseFileDAO() {
		// TODO Auto-generated constructor stub
	}
	public void CreateExerciseToFile(String fileName)  {
		File file = new File(fileName);
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public void writeExerciseToFile(Exercise e,String fileName) {
		//System.out.println("执行了");
		File exFile = new File(fileName);
		//System.out.println(exFile);
		//System.out.println(e.getExercise());
		//Writer out;
		//OutputStreamWriter out;
		//Equation equation;
		//OutputStream out;
		BufferedWriter out;
		try {
			//false 能覆盖之前的数据，true不能覆盖之前的数据只能追加写入
			//out = new FileWriter(exFile, false);
			//out = new BufferedWriter(fileOut,"UTF-8");

			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(exFile,true),"UTF-8"));
			int count =0;
			for(int i = 0; i < e.getCount(); i++) {
				count++;
				BinaryOperation equation = e.getExercise().get(i);
				out.write(equation.toCsV()+ ",");
				//System.out.println(equation.toString());
				//5列
				if(count%COLUMN_NUMBER==0 && count!=0){
					out.write(System.lineSeparator());
				}


			}
			//另一种遍历方式
			/*while(e.hasNext()) {
				out.write(e.next().toString() + ",");
				System.out.println(e.next().toString());
			}*/

			out.flush();
			out.close();
		}catch(IOException ex) {
			System.out.println("ERROR" + ex);
		}

	}
	
	public Exercise readExerciseFromFile(String fileName) {
		File exFile = new File(fileName);
		Exercise exercise = new Exercise();
		System.out.println(exFile);
		String equation;
		Scanner in = null;
		Scanner value =null;
		int count =0;
		try {
			in = new Scanner(exFile,"UTF-8");
			if(!in.hasNextLine()){
				in = new Scanner(exFile,"GBK");
				System.out.println("执行GBK");
			}

			while(in.hasNextLine()) {
				//System.out.println("执行1");

				value = new Scanner(in.nextLine());
				value.useDelimiter(",");
				//value.useDelimiter("[!\u4e00-\u9fa5]");
                while (value.hasNext()){
					//System.out.println("执行");
					count++;//  //[^0-9][^0-9][^\+\-][^0-9][^0-9]   [^\d+-]+ @\"^(((?)([-+*/][0-9]+)*)+($|[-+*/]))*(?(o)(?!))$"
					String str ="[^\\d+-]+";//将所有的特殊字符，除了数字和+-以外的都替换成""  [\\u4e00-\\u9fa5]
					equation = value.next().replaceAll(str,"");
					/*String test = "温度11111";
					String reg = "[\u4e00-\u9fa5]";
					Pattern pat = Pattern.compile(reg);
					Matcher mat = pat.matcher(equation);*/



					//System.out.println("test"+mat.replaceAll(""));
					if(equation.contains("+")) {
						exercise.add(new AdditionOperation(equation));
						//System.out.println("equation"+equation);
						//System.out.println();
					}
					else {
						exercise.add(new SubstractOperation(equation));

					}


				}


			}
			//System.out.println("count"+count);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			in.close();
		}
		//System.out.println("count"+exercise.getCount());
		return exercise;
	}

}
