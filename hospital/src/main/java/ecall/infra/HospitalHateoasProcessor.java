package ecall.infra;

import ecall.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class HospitalHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Hospital>> {

    @Override
    public EntityModel<Hospital> process(EntityModel<Hospital> model) {
        return model;
    }
}
