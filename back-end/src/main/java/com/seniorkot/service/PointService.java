package com.seniorkot.service;

import com.seniorkot.repository.PointRepository;
import com.seniorkot.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointRepository pointRepository;

    public void add(Point pt){
        pointRepository.saveAndFlush(pt);
    }

    public void delete(long id){
        pointRepository.delete(id);
    }

    public void deleteAll(){
        pointRepository.deleteAll();
    }

    public List<Point> getAll(){
        return pointRepository.findAll();
    }

    public Point get(long id){
        return pointRepository.findOne(id);
    }
}
