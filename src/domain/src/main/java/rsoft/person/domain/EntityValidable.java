package rsoft.person.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;

public abstract class EntityValidable<T> {

    protected ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    protected Validator validator = factory.getValidator();
    protected Set<ConstraintViolation<T>> violations = null;

    public boolean isValid() {
        this.validate();
        return violations.isEmpty();
    }

    public List<Violation> getViolationMessages() {
        this.validate();
        return violations
                .stream().map(violation -> new Violation(violation.getPropertyPath().toString(), violation.getMessage()))
                .toList();
    }

    private void validate() {
        violations = isNull(violations)
                ? validator.validate(getInstance())
                : violations;
    }

    protected abstract T getInstance();

}
