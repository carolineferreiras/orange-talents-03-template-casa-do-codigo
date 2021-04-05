package br.com.zupacademy.caroline.casadocodigo.Valid;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.MODULE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistIdValidator.class)
@Repeatable(ExistId.List.class)
public @interface ExistId {

    String message() default "Não existe registro vinculado a este identificador";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> domainClass();

    @Documented
    @Target({ElementType.FIELD,ElementType.TYPE,ElementType.MODULE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List{
        ExistId[] value();
    }
}
