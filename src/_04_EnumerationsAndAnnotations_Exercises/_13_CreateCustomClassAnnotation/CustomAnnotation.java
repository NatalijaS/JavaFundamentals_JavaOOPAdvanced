package _04_EnumerationsAndAnnotations_Exercises._13_CreateCustomClassAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAnnotation {

    String author() default "";

    int revision() default 0;

    String description() default "";

    String[] reviewers() default "";
}
