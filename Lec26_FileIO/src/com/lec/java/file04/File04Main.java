package com.lec.java.file04;
/* 보조스트림 (filter stream)
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in = null; // InputStream 변수 선언
		BufferedInputStream bin = null;
		OutputStream out = null; // OutputStream 변수 선언
		BufferedOutputStream bout = null;
		
		try {
			// FileInputStream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in);	// 장착!
			
			// FileOutputStream 인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.txt");
				// 위 파일이 없으면 새로생성
				// 		    있으면 긱존 파일 삭제 후 새로 생성
			bout = new BufferedOutputStream(out);	// 장착!
			
			int dataRead;
			int bytesCopied = 0;
			
			
			long startTime = System.currentTimeMillis();
			// 파일복사 : 읽기 -> 쓰기
			while(true) {
				dataRead = bin.read();
				if(dataRead == -1 ) {	
					break;

				}
				bout.write(dataRead);
				bytesCopied++;
			}
			
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			
			System.out.println("읽고 쓴 바이트: " + bytesCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제 
			try {
				if(bout != null) out.close();	// out값이 null일 경우 nullPointException
				if(bin != null) in.close();
				// bin을 close 하면, bin 을 만든 in도 같이 close 됨
				// bout을 close 하면, bout 을 만든 out도같이 close 됨
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














