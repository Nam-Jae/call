package ecall.domain;

import ecall.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Dispatched extends AbstractEvent {

    private Long id;
    private String carId;
    private String carType;
    private String workerId;
    private String dispatchTime;
}
