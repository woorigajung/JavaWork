package com.lec.java.thread02;

/* Runnable 인터페이스로 쓰레드 구현
 자바는 다중 상속을 지원하지 않음
 -> 다른 클래스를 상속받고 있는 경우에는, 
 Thread 클래스를 상속받을 수 없는 문제가 발생
 -> 인터페이스를 구현해서 쓰레드를 생성할 수 있는 방법을 제공

 쓰레드 사용 방법 2:
 1. Runnable 인터페이스를 구현하는 클래스를 정의
 2. 정의한 클래스에서 run() 메소드를 override
 3. Runnable을 구현하는 클래스의 인스턴스를 생성
 4. 만들어진 인스턴스를 Thread 생성자의 매개변수로 주면서, Thread 인스턴스를 생성
 5. 생성된 Thread 인스턴스의 start() 메소드를 호출
*/

public class Thread02Main {

	public static void main(String[] args) {
		System.out.println("쓰레드 생성 2");

		// 3. Runnable을 구현하는 클래스의 인스턴스를 생성
		Runnable runnable1 = new MyRunnable("안녕, 자바프레임웍");
		Runnable runnable2 = new MyRunnable("Hello, HTML!");
		Runnable runnable3 = new MyRunnable("멀티 쓰레드");
		
		// 4. Runnable을 이용해서 Thread 인스턴스를 생성
		Thread th1 = new Thread(runnable1);
		Thread th2 = new Thread(runnable2);

		// 5. Thread 인스턴스의 start() 메소드를 호출
		th1.start();
		th2.start();
		new Thread(runnable3).start();
		new Thread(new MyRunnable("히히ㅣㅎ히ㅣ히히")).start();

		// Anonymous class 로 생성
		// System.out.println();
		// System.out.println("Anonymous class 으로 Runnable 구현");
		new Thread(new Runnable() {
			
			int count = 0;	// 익명 클래스 멤버변수
			String msg = "풀스택 과정";
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					// Thread.currentTHread() - 현재 이코드를 실행중인 Thread 객체 리턴
					// getName() 사용 불가 + THread에 있는 메서드이기 때문에
					System.out.println(Thread.currentThread().getName() + " : " + count + " : " + msg);
					count ++;
				}	
					
			}
		}).start();		
		
		// Runnable 인터페이스는 run() 가상메소드 하나만 가지고 있는 인터페이스 이기 때문에
		// Lambda-expression 으로도 구현 가능.	// 추상메서드가 하나 일때만 람다 expression으로 만들 수 있음!!!
		// System.out.println();
		// System.out.println("Lambda-expression 으로 Runnable 구현");
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " : " + i + " : " + "쉬는시간이다!");
			}	
		} ).start();
		
		
		System.out.println("-- main() 종료  -- ");
	} // end main()

} // end class

// 1. Runnable 인터페이스를 구현하는 클래스를 정의
class MyRunnable implements Runnable {
	private String msg;
	private int count;

	public MyRunnable() {
	}

	public MyRunnable(String msg) {
		this.msg = msg;
		count = 0;
	}

	// 2. 정의한 클래스에서 run() 메소드를 override - 쓰레드 할 일
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			// Thread.currentTHread() - 현재 이코드를 실행중인 Thread 객체 리턴
			// getName() 사용 불가 + THread에 있는 메서드이기 때문에
			System.out.println(Thread.currentThread().getName() + " : " + count + " : " + msg);
			count ++;
		}	// main 끝났다고 java 프로그램이 끝난 것이아니라
			// main 에서 파생된 모든 작업이 끝나야 작업이 종료된 것이다.
	}

} // end class MyRunnable
