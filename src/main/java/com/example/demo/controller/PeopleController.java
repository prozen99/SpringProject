package com.example.demo.controller;

import com.example.demo.domain.People;
import com.example.demo.domain.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/list")
public class PeopleController {

    private final PeopleRepository peopleRepository;//의존성 주입


    @GetMapping("/")
    public String list()
    {
        return "welcome";
    }
    @GetMapping("/add") // 그 어떤 사람도 글을 쓸수 있고 버킷리스트도 작성가능.
    //메서드 타입은 post가 맞을거 같긴한데 일단 띄울려고 get씀.
    // = > 잘모르겠음.
    public String write()
    {
        return "write";
    }

    @GetMapping // 전체 인원 조회.
    public List<People> listAll(Model model)
    {
        List<People> peopleRepositoryAll = peopleRepository.findAll();
        //model.addAttribute("people1",peopleRepositoryAll);
        //return "allpeople";
        return peopleRepositoryAll;
    }

    @GetMapping("/{peopleId}")// 특정 인원 조회하기 id3
    public People listPeople(@PathVariable long peopleId, Model model) {
        People peoplefind = peopleRepository.findById(peopleId);
        return peoplefind;
    }

    @PostMapping("/{peopleId}")// 일단 아무나 버킷리스트 항목을 완료 해야하니까 쓰는거고
    // 메서드 형태는 post이고 특정 사람이 완료 인지 변경인지 알기위해서
    // 넣어놨음.
    public People edit(@PathVariable long peopleId)
    {
        People reboolean = peopleRepository.reboolean(peopleId);//아이디 몇번인지 체크
        return reboolean;
    }













}