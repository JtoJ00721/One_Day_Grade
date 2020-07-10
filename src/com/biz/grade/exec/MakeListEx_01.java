package com.biz.grade.exec;

import java.util.Scanner;

import com.biz.grade.service.ScoreServiceImplV1;
import com.biz.grade.service.StudentServiceImplV1;

public class MakeListEx_01 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StudentServiceImplV1 stuServ = new StudentServiceImplV1();
		ScoreServiceImplV1 scoreServ = new ScoreServiceImplV1();

		while (true) {
			System.out.println("=======================================");
			System.out.println("성적표표 관리 프로그램 V1");
			System.out.println("=======================================\n");
			System.out.println("학생정보처리 실행 코드 >>1<<");
			System.out.println("점수정보처리 실행 코드 >>2<<");
			System.out.println("점수리스트 출력 실행 코드 >>3<<");
			System.out.println("프로그램 종료 코드 >>4<<\n");
			System.out.println("원하는 작업을 선택하세요");
			System.out.print(">>");
			String whatToDo = scan.nextLine();
			int intwhat = 0;
			try {
				intwhat = Integer.valueOf(whatToDo);
			} catch (Exception e) {
				System.out.println("원하시는 작업을 숫자 1, 2, 3, 4 으로 입력해 주세요 ><");
				continue;
			}
			if (intwhat > 4 || intwhat < 1) {
				System.out.println("1또는 2또는 3 또는 4만 입력해주세요 ><!!!");
				continue;
			}
			if (intwhat == 1) {
				stuServ.inputStudent();
			}
			if (intwhat == 2) {
				scoreServ.inputScore();
			}
			if (intwhat == 3) {
				scoreServ.scoreList();
			}
			if (intwhat == 4) {
				System.out.println("\n\n종료지롱 ><\n\n");
				break;
			}

		}

	}
}
