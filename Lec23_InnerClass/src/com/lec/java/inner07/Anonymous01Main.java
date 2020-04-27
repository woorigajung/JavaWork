package com.lec.java.inner07;


/*
  Anonymous inner class(익명 내부 클래스):
   이름이 없는 local inner class
   이름이 없기 때문에 생성자를 만들 수가 없습니다.
   클래스의 정의와 동시에 인스턴스를 생성합니다.
   
   일반클래스에서도 가능
*/
public class Anonymous01Main {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Class(익명 내부 클래스)");
		
		Person p = new Person("헐");
		Readable r = p.createInstance(55);
		r.readInfo();
		
		Readable r2 = new Readable() {
			
			@Override
			public void readInfo() {
				
				System.out.println("r2의 readInfo 입니다");
			}
		};
		r2.readInfo();
		
		Readable r3 = new Readable() {
			
			@Override
			public void readInfo() {
				System.out.println("r3의 readInfo 입니다");
				
			}
		};
		r3.readInfo();
		
		
		new Readable() {
			
			@Override
			public void readInfo() {
				System.out.println("r4의 readInfo 입니다");
				
			}
			
			}.readInfo();
		
			
			Movable m1 = new Movable() {
				
				@Override
				public void move(int times) {
					System.out.println(times * speed);
				}
			};
			m1.move(2);
			m1.move(10);
			
			MyClass my1 = new MyClass();
			my1.aaa(); my1.bbb();
			MyClass my2 = new MyClass() {
				@Override
				public void aaa() {
					System.out.println("AAA");
				}
			};
			my2.aaa();
			
			MyClass my3 = new MyClass() {
				// Alt + Shift + v

				@Override
				public void aaa() {
					// TODO Auto-generated method stub
					super.aaa();
				}

				@Override
				public void bbb() {
					// TODO Auto-generated method stub
					super.bbb();
				}
			};
					
	} // end main()


} // end class Anonymous01Main















