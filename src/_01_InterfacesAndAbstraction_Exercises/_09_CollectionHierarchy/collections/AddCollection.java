package _01_InterfacesAndAbstraction_Exercises._09_CollectionHierarchy.collections;

import _01_InterfacesAndAbstraction_Exercises._09_CollectionHierarchy.interfaces.IAddable;

import java.util.ArrayList;
import java.util.List;

public class AddCollection  implements IAddable {

    private List<String> elements;

    public AddCollection() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.elements.add(element);
        return this.elements.size() - 1;
    }
}
