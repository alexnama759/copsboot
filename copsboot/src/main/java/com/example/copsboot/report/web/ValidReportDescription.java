package com.example.copsboot.report.web;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //<1>
@Retention(RetentionPolicy.RUNTIME) //<2>
@Constraint(validatedBy = {ReportDescriptionValidator.class})
public @interface ValidReportDescription {
    String message() default "Invalid report description";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}