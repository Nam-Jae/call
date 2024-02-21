package ecall.domain;

import ecall.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Called extends AbstractEvent {

    private Long id;
    private String carId;
    private String driverName;
    private String position;
    private String accidentTime;
}
