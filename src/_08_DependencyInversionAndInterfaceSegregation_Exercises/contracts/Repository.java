package _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions.DuplicateModelException;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions.NonExistantModelException;

import java.util.Collection;

public interface Repository<T extends Modelable> {

    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;

    Collection<T> getAll();
}
