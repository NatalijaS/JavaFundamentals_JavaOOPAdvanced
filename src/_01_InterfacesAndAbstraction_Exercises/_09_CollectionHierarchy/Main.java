package _01_InterfacesAndAbstraction_Exercises._09_CollectionHierarchy;

import _01_InterfacesAndAbstraction_Exercises._09_CollectionHierarchy.collections.AddCollection;
import _01_InterfacesAndAbstraction_Exercises._09_CollectionHierarchy.collections.AddRemoveCollection;
import _01_InterfacesAndAbstraction_Exercises._09_CollectionHierarchy.collections.MyList;
import _01_InterfacesAndAbstraction_Exercises._09_CollectionHierarchy.interfaces.IAddable;
import _01_InterfacesAndAbstraction_Exercises._09_CollectionHierarchy.interfaces.IRemovable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        IAddable collection1 = new AddCollection();
        IRemovable collection2 = new AddRemoveCollection();
        IRemovable collection3 = new MyList();
        String[] input = reader.readLine().split("\\s+");
        int number = Integer.parseInt(reader.readLine());

        addElementsToCollection(collection1, input);
        addElementsToCollection(collection2, input);
        addElementsToCollection(collection3, input);

        removeElementsFromCollection(collection2, number);
        removeElementsFromCollection(collection3, number);
    }

    private static void removeElementsFromCollection(IRemovable collection, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void addElementsToCollection(IAddable collection, String[] input) {
        for (String s : input) {
            System.out.print(collection.add(s) + " ");
        }
        System.out.println();
    }
}
