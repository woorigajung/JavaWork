package com.lec.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.naming.ldap.StartTlsRequest;
import javax.xml.stream.events.StartDocument;

/* FileIO
 * ~~~ Stream으로 끝나면 byte 단위로 동작
 Program <=== InputStream <=== Source
 Program <=== FileInputStream <=== File
 
 Program ===> OutputStream ===> Source
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는 통로
*/

public class File02Main {

	public static void main(String[] args) {
		System.out.println("File IO");

		InputStream in = null; // InputStream 변수 선언
		OutputStream out = null; // OutputStream 변수 선언
		
		try {
			// FileInputStream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt");
									// 읽을 때 이 부분이 없으면 FileNotFoundException
			// FileOutputStream 인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.txt");
				// 위 파일이 없으면 새로생성
				// 		    있으면 기존 파일 삭제 후 새로 생성
			
			int dataRead;
			int bytesCopied = 0;
			
			
			long startTime = System.currentTimeMillis();
			// 파일복사 : 읽기 -> 쓰기
			while(true) {
				// 데이터 읽기: InputStream에 있는 read() 메소드 사용
				// read()는 InputStream 으로부터 
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
				// [ ... ][ ... ][ ... ][ 1byte ]
				// 장치간 주고 받을려면 여러가지 컨트롤 신호(부가정보)필요 따라서
				// 여유공간을 주기위해 3byte추가해 받는 것이다.
				dataRead = in.read();
				if(dataRead == -1 ) {	// 더 이상 읽을 것이 없으면 read() 는 -1 리턴
					break;

				}
				
				// 데이터 쓰기: OutputStream에 있는 write() 메소드 사용
				// write() 는 
				// int(4byte)에 1byte씩 담아 OutputStream에 쓴다
				// [ ... ][ ... ][ ... ][ 1byte ]
				out.write(dataRead);
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
				if(out != null) out.close();	// out값이 null일 경우 nullPointException
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class

