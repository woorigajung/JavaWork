package com.lec.java.thread01;

/*	쓰레드 Thread
 *  동일 프로세스 내에 '독립'적인 다중 수행하는 프로그램 단위
 *  병행성 증진. 	처리율 향상	, 응답속도 향상 목적
 * 			  ex_파일 다운로드
 *  자바에서 쓰레드를 만들어서 사용하는 방법1:
 *   1. Thread 클래스를 상속받는 클래스를 정의
 *   2. 정의한 클래스에서 run() 메소드를 override - 쓰레드에서 할 일을 구현
 *   3. Thread 클래스의 인스턴스를 생성
 *   4. 생성된 인스턴스에서 start() 메소드를 호출
 */


public class Thread01Main {

	public static void main(String[] args) {
		// main Thread는 항상 시작할 때 생성
		System.out.println("쓰레드 생성 1");

		// 3. Thread 클래스의 인스턴스를 생성
		Thread th1 = new MyThread("Hello Java");
		Thread th2 = new MyThread("안녕하세요~");
		
		// 4. 생성된 인스턴스에서 start() 메소드를 호출
		th1.start();	// .strat() = 별도의 쓰레드 시작
		th2.start();	// 별도의 쓰레드 시작
		// 시분할 영역은 운영체제가 관리하기 때문에
		// 결과값이 일정하지 않다.
		
		// Thread 클래스의 start() 메소드를 호출하면,
		// 내부적으로 run() 메소드가 호출됨
		// start() 메소드가 호출되어야 OS에 의해서 쓰레드로 동작을 하게 됨

		// run() 메소드를 직접 호출하는 경우는 쓰레드로 동작하는 것이 아니라,
		// 단순히 run() 메소드만 실행이 되는 것임.

		// 이때 발생하는 호출스택 관계도는 '자바의 정석' p626 그림 참조. p628,629 예제

		System.out.println("=======================");
		System.out.println("여기는 언제 출력될까요?");
		System.out.println("=======================");

		// 하나의 쓰레드는 start() 가 딱 한번만 호출될수 있다.
		// 만약 아래와 같이 다시 start() 하면 IllegalThreadStateException 발생
//		th1.start();
//		th2.start();
		// 오류도 Thread 때문에 섞여서 나옴ㅋㅋㅋ
		
		
		// 아래와 같이 새로 생성해서 사용하면 가능
		th1 = new MyThread("Hellow jjjh");
		th1.start();
		
		// 작업(워킹) Thread 총 3번	- 동작하는 Thread
		// main Thread 1번
		
	} // end main()

} // end class

// 1. Thread 클래스를 상속받는 클래스를 정의
class MyThread extends Thread {

	private String msg;
	private int count;

	public MyThread() {
	}

	public MyThread(String msg) {
		this.msg = msg;
		count = 0;
	}

	// 2. 정의한 클래스에서 run() 메소드를 override
	// 쓰레드에서 할 일을 구현
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + count + " : " + msg);
			count++;
		}
	}	// getName() 

} // end class MyThread
