//package phonebook04.list;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//
//// CONTROLLER 객체
////   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
//public class PhonebookManager implements Pb {
//
//	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
//	
//	// 몇개의 데이터가 저장되었는지
//	private int count = 0;
//	
//	// singleton적용
//	private PhonebookManager() {}
//	private static PhonebookManager instance = null;
//	public static PhonebookManager getInstance() {
//		if (instance == null) {
//			instance = new PhonebookManager();
//		}
//		return instance;
//	} // end getInstance()	
//	
//	
//	
//	// 전화번호부 생성 등록
//	@Override
//	public int insert(String name, String phoneNum, String memo) {
//		
//		// 매개변수 검증 : 이름 필수
//		if(name == null || name.trim().length() == 0) {
//			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
//		}
//		
//		// ArrayList는 크기가 정해져있지 않기 때문에 크기 늘리는 부분 삭제
//		pbList.add(count,new PhonebookModel(name, phoneNum, memo));
//		pbList.get(count).setUid(getMaxUid()+1);
//		count++;
//		
//		return 1;
//	}
//
//	@Override
//	public PhonebookModel[] selectAll() {
//		PhonebookModel[] result = new PhonebookModel[pbList.size()];
//		for (int i = 0; i < pbList.size(); i++) {
//			result[i] = pbList.get(i);
//		}
//// 컨트롤러만 건드려서 하라고 하셨던거 같아서 main부분은 안건드렸음
////		int i = 0;
////		for(PhonebookModel pbm : pbList) {
////			result[i] = pbm;
////			i++;
////		}
//		return result;
//	}
//
//	// 특정 uid 의 데이터 검색 리턴
//	// 못찾으면 null 리턴
//	@Override
//	public PhonebookModel selectByUid(int uid) {
//		for (int index = 0; index < count; index++) {
//			if(pbList.get(index).getUid() == uid) return pbList.get(index);
//		}
//		return null;  // 못찾으면 null 리턴
//	}// end selectByUid()
//
//	@Override
//	public int updateByUid(int uid, String name, String phoneNum, String memo) {
//		
//		// 매개변수 검증
//		if(uid < 1)
//			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);
//		
//		if(name == null || name.trim().length() == 0) // 이름 필수
//			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);
//		
//		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
//		int index = findIndexByUid(uid);
//		if(index < 0) 
//			throw new PhonebookException("update() 없는 uid: " + uid, Pb.ERR_UID);
//		
//		// pbList.set(index, new PhonebookModel(name,phoneNum,memo));
//		// set은 싹바 꾸는 것		오래 걸린다. get으로 내용만 바꾸는 것
//		pbList.get(index).setName(name);
//		pbList.get(index).setPhoneNum(phoneNum);
//		pbList.get(index).setMemo(memo);
//		
//		return 1;
//	}
//
//	@Override
//	public int deleteByUid(int uid) {
//		// 매개변수 검증
//		if(uid < 1) 
//			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);
//		
//		int index = findIndexByUid(uid);
//		if(index < 0)
//			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);
//
//		// 카운트 감소
//		pbList.remove(index);
//		count--;
//		
//		return 1;
//	}
//	
//	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
//	private int getMaxUid() {
//		int maxUid = 0;
//		for (int index = 0; index < count; index++) {
//			if(maxUid < pbList.get(index).getUid()) {
//				maxUid = pbList.get(index).getUid();
//			}
//		}
//		return maxUid;
//	}
//	
//	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
//	// 못찾으면 -1 리턴
//	private int findIndexByUid(int uid) {
//		
//		for (int index = 0; index < count; index++) {
//			if(pbList.get(index).getUid() == uid);
//			return index;
//		}
//		
//		return -1;
//	}
//	
//
//} // end PhonebookManager
//
//// 예의 클래스 정의
//// 예외발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
//class PhonebookException extends RuntimeException {
//	
//	private int errCode = Pb.ERR_GENERIC;
//	
//	public PhonebookException() {
//		super("Phonebook 예외 발생");
//	}
//	
//	public PhonebookException(String msg) {
//		super(msg);
//	}
//	
//	public PhonebookException(String msg, int errCode) {
//		super(msg);
//		this.errCode = errCode;
//	}
//	
//	
//	// Throwable 의 getMessage 를 오버라이딩 가능
//	@Override
//	public String getMessage() {
//		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] +
//					" " + super.getMessage();
//		return msg;
//	}
//	
//} // end PhonebookException
//
package phonebook04.list;

import java.util.ArrayList;

// CONTROLLER 객체
//   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)

// 20.03.27 윤종섭
public class PhonebookManager implements Pb {
	
	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	
	// singleton적용
	private PhonebookManager() {}
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()	
	
	
	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		// 매개변수 검증 : 이름 필수
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}
		
		PhonebookModel p = new PhonebookModel(name, phoneNum, memo);
		p.setUid(getMaxUid() + 1);
		pbList.add(p);
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		PhonebookModel[] pb = new PhonebookModel[pbList.size()];
		for (int i = 0; i < pbList.size(); i++) {
			pb[i] = pbList.get(i);
		}
		return pb; 

		// 아래와 같이 한줄로 가능!  toArray() : List<> --> 배열로 변환
//		return pbList.toArray(new PhonebookModel[pbList.size()]);
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		for (int i = 0; i < pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid) {
				return pbList.get(i);
			}
		}
		
		return null;  // 못찾으면 null 리턴
	}// end selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		
		// 매개변수 검증
		if(uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);
		
		if(name == null || name.trim().length() == 0) // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);
		
		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if(index < 0) 
			throw new PhonebookException("update() 없는 uid: " + uid, Pb.ERR_UID);
		
		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);
		
		return 1;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if(uid < 1) 
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);
		
		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);

		pbList.remove(index);
		
		return 1;
	}
	
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		
		if(pbList.size() > 0) {
			int uid = pbList.get((pbList.size() - 1)).getUid();
			if(maxUid < uid) maxUid = uid;
		}
		
//		for (PhonebookModel p : pbList) {
//		if(maxUid < p.getUid()) {
//			maxUid = p.getUid();
//		}
//	}
		
		return maxUid;
	}
	
	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		
		for (int i = 0; i < pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid) return i;
		}
		
		return -1;
	}
	

} // end PhonebookManager

// 예의 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {
	
	private int errCode = Pb.ERR_GENERIC;
	
	public PhonebookException() {
		super("Phonebook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	
	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] +
					" " + super.getMessage();
		return msg;
	}
	
} // end PhonebookException

















