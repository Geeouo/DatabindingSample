package com.gee.databindingsample;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Create by Gee on 2020/7/19.
 * _____
 * / ____|
 * | |  __  ___  ___
 * | | |_ |/ _ \/ _ \
 * | |__| |  __/  __/
 * \_____|\___|\___|
 */
public class Student extends BaseObservable {
    private String name;//名字
    private int grade;//成绩
    private int resourceId = -1; //图片默认资源

    @Bindable
    public int getResourceId() {
        return resourceId == -1 ? R.drawable.ic_launcher_background : resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
        notifyPropertyChanged(BR.resourceId);
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
        notifyPropertyChanged(BR.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
