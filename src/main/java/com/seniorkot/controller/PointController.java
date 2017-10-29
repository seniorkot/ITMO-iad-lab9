package com.seniorkot.controller;

import com.seniorkot.model.Point;
import com.seniorkot.service.PointService;
import com.seniorkot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class PointController {

    @Autowired
    private PointService pointService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/point.all", method = RequestMethod.GET)
    public List<Point> getAllPoints() {
        return pointService.getAll();
    }

    @RequestMapping(value = "/point.get", method = RequestMethod.GET)
    public Point getPoint(@RequestParam(name = "id", required = true) Long id){
        return pointService.get(id);
    }

    @RequestMapping(value = "/point.add", method = RequestMethod.POST)
    public Point addPoint(@RequestParam(name = "x", required = true) Double x,
                          @RequestParam(name = "y", required = true) Double y,
                          @RequestParam(name = "r", required = true) Double r,
                          @RequestParam(name = "login", required = true) String login,
                          @RequestParam(name = "passwd", required = true) String passwd){
        passwd = String.valueOf(passwd.hashCode());
        if (userService.getByLoginAndPassword(login, passwd) == null){
            return null;
        }
        Point point = new Point(x, y, r);
        pointService.add(point);
        return point;
    }

    @RequestMapping(value = "/point.remove", method = RequestMethod.DELETE)
    public String addPoint(@RequestParam(name = "id", required = false) Long id){
        if (id == null){
            pointService.deleteAll();
            return "Success all";
        }
        pointService.delete(id);
        return "Success";
    }
}
