package com.kidwiz.web.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RsvDTO {

    private int rsvno;
    private int sid, state;
    private int proid;
    private String ctype, date;
    private String ctime;
    private LocalDate cdate;
    private LocalDate rsvdate;
    private String rsvmemo;
    private String major_head;
}
