package com.seniorkot.model;

import javax.persistence.*;

@Entity
@Table(name = "POINTS")
public class Point{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "X")
    private Double x;

    @Column(name = "Y")
    private Double y;

    @Column(name = "R")
    private Double r;

    @Column(name = "Inside")
    private Boolean inside;

    public Point(){}

    public Point(Double x, Double y, Double r){
        this.x = x;
        this.y = y;
        this.r = r;
        this.inside = check();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }
    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }
    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }
    public void setR(Double r) {
        this.r = r;
    }

    public Boolean getInside() {
        return inside;
    }
    public void setInside(Boolean inside) {
        this.inside = inside;
    }

    public boolean check(){
        if (x <= 0 && y <= 0 && x >= -r && y >= -r/2){
            return true;
        }
        else if (x <= 0 && y > 0 && x*x + y*y >= r/4){
            return true;
        }
        else if (x >= 0 && y <= 0 && y >= x*2 - r){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Point [ x: " + this.x + ", y: " + this.y + ", R: " + this.r + ", inside: " + this.inside + " ]";
    }
}
