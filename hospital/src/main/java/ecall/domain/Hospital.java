package ecall.domain;

import ecall.HospitalApplication;
import ecall.domain.Canceled;
import ecall.domain.Reserved;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Hospital_table")
@Data
//<<< DDD / Aggregate Root
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hospitalId;

    private String hospitalName;

    private String address;

    @PostPersist
    public void onPostPersist() {
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();

        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();
    }

    public static HospitalRepository repository() {
        HospitalRepository hospitalRepository = HospitalApplication.applicationContext.getBean(
            HospitalRepository.class
        );
        return hospitalRepository;
    }

    //<<< Clean Arch / Port Method
    public static void book(Dispatched dispatched) {
        //implement business logic here:

        /** Example 1:  new item 
        Hospital hospital = new Hospital();
        repository().save(hospital);

        Reserved reserved = new Reserved(hospital);
        reserved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(dispatched.get???()).ifPresent(hospital->{
            
            hospital // do something
            repository().save(hospital);

            Reserved reserved = new Reserved(hospital);
            reserved.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void bookCancel(DispatchCanceled dispatchCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Hospital hospital = new Hospital();
        repository().save(hospital);

        Canceled canceled = new Canceled(hospital);
        canceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(dispatchCanceled.get???()).ifPresent(hospital->{
            
            hospital // do something
            repository().save(hospital);

            Canceled canceled = new Canceled(hospital);
            canceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
