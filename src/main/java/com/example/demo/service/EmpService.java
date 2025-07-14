package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmpDao;
import com.example.demo.vo.EmpVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EmpService {
  @Autowired
  private EmpDao empDao;

  public List<Map<String, Object>> empList(Map<String, Object> pmap) {
  List<Map<String, Object>> list = null;
  list = empDao.empList(pmap);
  if(list==null/* ||list.size()==0 */){
    list=new ArrayList<>();
  }
  return list;
  }

  public int empInsert(Map<String, Object> pmap) {
    log.info("empInsert");
    int result = 0;
    result = empDao.empInsert(pmap);
    return result;
  }

  public int empUpdate(Map<String, Object> pmap) {
    log.info("empUpdate");
    int result = 0;
    result = empDao.empUpdate(pmap);
    return result;
  }

  public int empDelete(Map<String, Object> pmap) {
    log.info("empDelete");
    int result = 0;
    result = empDao.empDelete(pmap);
    return result;
  }
}
