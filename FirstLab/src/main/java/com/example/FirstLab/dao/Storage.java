package com.example.FirstLab.dao;

import com.example.FirstLab.core.Result;
import com.example.FirstLab.dao.api.IStorage;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Storage implements IStorage {
    private final Map<String, Result> map = new ConcurrentHashMap<>();
    @Override
    public void save(String str, Result result) {
        this.map.put(str, result);
    }
    @Override
    public void saveAll(Map<String,Result> map){
        this.map.putAll(map);
    }

    @Override
    public Map<String, Result> getAll() {
        return Collections.unmodifiableMap(map);
    }
}
