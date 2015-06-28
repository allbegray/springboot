package com.hong.springboot.modules.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hong.springboot.domains.Board;
import com.hong.springboot.modules.board.support.BoardSearchContext;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(method = RequestMethod.POST)
	public Board add(Board board) {
		return boardService.add(board);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Board> list(BoardSearchContext boardSearchContext, Model model) {
		return boardService.getListByContext(boardSearchContext);
	}

}
