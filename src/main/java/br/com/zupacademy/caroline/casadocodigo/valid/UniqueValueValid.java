package br.com.zupacademy.caroline.casadocodigo.Valid;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValueValid {
    //mensagem de validação
    String message() default "Já existe esse campo cadastrado";
     //definição do grupo que irá utilizar, quase nunca utilizado
    Class<?>[] groups() default {};

    //Mandar informação a mais
    Class<? extends Payload>[] payload() default {};

    String field();
    Class<?> classe();
}
