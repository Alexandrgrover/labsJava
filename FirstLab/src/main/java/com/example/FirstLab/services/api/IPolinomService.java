package com.example.FirstLab.services.api;

import com.example.FirstLab.core.Result;

import java.util.List;
import java.util.Map;

public interface IPolinomService {
    Result isPolinom(String str);

    void saveAll(List<String> list);

    List<Result> getAll();

    Result getMin(List<String> list);
    Result getMax(List<String> list);
    Result getMiddle(List<String> list);

    Map<String,Result> getStatistic(List<String> list);
}
