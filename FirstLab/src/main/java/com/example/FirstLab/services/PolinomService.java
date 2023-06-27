package com.example.FirstLab.services;

import com.example.FirstLab.core.Result;
import com.example.FirstLab.core.SingleErrorResponse;
import com.example.FirstLab.dao.api.IResultRepository;
import com.example.FirstLab.dao.api.IStorage;
import com.example.FirstLab.dao.entity.ResultEntity;
import com.example.FirstLab.services.api.IPolinomService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PolinomService implements IPolinomService {
    private IStorage storage;
    private IResultRepository repository;

    public PolinomService(IStorage storage, IResultRepository repository) {
        this.storage = storage;
        this.repository=repository;

    }

    @Override
    public Result isPolinom(String str) {
        for(int i = 0, j = str.length() - 1; i < str.length() && j >= 0; i++, j--)
        {
            if(str.codePointAt(i) != str.codePointAt(j))
            {
                return new Result(str,false);
            }
        }

        Result result = new Result(str,true);
        storage.save(str, result);
        return result;
    }

    @Override
    public void saveAll(List<String> list) {
        Map<String,Result> map=new HashMap<>();
        list.forEach(str->map.put(str,isPolinom(str)));
        storage.saveAll(map);
        repository.saveAll(map.values().stream()
                .map((result)->new ResultEntity(result.getWord(),result.isPolinom())).toList());
    }

    @Override
    public List<Result> getAll() {
        //return storage.getAll().values().stream().toList();
        return repository.findAll().stream()
                .map((resultEntity -> new Result(resultEntity.getWord(),resultEntity.isPolinom()))).toList();
    }

    @Override
    public Result getMin(List<String> list) {
        Optional<String> min = list.stream().min(Comparator.comparingInt(String::length));
        return isPolinom(min.orElseThrow(()->new SingleErrorResponse("error","list is empty")));
    }

    @Override
    public Result getMax(List<String> list) {
        Optional<String> max = list.stream().max(Comparator.comparingInt(String::length));
        return isPolinom(max.orElseThrow(()->new SingleErrorResponse("error","list is empty")));
    }

    @Override
    public Result getMiddle(List<String> list) {
        Optional<String> middle = list.stream().sorted(Comparator.comparingInt(String::length)).skip(list.size() / 2).findFirst();
        return isPolinom(middle.orElseThrow(()->new SingleErrorResponse("error","list is empty")));
    }

    @Override
    public Map<String ,Result> getStatistic(List<String> list) {
        return Map.of("min",getMin(list),"middle",getMiddle(list),"max",getMax(list));
    }

}
