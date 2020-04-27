package phonebook04.list;
// Controller(동작) : 정의 : 동작을 정의 한다. 

import java.util.InputMismatchException;

// view(사용자) 
// Model(데이터)

import java.util.Scanner;

// VIEW 객체
// 사용자와의 입출력 담당 (UI,..) 
public class PhonebookMain {

	private Scanner sc;
	private PhonebookManager pbCtrl; // CONTROLLER 객체

	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init(); // 초기화
		app.run(); // 실행
		app.exit(); // 종료
	} // end main()

	// 응용프로그램을 초기화
	public void init() {
		sc = new Scanner(System.in);
		pbCtrl = PhonebookManager.getInstance(); // CONTROLLER 생성
	}

	// 응용프로그램 구동
	public void run() {
		System.out.println(Pb.VERSION);

		int menu;
		while (true) {
			showMenu(); // 메뉴 표시
			try {
			menu  = sc.nextInt(); // 메뉴 입력
			sc.nextLine();

				switch (menu) {
				case Menu.MENU_INSERT:
					insertPhoneBook();
					break;
				case Menu.MENU_LIST:
					listPhonebook();
					break;
				case Menu.MENU_DELETE:
					deletePhonebook();
					break;
				case Menu.MENU_UPDATE:
					updatePhonebook();
					break;
				case Menu.MENU_QUIT:
					System.out.println("프로그램을 종료 합니다.");
					return;
				default:
					System.out.println("잘 못 입력하셨습니다.");
				}
			} catch (PhonebookException ex) {
				System.out.println(ex.getMessage());
			} catch (InputMismatchException ex) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}

		} // end while
	} // end run()

	// 응용프로그램 종료
	public void exit() {
		sc.close();
	}

	// 전화번호부 입력
	public void insertPhoneBook() {
		// VIEW 역할 : 사용자 입출력
		System.out.println("--- 입력 메뉴 ---");

		// 이름, 전화번호, 이메일 입력
		System.out.print("이름 입력:");
		String name = sc.nextLine();

		System.out.print("전화번호 입력:");
		String phoneNum = sc.nextLine();

		System.out.print("메모 입력:");
		String memo = sc.nextLine();

		// CONTROLLER에 연결
		int result = pbCtrl.insert(name, phoneNum, memo);
	} // end insertPhoneBook()
	
	// 전화번호부 수정
	public void updatePhonebook() {
		// VIEW : 사용자 입출력
		System.out.println("--- 수정 메뉴---");
		System.out.println("수정할 번호 입력: ");
		int uid = sc.nextInt();
		sc.nextLine();
		
		if(pbCtrl.selectByUid(uid) == null) {
			System.out.println("존재하지 않는 uid : " + uid);
			return;
		}
		
		// 이름, 전화번호, 이메일 입력
		System.out.print("이름 입력:");
		String name = sc.nextLine();

		System.out.print("전화번호 입력:");
		String phoneNum = sc.nextLine();

		System.out.print("메모 입력:");
		String memo = sc.nextLine();
		// CONTROLLER 연결
		int result = pbCtrl.updateByUid(uid, name, phoneNum, memo);
			System.out.println(result + "개의 전화번호 수정 성공");
	}	// end updatePhonebook
	
	// 전화번호부 삭제
	public void deletePhonebook() {
		// VIEW 사용자 입출력
		System.out.println("--- 삭제 메뉴 ---");
		
		System.out.println("삭제할 번호 입력");
		int uid = sc.nextInt();
		sc.nextLine();
		
		// CONTROLLER
		if(pbCtrl.selectByUid(uid) == null) {
			System.out.println("존재하지 않는 uid : " + uid);
			return;
		}
		
		int result = pbCtrl.deleteByUid(uid);
			System.out.println(result + "개의 전화번호 삭제 성공");
//		}
		
	}	// end deletePhonebook()
	
	// 전화번호부 열람 (전체)
	public void listPhonebook() {
		// CONTROLLER 연결
		PhonebookModel[] data = pbCtrl.selectAll();
		
		// VIEW 역할 : 사용자 입출력
		System.out.println("총" + data.length + " 명의 전화번호 출력");
		for (PhonebookModel e : data) {
			System.out.println(e);
		}
	}

	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println(" [0] 종료");
		System.out.println(" [1] 입력");
		System.out.println(" [2] 열람");
		System.out.println(" [3] 수정");
		System.out.println(" [4] 삭제");
		System.out.println("------------------");
		System.out.print("선택: ");
	}

} // end class
