/* package com.example.demo.vo;
// 디폴트 생성자는 파라미터가 없는 생성자
// 디폴트 생성자는 생략이 가능함
// 파라미터를 세 개나 가진 생성자
public class VOSimulation {
  public static void main(String[] args) {
    NoticeVO vo = new NoticeVO();
    System.out.println(vo.getN_no() + vo.getN_title() + vo.getN_content());
    System.out.println("hello".length());
    // System.out.println(vo.getN_title());
    vo = new NoticeVO(1,"제목","내용");
    vo = new NoticeVO("제목", 1, "내용");
    vo = new NoticeVO("제목", "내용", 1);
  }

}
 */