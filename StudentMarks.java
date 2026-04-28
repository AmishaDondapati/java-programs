package com.StudentMarks.Entity;

import jakarta.persistence.*;

@Entity
public class StudentMarks {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double m1;

    @Column(nullable = false)
    private double m2;

    @Column(nullable = false)
    private double m3;
    
    @Column(nullable=false)
    private double total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getM1() {
        return m1;
    }

    public void setM1(double m1) {
        this.m1 = m1;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public double getM3() {
        return m3;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }
    
    @PrePersist
    @PreUpdate
    public void calculateTotal() {
        this.total = m1 + m2 + m3;
    }

    public double getTotal() {
        return total;
    }
}