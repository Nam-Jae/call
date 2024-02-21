package ecall.domain;

import ecall.domain.*;
import ecall.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String hospitalId;
    private String hospitalName;
    private String address;

    public Canceled(Hospital aggregate) {
        super(aggregate);
    }

    public Canceled() {
        super();
    }
}
//>>> DDD / Domain Event
