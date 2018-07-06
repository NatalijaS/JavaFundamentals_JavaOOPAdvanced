package _03_IteratorsAndComparators_Exercises._08_PetClinics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Room> {
    private String name;
    private Room[] rooms;
    private List<Integer> accommodationIndexes;

    Clinic(String name, int count) {
        this.setName(name);
        this.setRooms(count);
        this.setAccommodationIndexes();
    }

    boolean addPet(Pet pet) {
        Iterable<Integer> indexes = this.getAccommodationIndexes();

        for (Integer index : indexes) {
            if (this.rooms[index] == null) {
                this.rooms[index] = new Room(pet);
                return true;
            }
        }
        return false;
    }

    boolean hasEmptyRoom() {
        return Arrays.asList(this.rooms).contains(null);
    }

    boolean release() {
        Iterator<Room> releaseIterator = new ReleaseIterator();
        while (releaseIterator.hasNext()) {
            if (releaseIterator.next() != null) {
                releaseIterator.remove();
                return true;
            }
        }
        return false;
    }

    Room getRoomByIndex(int index) {
        return this.rooms[index - 1];
    }

    @Override
    public Iterator<Room> iterator() {
        return new ClinicIterator();
    }

    private Iterable<Integer> getAccommodationIndexes() {
        return this.accommodationIndexes;
    }

    private void setAccommodationIndexes() {
        this.accommodationIndexes = new ArrayList<>();
        int middleIndex = rooms.length / 2;
        this.accommodationIndexes.add(middleIndex);
        if (middleIndex == 0) {
            return;
        }
        int leftIndex = middleIndex - 1;
        int rightIndex = middleIndex + 1;

        for (int i = 0; i < middleIndex; i++) {
            if (leftIndex >= 0) {
                this.accommodationIndexes.add(leftIndex--);
            }
            if (rightIndex < rooms.length) {
                this.accommodationIndexes.add(rightIndex++);
            }
        }
    }

    private void setRooms(int count) {
        if (count % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Room[count];
    }

    private void setName(String name) {
        this.name = name;
    }

    private final class ClinicIterator implements Iterator<Room> {
        private int index;

        ClinicIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Room next() {
            return rooms[this.index++];
        }
    }

    private final class ReleaseIterator implements Iterator<Room> {
        private int index;
        private List<Integer> releaseIndexes;

        ReleaseIterator() {
            this.index = 0;
            this.setReleaseIndexes();
        }

        @Override
        public boolean hasNext() {
            return this.index < this.releaseIndexes.size();
        }

        @Override
        public Room next() {
            return rooms[this.releaseIndexes.get(this.index++)];
        }

        @Override
        public void remove() {
            rooms[this.releaseIndexes.get(this.index - 1)] = null;
        }

        private void setReleaseIndexes() {
            this.releaseIndexes = new ArrayList<>();
            int middleIndex = rooms.length / 2;
            this.releaseIndexes.add(middleIndex);
            if (middleIndex == 0) {
                return;
            }

            for (int i = middleIndex + 1; i < rooms.length; i++) {
                this.releaseIndexes.add(i);
            }

            for (int i = middleIndex - 1; i >= 0; i--) {
                this.releaseIndexes.add(i);
            }
        }
    }
}