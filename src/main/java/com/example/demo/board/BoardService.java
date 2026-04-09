package com.example.demo.board;

import com.example.demo.board.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public List<Board> getList() { return boardRepository.findAllByOrderByIdxDesc(); }
    public Optional<Board> getDetail(Long idx) { return boardRepository.findById(idx); }
    public Board register(Board board) { return boardRepository.save(board); }
}