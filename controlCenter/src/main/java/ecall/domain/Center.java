package ecall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Center_table")
@Data
public class Center {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String carId;
    private String driverName;
    private String workerId;
    private String position;
    private String hospitalId;
    private String address;
    private String accidentTime;
    private String dispatchTime;
}
