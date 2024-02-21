package ecall.domain;

import ecall.domain.*;
import ecall.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Dispatched extends AbstractEvent {

    private Long id;
    private String carId;
    private String carType;
    private String workerId;
    private String dispatchTime;

    public Dispatched(Dispatch aggregate) {
        super(aggregate);
    }

    public Dispatched() {
        super();
    }
}
//>>> DDD / Domain Event
