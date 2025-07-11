package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// 아래 클래스는 오라클 서버에 notice라는 테이블을 대신할 클래스이다 - JPA?
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeVO {
  private int n_no;
  private String n_title;
  private String n_content;
  }
