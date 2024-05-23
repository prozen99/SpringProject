package com.example.demo;

import com.example.demo.domain.People;
import com.example.demo.domain.PeopleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@RequiredArgsConstructor
public class initData {

    private final PeopleRepository peopleRepository; // 의존성 주입

    @PostConstruct
    public void init()//그냥 초기 데이터 하나 만들어놓음 .
    {
        peopleRepository.save(new People("민수","게임 하기"));
        peopleRepository.save(new People("재현","운전 하기"));
        peopleRepository.save(new People("현택","gogo"));

    }

}
