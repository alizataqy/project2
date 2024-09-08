package com.example.project2;

public class ItemJadwal {
    private String className;
    private String classTime;
    private String classLocation;

    public ItemJadwal(String className, String classTime, String classLocation) {
        this.className = className;
        this.classTime = classTime;
        this.classLocation = classLocation;
    }

    public String getClassName() {
        return className;
    }

    public String getClassTime() {
        return classTime;
    }

    public String getClassLocation() {
        return classLocation;
    }

}
