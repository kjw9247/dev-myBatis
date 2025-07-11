package com.example.demo.vo;

import lombok.Data;

@Data
public class DeptVO {
    // 원시형 타입은 호출하면 값이 출력이 된다 - NullPointerException의 대상이 되지 않음
    private int deptno; // 0
    private String dname; // null
    private String loc; // null
}
