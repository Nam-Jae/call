package ecall.domain;

import ecall.domain.*;
import ecall.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Called extends AbstractEvent {

    private Long id;
    private String carId;
    private String driverName;
    private String position;
    private String accidentTime;
}
