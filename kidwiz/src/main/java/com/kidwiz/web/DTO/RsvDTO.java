package com.kidwiz.web.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RsvDTO {

    private int rsvno;
    private int sid;
    private int proid;
    private String ctype;
    private String ctime;
    private LocalDate cdate;
    private LocalDate rsvdate;
    private String rsvmemo;
}
