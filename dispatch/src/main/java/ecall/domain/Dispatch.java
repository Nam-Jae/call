package ecall.domain;

import ecall.DispatchApplication;
import ecall.domain.DispatchCanceled;
import ecall.domain.Dispatched;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dispatch_table")
@Data
//<<< DDD / Aggregate Root
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String carId;

    private String carType;

    private String workerId;

    private String dispatchTime;

    private Integer remains;

    public static DispatchRepository repository() {
        DispatchRepository dispatchRepository = DispatchApplication.applicationContext.getBean(
            DispatchRepository.class
        );
        return dispatchRepository;
    }

    public static void getHelp(Called called) {
        Dispatch dispatch = new Dispatch();
        dispatch.setId(called.getId());
        dispatch.setCarId(called.getCarId());
        dispatch.setCarType("Ambulance");
        dispatch.setWorkerId("worker"+ called.getId());
        dispatch.setDispatchTime(called.getAccidentTime()+"+3min");

        dispatch.setRemains(dispatch.getRemains() - 1);
        repository().save(dispatch);

        Dispatched dispatched = new Dispatched(dispatch);
        dispatched.publishAfterCommit();
    }

    public static void malfunction(CallCanceled callCanceled) {
        Dispatch dispatch = new Dispatch();
        dispatch.setId(callCanceled.getId());
        dispatch.setCarId(callCanceled.getCarId());
        dispatch.setCarType("Ambulance");
        dispatch.setWorkerId("worker"+ callCanceled.getId());
        dispatch.setDispatchTime(callCanceled.getAccidentTime()+"+1min");

        dispatch.setRemains(dispatch.getRemains() + 1);
        repository().save(dispatch);

        DispatchCanceled dispatchCanceled = new DispatchCanceled(dispatch);
        dispatchCanceled.publishAfterCommit();
    }

}
//>>> DDD / Aggregate Root
