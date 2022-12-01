/**
 * 
 */
package com.cn.pojo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

import com.cn.Exercise;
import com.cn.file.*;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/29  16:17
 * @Version 1.0
 * @Param $
 * @return $
 */
public class Parents {
	private String path;
	private String[] fileName;
	private int count;
	private int n;
	private Scanner sc;
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public int getCount() {
		return count;
	}

	private ExerciseFileDAO eDAO;

	/**
	 * 
	 */

	public Parents() {
		// TODO Auto-generated constructor stub
		path = "D://csv/";
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		eDAO = new ExerciseFileDAO();
	}
	
	public Parents(int count, int n){
		this();
		this.count = count;
		this.n = n;
	}
	
	public void writeExercisesToFiles(){
		Exercise ex = new Exercise(count);
		for(int i = 0; i < n; i++){
			String fileName = "D://csv/exercise_mix_" + count + "_" + i + ".csv";
			ex.generateExercise();
			eDAO.writeExerciseToFile(ex, fileName);
		}
	}
	
	public void writeAddExercisesToFiles(){
		Exercise ex = new Exercise(count);
		for(int i = 0; i < n; i++){
			String fileName = "D://csv/exercise_add_" + count + "_" + i + ".csv";
			ex.generateAddExercise();
			eDAO.writeExerciseToFile(ex, fileName);
		}
	}
	
	public void writeSubExercisesToFiles(){
		Exercise ex = new Exercise(count);
		for(int i = 0; i < n; i++){
			String fileName = "D://csv/exercise_sub_" + count + "_" + i + ".csv";
			ex.generateSubExercise();
			eDAO.writeExerciseToFile(ex, fileName);
			//System.out.println(ex);
		}
	}
	private void setFileName(){
		File file = new File(path);
		FileFilter filter = new FileFilter();
		fileName = file.list(filter);
	}

	public void check(){
		int cloNum = 5;
		check(cloNum);
	}
	
	public void check(int cloNum){
		setFileName();
		int count =0;
		int indexes = 1;//下标
		int i = 1;
		if(fileName.length <= 0){
			System.out.println("******没有需要批改的习题！******");
			return;
		}
		for(String s: fileName){
			System.out.println(i++ + ": " + s);
		}
		System.out.println("******请选择需要批改的习题序号，回车继续******");

		int index = sc.nextInt();

		Exercise exercise = new Exercise(0);
		exercise = eDAO.readExerciseFromFile(path + fileName[index - 1]);
		Answer answer = new Answer();



		//遍历
		System.out.println("size"+exercise.size());
		for(int j=0;j<exercise.size();j++){
			if(j%cloNum==0 && count!=0){
				System.out.print("\n");
			}
			System.out.print(String.format("%-2d",(indexes))+ "." +String.format("%4s",exercise.get(j).asString())+" "+String.format("%12s",(""))+"\t");
			indexes++;
			count++;
		}
		System.out.println();
		
		//answer.scanAnswerFromKeyboard(exercise.size());
		int n = exercise.size();
		System.out.println("******请根据序号提示依次输入答案后回车******");
		int indexCount =0;
		for(i = 0; i < n; i++){
			indexCount = i+1;
			System.out.print("("+indexCount+")"+exercise.get(i).asString());
			answer.add(sc.nextInt());
		}
		
		//sc.close();

		answer.writeAnswerToFile(path + fileName[index - 1].replaceAll("exercise", "answer"));
		Check check = new Check();
		check.check(exercise, answer);
		check.writeCheckToFile(path + fileName[index - 1].replaceAll("exercise", "check"));
		check.printCheck();
	}
	
	class FileFilter implements FilenameFilter{
		//private String type;
		public FileFilter(){
			//this.type = type;
		}
		
		public boolean accept(File dir, String name){
			return name.matches("[e][x][e][r][c][i][s][e]\\w*[.][c][s][v]");
		}
	}

}
