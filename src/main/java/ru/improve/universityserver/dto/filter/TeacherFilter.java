package ru.improve.universityserver.dto.filter;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class TeacherFilter {

    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d.MM.yyyy")
    private LocalDate startHireDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d.MM.yyyy")
    private LocalDate endHireDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartHireDate() {
        return startHireDate;
    }

    public void setStartHireDate(LocalDate startHireDate) {
        this.startHireDate = startHireDate;
    }

    public LocalDate getEndHireDate() {
        return endHireDate;
    }

    public void setEndHireDate(LocalDate endHireDate) {
        this.endHireDate = endHireDate;
    }
}
