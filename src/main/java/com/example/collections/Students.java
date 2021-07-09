package com.example.collections;

public class Students {
    String name;
    String group;
    byte course;
    byte mathMark;
    byte englishMark;
    byte russianMark;

    public Students(String name, String group, byte course, byte mathMark, byte englishMark, byte russianMark){
        this.name = name;
        this.group = group;
        this.course = course;
        this.mathMark = mathMark;
        this.englishMark = englishMark;
        this.russianMark = russianMark;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Students student = (Students) obj;
        return name.equals(student.name) && group.equals(student.group) && course == student.course &&
                mathMark == student.mathMark && englishMark == student.englishMark && russianMark == student.russianMark;
    }
}
