package com.example.FirstLab.dao.api;

import com.example.FirstLab.dao.entity.ResultEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IResultRepository extends CrudRepository<ResultEntity,String> {
    List<ResultEntity> findAll();
}
