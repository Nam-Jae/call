package ecall.infra;

import ecall.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DispatchHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Dispatch>> {

    @Override
    public EntityModel<Dispatch> process(EntityModel<Dispatch> model) {
        return model;
    }
}
