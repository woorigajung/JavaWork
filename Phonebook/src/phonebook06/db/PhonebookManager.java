package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// CONTROLLER 객체
//   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)

// by 윤지우
public class PhonebookManager implements Pb, Closeable {

//  : DB 를 위한 변수들 선언	
	Connection conn = null; // java.sql.Connection
	Statement stmt = null; // java.sql.Statement
	PreparedStatement pstmt = null;
	ResultSet rs = null; // java.sql.ResultSet

// singleton적용
	private PhonebookManager() {
		// JDBC 프로그래밍
		try {
			// 클래스 로딩
			Class.forName(Pb.DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");

			// 연결 Connection
			conn = DriverManager.getConnection(Pb.URL, Pb.USER, Pb.PASSWD);
			System.out.println("DB Connect 연결");

			// Statement (필요하다면) 생성
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}

		int cnt = 0;

//		 SQL_INSERT 사용하여 INSERT
//		 PreparedStatement 사용..
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			// "INSERT INTO phonebook(pb_uid, pb_name, pb_phonenum, pb_memo)
			// VALUES(phonebook_seq.nextval, ?, ?, ?)"
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.executeUpdate();
			cnt++;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return cnt;

	}

	@Override
	public PhonebookModel[] selectAll() {
		// SQL_SELECT_ALL 사용
		ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
		try {
			rs = stmt.executeQuery(SQL_SEL_ALL);
			
			int i = 0;
			while (rs.next()) {
						Date d = rs.getDate(COL_LABEL_REGDATE);
						Time t = rs.getTime(COL_LABEL_REGDATE);
						String dateStr =
								new SimpleDateFormat("yyyy-MM-dd").format(d) 
								+ " " + new SimpleDateFormat("hh:mm:ss").format(t);
						Date date =
								new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).parse(dateStr);

						pbList.add(i, new PhonebookModel(
						rs.getInt(COL_LABEL_UID),
						rs.getString(COL_LABEL_NAME),
						rs.getString(COL_LABEL_PHONENUM),
						rs.getString(COL_LABEL_MEMO),
						date));
				// new SimpleDateFormat("EEE MMM dd hh:mm:ss").format(COL_LABEL_REGDATE)))
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		PhonebookModel[] pb = new PhonebookModel[pbList.size()];
		for (int i = 0; i < pbList.size(); i++) {
			pb[i] = pbList.get(i);
		}

		return pb;
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		// : 옵션
		try {
			rs = stmt.executeQuery(SQL_SEL_ALL);
			while (rs.next()) {
				if (rs.getInt(COL_LABEL_UID) == uid) {
					return new PhonebookModel(uid);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; // 못찾으면 null 리턴
	}// end selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);

		if (name == null || name.trim().length() == 0) // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);

		int cnt = 0;

		// SQL_UPDATE_BY_UID 사용
		if (selectByUid(uid) != null) {
			try {
				pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
				// "UPDATE phonebook SET pb_name = ?, pb_phonenum = ?, pb_memo = ? WHERE pb_uid
				// = ? "
				pstmt.setString(1, name);
				pstmt.setString(2, phoneNum);
				pstmt.setString(3, memo);
				pstmt.setInt(4, uid);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		cnt++;
		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int cnt = 0;

		// SQL_DELETE_BY_UID 사용
		if (selectByUid(uid) != null) {
			try {
				pstmt = conn.prepareStatement(DEL_BY_UID);
				pstmt.setInt(1, uid);
				pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		cnt++;
		return cnt;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
//	private int getMaxUid() {
//		int maxUid = 0;
//		
//		// max uid == 현재 uid 값 : 옵션
//		// 한마디로 값이 없으면 Insert 때 
//		// Sequence 값 초기화 Drop -> Create 
//		// 공부 다하고 만들 시간이 있으면
//		return maxUid;
//	}

	@Override
	public void close() throws IOException {
		
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}

} // end PhonebookException
