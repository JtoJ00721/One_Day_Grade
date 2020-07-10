package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class ScoreServiceImplV1 implements ScoreService {

	protected List<ScoreVO> scoreList;

	public ScoreServiceImplV1() {
		scoreList = new ArrayList<ScoreVO>();
	}

	@Override
	public void inputScore() {
		String scoreFile = "src/com/biz/grade/exec/data/score.txt";
		Scanner scan = new Scanner(System.in);

		try {
			FileReader fileReader = new FileReader(scoreFile);
			BufferedReader buffer = new BufferedReader(fileReader);
			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}
			}
			buffer.close();
			fileReader.close();
		} catch (FileNotFoundException e1) {
			System.out.println(scoreFile + "파일을 불러오는중 문제 ☆발생☆");
		} catch (NumberFormatException e) {
			System.out.println("파일내용을 숫자로 바꾸던 중 문제 ☆발생☆");
		} catch (IOException e) {
			System.out.println("버퍼로부터 데이터를 읽는데 문제 ☆발생☆");
		}

		while (true) {
			ScoreVO scoreVO = new ScoreVO();
			System.out.println("학번을 입력하세요(숫자만) (입력 중지 코드 >>pass<<)");
			System.out.print(">>");
			String strScoreNum = scan.nextLine();
			if (strScoreNum.equals("pass")) {
				break;
			}
			int intScoreNum = 0;
			try {
				intScoreNum = Integer.valueOf(strScoreNum);
			} catch (Exception e) {
				System.out.println("학번은 숫자만 입력해 주세요 ><\n다시 입력해 주세요.");
				continue;
			}
			scoreVO.setScoreNum(strScoreNum);

			System.out.println("국어점수를 입력하세요(숫자만)");
			System.out.print(">>");
			String strKor = scan.nextLine();
			int intKor = 0;
			try {
				intKor = Integer.valueOf(strKor);
			} catch (Exception e) {
				System.out.println("점수는 숫자만 입력해 주세요 ><\n다시 입력해 주세요.");
				continue;
			}
			if (intKor > 100 || intKor < 0) {
				System.out.println("점수는 0 ~ 100 사이의 숫자만 가능합니다 ><\n다시 입력해 주세요.");
				continue;
			}
			scoreVO.setKor(intKor);

			System.out.println("영어점수를 입력하세요(숫자만)");
			System.out.print(">>");
			String strEng = scan.nextLine();
			int intEng = 0;
			try {
				intEng = Integer.valueOf(strEng);
			} catch (Exception e) {
				System.out.println("점수는 숫자만 입력해 주세요 ><\n다시 입력해 주세요.");
				continue;
			}
			if (intEng > 100 || intEng < 0) {
				System.out.println("점수는 0 ~ 100 사이의 숫자만 가능합니다 ><\n다시 입력해 주세요.");
				continue;
			}
			scoreVO.setEng(intEng);

			System.out.println("수학점수를 입력하세요(숫자만)");
			System.out.print(">>");
			String strMath = scan.nextLine();
			int intMath = 0;
			try {
				intMath = Integer.valueOf(strMath);
			} catch (Exception e) {
				System.out.println("점수는 숫자만 입력해 주세요 ><\n다시 입력해 주세요.");
				continue;
			}
			if (intMath > 100 || intMath < 0) {
				System.out.println("점수는 0 ~ 100 사이의 숫자만 가능합니다 ><\n다시 입력해 주세요.");
				continue;
			}
			scoreVO.setMath(intMath);

			System.out.println("음악점수를 입력하세요(숫자만)");
			System.out.print(">>");
			String strMusic = scan.nextLine();
			int intMusic = 0;
			try {
				intMusic = Integer.valueOf(strMusic);
			} catch (Exception e) {
				System.out.println("점수는 숫자만 입력해 주세요 ><\n다시 입력해 주세요.");
				continue;
			}
			if (intMusic > 100 || intMusic < 0) {
				System.out.println("점수는 0 ~ 100 사이의 숫자만 가능합니다 ><\n다시 입력해 주세요.");
				continue;
			}
			scoreVO.setMusic(intMusic);

			int sum = 0;
			sum += scoreVO.getKor();
			sum += scoreVO.getEng();
			sum += scoreVO.getMath();
			sum += scoreVO.getMusic();
			scoreVO.setSum(sum);

			int avg = 0;
			avg = scoreVO.getSum() / 4;
			scoreVO.setAvg(avg);

			scoreList.add(scoreVO);
		}

	}

	@Override
	public void scoreList() {
		
		int allKor = 0;
		int allEng = 0;
		int allMath = 0;
		int allMusic = 0;
		
		int avgKor = 0;
		int avgEng = 0;
		int avgMath = 0;
		int avgMusic = 0;
		
		System.out.println("==========================================================================================");
		System.out.println("\t\t\t성적리스트");
		System.out.println("==========================================================================================");
		System.out.println("학번\t이름\t국어\t영어\t수학\t음악\t총점\t평균");
		System.out.println("------------------------------------------------------------------------------------------");


		int size = scoreList.size();

		for (ScoreVO sVO : scoreList) {
			System.out.print(sVO.getScoreNum() + "\t");
			System.out.print(sVO.getScoreNum() + "\t");
			System.out.print(sVO.getKor() + "\t");
			System.out.print(sVO.getEng() + "\t");
			System.out.print(sVO.getMath() + "\t");
			System.out.print(sVO.getMusic() + "\t");
			System.out.print(sVO.getSum() + "\t");
			System.out.println(sVO.getAvg() + "\t");

			allKor += sVO.getKor();
			allEng += sVO.getEng();
			allMath += sVO.getMath();
			allMusic += sVO.getMusic();
		}
		
		avgKor = allKor / size;
		avgEng = allEng / size;
		avgMath = allMath / size;
		avgMusic = allMusic / size;
		
		if(allKor == 0) {
			avgKor = 0;
		}
		if(allEng == 0) {
			avgEng = 0;
		}
		if(allMath == 0) {
			avgMusic = 0;
		}
		if(allMusic == 0) {
			avgMusic = 0;
		}

		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.printf("과목총점\t국어:%d \t영어:%d \t수학:%d \t음악:%d \n", allKor, allEng, allMath, allMusic);
		System.out.printf("과목평균\t국어:%d \t영어:%d \t수학:%d \t음악:%d \n", avgKor, avgEng, avgMath, avgMusic);

		System.out.println("==========================================================================================");

	}

}
