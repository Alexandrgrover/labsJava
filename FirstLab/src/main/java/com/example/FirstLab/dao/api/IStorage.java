package com.example.FirstLab.dao.api;

import com.example.FirstLab.core.Result;

import java.util.List;
import java.util.Map;

public interface IStorage {
    void save(String str, Result result);
    void saveAll(Map<String, Result> map);
    Map<String,Result> getAll();
}
