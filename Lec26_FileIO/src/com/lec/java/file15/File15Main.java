package com.lec.java.file15;

import java.io.File;

public class File15Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재 작업 폴더 : " + curWorkingDir);
		
		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		File curDir = new File(curWorkingDir);	// 현재 작업 디렉토리 객체		( 들어가면 파일 + 폴더 총 7개)
		File[] list = curDir.listFiles(); // listFiles() : 디렉토리 안에 있는 '파일' 과 '디렉토리' 를 File 배열로 리턴
		System.out.println(list.length);	// '파일' 과 '디렉토리'의 개수
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {
				// isDirectory(): File 객체가 디렉토리이면 true 리턴
				// isFile(): File 객체가 파일이면 true 리턴
				System.out.print("DIR\t");
			}else {
				System.out.print("FILE\t");
			}
			System.out.print(list[i].getName() + "\t");	// 파일과 디렉토리 이름 출력
			System.out.println(list[i].length());	// length() '파일'의 크기(byte)
		}										// '디렉토리' 인 경우는 의미 없다.

		System.out.println();
		// 디렉토리의 내용 출력, enhanced for 문 이용
		// File tempDir = new File("temp");	// 생성자에 들어온 디렉토리나 파일 값을 찾는다
							// '상대경로'	이용한 객체 생성	// 현재 작업경로 밑에 있는 temp 검색
		// '절대경로(absolute path)' 를 이용한 FIle 객체 생성
		String tempDirPath = System.getProperty("user.dir")
		+ File.separator		// 윈도우(\), LINUX, MAC(/)
		+ "temp";
		//C:\Users\82102\Desktop\Java_JJH\Dropbox\Java29\JavaWork\Lec26_FileIO\temp
		System.out.println("절대경로 " + tempDirPath);
		File tempDir = new File(tempDirPath);
		
		File [] list2 = tempDir.listFiles();
		for(File f : list2) {
			if(f.isDirectory()) {
				System.out.print("DIR\t");
			}else {
				System.out.print("FILE\t");
			}
			System.out.print(f.getName() + "\t");
			System.out.println(f.length());
		}
		
		
		System.out.println();
		String path = "dummy.txt";	// 상대경로
		File f = new File(path);	// 새로운 파일 객체 생성
			// ★ File 객체를 생성(new) 했다고 해서
			// 물리적인 파일/디렉토리가 만들어지는게 아니다!~~~~~~~~~
			// 자바에 객체가 만들어진 것
		System.out.println("파일이름 : " + f.getName());
		System.out.println("절대경로 : " + f.getAbsolutePath());
		System.out.println("있냐?: " + f.exists());	// 물리적으로 동작하냐?
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end File11Main

















