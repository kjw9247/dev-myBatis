package com.example.demo.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.NoticeService;
import com.example.demo.vo.NoticeVO;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
// 나는 이제부터 req와 res없이도 모든 요청에 대해서 처리할 수 있어
@Log4j2
@RestController
@RequestMapping("/notice/*")
public class RestNoticeController {
    @Autowired
    private NoticeService noticeService;
    @GetMapping("noticeSelect")
    public String noticeSelect (NoticeVO nvo)
    {
      log.info("noticeSelect");
      List<NoticeVO> list = null;
      list = noticeService.noticeSelect(nvo);
      Gson gson = new Gson();
      String temp = gson.toJson(list);
      return temp;
    }// end of noticeList
    @GetMapping("noticeDetail")
    public String noticeDetail (NoticeVO nvo)
    {
      log.info("noticeDetail");
      List<NoticeVO> list = null;
      list = noticeService.noticeSelect(nvo);
      Gson gson = new Gson();
      String temp = gson.toJson(list);
      return temp;
    }// end of noticeDetail
    @PostMapping("noticeInsert")
    public String noticeInsert(NoticeVO nvo)
    {
      log.info("noticeInsert");
      int result = 0;
      result = noticeService.noticeInsert(nvo);
      return String.valueOf(result);
    }
    @PutMapping("noticeUpdate")
    public String noticeUpdate(NoticeVO nvo)
    {
      log.info("noticeUpdate");
      int result = 0;
      result = noticeService.noticeUpdate(nvo);
      return String.valueOf(result);
    }
    // http://localhost8000/notice/noticeDelete?n_no=3
    // http://localhost8000/notice/noticeDelete/3 이 2개는 다름
    @DeleteMapping("noticeDelete")
    public String noticeDelete(int n_no)
    {
      log.info("noticeDelete n_no : "+ n_no);
      int result = 0;
      result = noticeService.noticeDelete(n_no);
      return String.valueOf(result);
    }
    
}
