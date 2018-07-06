package _04_EnumerationsAndAnnotations_Exercises._06_CustomEnumAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomInfo {
    String category() default "";
    String description() default "";
    String type() default "Enumeration";
}
