package com.example.onlinecourse;

public class Model {
    int image;
    String course_title, course_type;

    public Model(int image, String course_title, String course_type) {
        this.image = image;
        this.course_title = course_title;
        this.course_type = course_type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }
}
