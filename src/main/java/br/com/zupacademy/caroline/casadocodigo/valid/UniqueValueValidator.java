package br.com.zupacademy.caroline.casadocodigo.Valid;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValueValid, Object> {
    private String atributo;
    private Class<?> domainClass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValueValid constraintAnnotation) {
        this.atributo=constraintAnnotation.field();
        this.domainClass=constraintAnnotation.classe();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        String jpql= "select 1 from "+domainClass.getSimpleName()
                +" where "+atributo
                +" =:obj";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("obj",obj);
        List<?> list= query.getResultList();

        Assert.state(list.size()<=1,"Foi encontrado mais de um"+domainClass+"com o atributo" +domainClass+"="+obj);

        return list.isEmpty();
    }
}

