package com.example.demo.board;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public List<BoardDto> list() {
        return boardService.getList().stream().map(board -> {
            BoardDto dto = new BoardDto();
            dto.setIdx(board.getIdx());
            dto.setTitle(board.getTitle());
            dto.setContent(board.getContent());
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{idx}")
    public ResponseEntity<BoardDto> detail(@PathVariable Long idx) {
        return boardService.getDetail(idx)
                .map(board -> {
                    BoardDto dto = new BoardDto();
                    dto.setIdx(board.getIdx());
                    dto.setTitle(board.getTitle());
                    dto.setContent(board.getContent());
                    return ResponseEntity.ok(dto);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/reg")
    public ResponseEntity<Map<String, Object>> register(@RequestBody BoardDto dto) {
        Board board = new Board();
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        Board savedBoard = boardService.register(board);

        Map<String, Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("message", "게시글이 성공적으로 등록되었습니다.");
        result.put("idx", savedBoard.getIdx());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}