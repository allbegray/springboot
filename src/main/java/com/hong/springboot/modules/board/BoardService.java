package com.hong.springboot.modules.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hong.springboot.domains.Board;
import com.hong.springboot.domains.QBoard;
import com.hong.springboot.modules.board.support.BoardSearchContext;
import com.mysema.query.types.expr.BooleanExpression;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public Board add(Board board) {
		return boardRepository.save(board);
	}

	@Transactional(readOnly = true)
	public List<Board> getListByContext(BoardSearchContext boardSearchContext) {

		BooleanExpression predicate = null;
		if (StringUtils.hasText(boardSearchContext.getS_title())) {
			predicate = QBoard.board.title.like("%" + boardSearchContext.getS_title() + "%");
		}

		if (StringUtils.hasText(boardSearchContext.getS_desc())) {
			BooleanExpression descLike = QBoard.board.desc.like("%" + boardSearchContext.getS_desc() + "%");
			if (predicate != null) {
				predicate.or(descLike);
			} else {
				predicate = descLike;
			}
		}

		return (List<Board>) boardRepository.findAll(predicate);
	}

}
