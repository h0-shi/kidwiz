package com.kidwiz.web.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RsvDTO {

    private int rsvno;
    private int sid;
    private int proid;
    private String ctype;
    private LocalTime ctime;
    private LocalDate cdate;
    private LocalDate rsvdate;
    private String rsvmemo;
}
