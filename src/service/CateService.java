package service;

import entity.Cate;

import java.util.List;

public interface CateService {
     int add();
    int update();
    int delete();
    List query();
    Cate catefind();
}
