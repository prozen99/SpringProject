package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class PeopleRepository {

    /*
       1. 아무나 이름과 버킷리스트를 작성할 수 있다.
       2. 모든 사람의 버킷리스트를 조회 할 수 있다.
       3. 특정 인물의 버킷 리스트를 조회 할 수 있다.
       4. 아무나 버킷리스트의 항목을 완료 할 수 있다.
     */
    People people=new People();
    private static final Map<Long,People> store=new HashMap<>();//데이터 저장
    private static long sequence=0L; // 아이디

    public People save(People people) //회원을 저장하기
    {
            people.setId(++sequence);
            store.put(people.getId(), people);
            return people;
    }

    public People findById(Long id)//특정 인물 한명으로 회원 조회하기
    {
        return store.get(id);
    }

    public List<People> findAll()// 모든 사람을 찾을 수 있음.
    {
            return new ArrayList<>(store.values());
            // 사람의 데이터 값을 이용해서 모두 나올 수 있게 하기 .
    }


    // 상태를 완료로 바꾸는 부분
    public People reboolean(Long id)
    {
        People people1 = store.get(id);
        people1.setFinish(true);
        return people1;

    }







}
