package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Data
public class People {

    Long id; // 회원 ID
    String name;// 사람 이름
    String todo;// 버킷 리스트 내용
    boolean finish=false;// 완료 항목
    String secret; //
    /*
    아무나 이름과 버킷리스트를 작성 할 수 있다
모든 사람의 버킷리스트를 조회 할 수 있다
특정 인물의 버킷리스트를 조회 할 수 있다
아무나 버킷리스트의 항목을 완료 로 변경 할 수 있다.
     */
    public People()//그냥 생성자 하나 만듬
    {

    }
    public People(String name, String todo) {
        this.name = name;
        this.todo = todo;
    }
}
