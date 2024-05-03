package com.kidwiz.web.DTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CareerTestResultDTO {

    private int rid;
    private int sid;
    private int tid;
    private int tscore;
    private LocalDateTime tdate;
}
