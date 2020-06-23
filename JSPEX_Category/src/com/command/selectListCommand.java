package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;


public class selectListCommand implements Command {

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) {
			CategoryDAO dao = new CategoryDAO();  // DAO 객체 생성
			CategoryDTO [] arr = null;
			
			System.out.println(request.getParameter("uid"));
			System.out.println(request.getParameter("depth"));
			
			int depth = Integer.parseInt(request.getParameter("depth"));
			int uid = Integer.parseInt(request.getParameter("uid"));

			
			try {
				switch(depth) {
				case 1:
					// 트랜잭션 수행
					arr = dao.select(uid, depth);
					request.setAttribute("list", arr);
					break;
				case 2:
					if(request.getParameter("parent")!=null){
						int parent = Integer.parseInt(request.getParameter("parent"));
						arr = dao.selectDepth2(uid, depth, parent);
						request.setAttribute("list", arr);
					} // end if
					break;
				case 3:
					if(request.getParameter("parent")!=null){
						int parent = Integer.parseInt(request.getParameter("parent"));
						arr = dao.selectDepth3(uid, depth, parent);
						request.setAttribute("list", arr);
					} // end if
					break;
				}
				
			} catch(SQLException e) {
				// 만약 CP 사용한다면
				// NamingException 도 처리 해야 함.
				
				e.printStackTrace();
			}	
		} // end execute

}
