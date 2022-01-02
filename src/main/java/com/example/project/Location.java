package com.example.project;

public class Location {
    double min_x;
    double min_y;
    double max_x;
    double max_y;
    double width;
    double height;
    
    Location(double min_x, double min_y, double max_x, double max_y) 
    {
        this.min_x = min_x;
        this.min_y = min_y;
        this.max_x = max_x;
        this.max_y = max_y;
        this.width = max_x - min_x;
        this.height = max_y - min_y;
    }


    public void setMax_x(double max_x) {
        this.max_x = max_x;
    }

    public void setMax_y(double max_y) {
        this.max_y = max_y;
    }

    public void setMin_x(double min_x) {
        this.min_x = min_x;
    }
    public void setMin_y(double min_y) {
        this.min_y = min_y;
    }
    public void setX(double minx, double maxx) {
        this.min_x = minx;
        this.max_x = maxx;
    }

    public void setY(double miny, double maxy) {
        this.min_y = miny;
        this.max_y = maxy;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

}
