package com.example.demo.vo;
//컬럼의 수만큼 선언됨 - List<TestVO>, List<Map<>>
import lombok.Data;
//롬복 라이브러리를 추가하면 getter/setter역할을 하는 클래스에
//getter/setter 메서드를 추가하지 않아도 됩니다.
@Data
// 원시형 타입은 호출하면 값이 출력됨 - NullPointerException 대상이 아니다
public class TestVO {
  private int t_no = 0;
  private String t_title = null;
  private String t_content = null;
}
/* 
1. 롬복은 디폴트 생성자도 제공이 안된다 - @NoArgsConstructor
2. 파라미터가 있는 생성자인 경우 모든 전역변수에 대한 초기화는 @AllArgsConstructor
3. 생성자의 파라미터의 위치나 갯수를 자유롭게 제한 받지 않고 자유롭게 하려면 @Builder 사용함

스프링 시큐리티 - 시큐리티 설정에서 사용함

@Data => @getter + @setter
 */