package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@RequestMapping(value="/list")
	public String listBoard() {
		System.out.println("list 들어옴");
		return "board/list_board";
	}
	
	@RequestMapping(value="/write")
	public String wtireBoard() {
		System.out.println("wtire 들어옴");
		return "board/write_board";
	}
	
	@RequestMapping(value="/view")
	public String viewBoard() {
		System.out.println("view 들어옴");
		return "board/view_board";
	}
	
	@RequestMapping(value="/delete")
	public String deleteBoard() {
		System.out.println("delete 들어옴");
		return "board/delete_board";
	}
	
	@RequestMapping(value="/update")
	public String updateBoard() {
		System.out.println("update 들어옴");
		return "board/update_board";
	}
}
