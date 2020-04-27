package com.lec.java.file08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* Object Filter Stream		// 내가만든 객체를 파일로 저장할 때 사용
 Program <=== ObjectInputStream <=== FileInputStream <=== File
 Program ===> ObjectOutputStream ===> FileOutputStream ===> File

java.lang.Object
 └─ java.io.OutputStream
    └─ java.io.ObjectOutputStream
 
java.lang.Object
 └─ java.io.InputStream
     └─ java.io.ObjectInputStream


 Object Stream: 객체의 입출력을 위한 스트림
 사용법은 다른 Filter Stream(Buffered I/O, Data I/O)과 비슷	족보상으로는 Filter Stream이 아니다
 Object 스트림의 입출력 대상이 되는 클래스는 @@@반드시@@@ Serializable 인터페이스를 구현
 클래스의 일부 멤버 변수를 직렬화(Serialization)의 대상에서 제외시키려면,
 transient 키워드를 사용
*/
public class File08Main {
	
	public static final String FILEPATH  = "temp/member.dat";

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");
		
		try(
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				
				InputStream in = new FileInputStream(FILEPATH);
				ObjectInputStream oin = new ObjectInputStream(in);
				
				) {
			
			Member m1 = new Member("root", "root1234");
			Member m2 = new Member("guest", "guest");
			Member m3 = new Member("admin", "admin123456");
			
			oout.writeObject(m1);
			oout.writeObject(m2);
			oout.writeObject(m3);
			
			// 파일에서 Object 타입으로 읽기
			Member dataRead;
			
			// 단순 무식한 방법 
			// 읽는 방법1: 매번 readObject()호출
//			dataRead = (Member)oin.readObject();	// object를 리턴하기 때문에 Member로 캐스팅
//			dataRead.displayInfo();					// 읽어드릴 때는 기본 그순서 그대로 읽어짐 
//			dataRead = (Member)oin.readObject();	
//			dataRead.displayInfo();
//			dataRead = (Member)oin.readObject();				
//			dataRead.displayInfo();
			
			// 몇개 있는지 모를 때는 어떻게??
			// 읽는 방법2 : 무한루프로 readObject() 호출..
			// 다 읽으면 EOFException 으로 잡기
			// EOF  End Of File
			while(true) {
				dataRead = (Member)oin.readObject();
				dataRead.displayInfo();
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) { 
			System.out.println("파일 끝까지 읽었습니다.");
		} catch (IOException e) {	// EOFE 예외는 IOE 예외 자식이기
			e.printStackTrace();	// 때문에 이 문장 밑으로는 못오고 위에 부분에서 캐치한다
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















