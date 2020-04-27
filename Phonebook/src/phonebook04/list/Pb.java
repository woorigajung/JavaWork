package phonebook04.list;

// Controller 인터페이스
//   동작 정의하기 전에 '동작 설계'
public interface Pb {
	
	public static final String VERSION = "전화번호부 4.0";
	
	public abstract int insert(String name, String phoneNum, String memo); /* 1 */
	public abstract PhonebookModel[] selectAll(); /* 2 */
	public abstract PhonebookModel selectByUid(int uid); /* 3 */
	public abstract int updateByUid(int uid, String name, String phoneNum, String memo); /* 4 */
	public abstract int deleteByUid(int uid);  /* 5 */

//	public static final int QUERY_FAIL = 0;

	// 에러코드 상수
	public static final int ERR_GENERIC = 0;	// 일반오류

	public static final int ERR_INDEXOUTOFRANDE = 1;	// 인덱스 범위 벗어남
	
	public static final int ERR_EMPTY_STRING = 2; 	// 입력문자열이 empty (혹은 null) 인 경우
	
	public static final int ERR_UID = 3; // uid 가 없는 경우
	
	
	// 에러 문자열
	public static final String[] ERR_STR = {
		"일반오류", // 0
		"인덱스오류",	// 1
		"문자열오류",	// 2
		"UID 오류",	// 3
	};
}

