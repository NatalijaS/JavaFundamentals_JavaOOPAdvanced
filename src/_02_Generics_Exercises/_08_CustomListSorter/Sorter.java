package _02_Generics_Exercises._08_CustomListSorter;


class Sorter {
    static <T extends Comparable<T>> void sort(CustomList<T> list) {
        list.getList().sort(Comparable::compareTo);
    }
}
