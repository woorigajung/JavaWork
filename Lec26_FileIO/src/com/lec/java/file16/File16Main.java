package com.lec.java.file16;

import java.io.File;
import java.io.IOException;

public class File16Main {

	public static final String TEST_DIRECTORY = "test";	// 디렉토리 다룰 때 사용
	public static final String TEMP_DIR = "temp";
	public static final String TEST_FILE = "dummy.txt";	// 파일 다룰 때 사용
	public static final String TEST_RENAME = "re_dummy.txt";
	
	public static void main(String[] args) {
		System.out.println("폴더/파일 생성, 이름변경, 삭제");
		System.out.println();
		String path = System.getProperty("user.dir")
				+ File.separator
				+ TEST_DIRECTORY;	// "test"
		System.out.println("절대경로: " + path);
		
		// File 객체 생성. ---> 디스크에 물리적인 파일/ 디렉토리가 만들어진것은 아니다!
		File f = new File(path);
		
		System.out.println();
		// 폴더 생성: mkdir()
		if(!f.exists()) {	// 디렉토리가 존재하는지 체크  //물리적으로도 동작하는지 확인
			// 디렉토리가 존재하지 않는다면 생성!
			if(f.mkdir()) {
				System.out.println("폴더생성성공!");
			} else {
				System.out.println("폴더생성실패");
			}
		} else {
			System.out.println("폴더가 이미 존재합니다.");
		}
		
		
		System.out.println();
		// 파일 생성 : createNewFile()
		File f2 = new File(f,TEST_FILE );	// 디렉토리표현 파일 첫번째(test라는 폴더)
											// 두번째 TEST_FILE = "dummy.txt"
											// "test/dummy.txt"
		System.out.println("절대경로: " + f2.getAbsolutePath());
		System.out.println();
		if(!f2.exists()) {	// 파일이 존재하는지 체크
			// 파일이 존재하지 않으면 생성
			try {
				if(f2.createNewFile()) {
					System.out.println("폴더생성성공!");
				}else {
					System.out.println("폴더생성실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		} else {
			// 파일이 존재한다면 생성
			System.out.println("파일이 이미 존재합니다.");
		}
		
		System.out.println();
		// 파일 이름 변경: renameTo()
		// renameTo()를 이용해서 다른 폴더로 이동(move)를 할 수도 있다.
		File f3 = new File(f, TEST_RENAME);	// "text/re_dummy.txt"	바꿀려고 하는 주소
											// 이미 존재하면 바꿀 수 없다.
		System.out.println(f3.getAbsoluteFile());
		
		if(f2.exists()) { // "text/dummy.txt" 가 존재하는지 체크
			// 변경 
			
			if(f2.renameTo(f3)) {
				System.out.println("파일 이름 변경 성공!");
			} else {
				System.out.println("변경할 파일이 없습니다.");
			}
			
		} else {
			System.out.println("변경할 파일이 없습니다.");	// 이미 "re_dummy.txt" 가 있었으면 실패한다.
		}
		
		System.out.println();
		// 파일 삭제: delete()
		File f4 = new File(f,TEST_RENAME);	// "re_dummy.txt"
		if(f4.exists()) {
			// 파일이 존재하면 삭제
			if(f4.delete()) {
				System.out.println("파일 삭제 성공!");
			} else {
				System.out.println("파일 삭제 실패!");
			}
		} else {
			System.out.println("삭제할 파일이 없습니다.");
		}
		
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class














