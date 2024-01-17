package com.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity3 { // 팀 테이블
	
	@Column(unique = true)
	private Long personal_id; // 개인 식별
	
	@Id
	@Column(name="content_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long content_id; // 글 번호
	
	private String personal_content;  // 내용
	
	private String date; // 지정 날짜
	
	@Column(nullable = false)
    private Boolean completed; // 완료 여부

	
}


//{
//    "team_id" : 1,
//    "personal_id" : 1,
//    "completed" : false,
//    "date" : "2024-01-09",
//    "team_content" : "밥먹기"
//}


