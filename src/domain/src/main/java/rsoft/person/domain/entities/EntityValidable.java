package rsoft.person.domain.entities;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;

public abstract class EntityValidable<T extends EntityValidable<T>> {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    protected Set<ConstraintViolation<T>> violations = null;

    public boolean isValid() {
        this.validate();
        return violations.isEmpty();
    }

    public boolean isNotValid() {
        return !isValid();
    }

    public List<Violation> getViolationMessages() {
        this.validate();
        return violations
                .stream().map(violation -> new Violation(violation.getPropertyPath().toString(), violation.getMessage()))
                .toList();
    }

    protected void validate() {
        violations = isNull(violations)
                ? validator.validate(getInstance())
                : violations;
    }

    protected T getInstance() {;
        //noinspection unchecked
        return (T) this;
    }

}
