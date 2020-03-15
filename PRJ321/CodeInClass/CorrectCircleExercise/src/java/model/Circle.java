/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sonnt
 */
public class Circle {

    private int id;
    private int x;
    private int y;
    private int radius;
    private int speed;
    private int r;
    private int g;
    private int b;
    private boolean Up;
    private boolean Right;
    private boolean Running;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public boolean isUp() {
        return Up;
    }

    public void setUp(boolean Up) {
        this.Up = Up;
    }

    public boolean isRight() {
        return Right;
    }

    public void setRight(boolean Right) {
        this.Right = Right;
    }

    public boolean isRunning() {
        return Running;
    }

    public void setRunning(boolean Running) {
        this.Running = Running;
    }
    
}
