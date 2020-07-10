package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.StudentVO;

public class StudentServiceImplV1 implements StudentService {

	protected List<StudentVO> stuList;

	public StudentServiceImplV1() {
		stuList = new ArrayList<StudentVO>();
	}

	@Override
	public void inputStudent() {
		String studentFile = "src/com/biz/grade/exec/data/student.txt";
		Scanner scan = new Scanner(System.in);

		try {
			FileReader fileReader = new FileReader(studentFile);
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
			System.out.println(studentFile + "파일을 불러오는 중 문제 ☆발생☆");
		} catch (NumberFormatException e) {
			System.out.println("파일 내용을 숫자로 바꾸는 과정에서 문제 ☆발생☆");
		} catch (IOException e) {
			System.out.println("버퍼로부터 데이터를 읽는데 문제 ☆발생☆");
		}

		while (true) {
			StudentVO studentVO = new StudentVO();
			System.out.println("학번을 입력해 주세요(숫자만) (입력 멈추기 코드 >>pass<<)");
			System.out.print(">>");
			String strStuNum = scan.nextLine();
			if (strStuNum.equals("pass")) {
				break;
			}
			int intStuNnum = 0;
			try {
				intStuNnum = Integer.valueOf(strStuNum);
			} catch (Exception e) {
				System.out.println("학번은 숫자만 입력해 주세요 ><\n다시 입력해 주세요.");
				continue;
			}

			studentVO.setStudentNum(strStuNum);
			System.out.println();

			System.out.println("이름을 입력해 주세요");
			System.out.print(">>");
			String strName = scan.nextLine();
			studentVO.setName(strName);
			System.out.println();

			System.out.println("학과를 입력해 주세요");
			System.out.print(">>");
			String strDept = scan.nextLine();
			studentVO.setDept(strDept);

			System.out.println("학년을 입력해 주세요(숫자 1 ~ 4)");
			System.out.print(">>");
			String strGrade = scan.nextLine();
			int intGrade = 0;
			try {
				intGrade = Integer.valueOf(strGrade);
			} catch (Exception e) {
				System.out.println("학년은 숫자만 입력해야 합니다 ><\n다시 입력해 주세요.");
				continue;
			}
			if (intGrade > 4 || intGrade < 1) {
				System.out.println("학년은 1 ~ 4 사이의 값만 입력해야 합니다 ><\n다시 입력해 주세요.");
				continue;
			}
			studentVO.setGrade(intGrade);
			System.out.println();

			System.out.println("전화번호를 입력해 주세요(숫자만)");
			System.out.print(">>");
			String strTel = scan.nextLine();
			long longTel = 0;
			try {
				longTel = Long.valueOf(strTel);
			} catch (Exception e) {
				System.out.println("전화번호는 숫자만 입력해 주세요 ><\n다시 입력해 주세요.");
				continue;
			}
			studentVO.setTel(strTel);

			stuList.add(studentVO);
		}

	}
	
	@Override
	public List<StudentVO> getList() {
		return stuList;
	}

}
