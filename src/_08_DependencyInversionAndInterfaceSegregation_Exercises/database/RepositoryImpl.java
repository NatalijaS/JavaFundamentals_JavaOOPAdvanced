package _08_DependencyInversionAndInterfaceSegregation_Exercises.database;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.Repository;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Constants;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.Modelable;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions.DuplicateModelException;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions.NonExistantModelException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<T extends Modelable> implements Repository<T> {

    private Map<String, T> itemsByModel;

    RepositoryImpl() {
        this.itemsByModel = new HashMap<>();
    }

    @Override
    public void add(T item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public T getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTING_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }

    @Override
    public Collection<T> getAll() {
        return this.itemsByModel.values();
    }
}
