package netcracker;

import java.util.Arrays;

public class List {
    private static int id = -1;
    private Person[] ListOfPerson;
    private int length;

    /**
     * @param capacity
     */
    public List(int capacity) {
        ListOfPerson = new Person[capacity];
        length = capacity;
    }

    public int getLength() {
        return length;
    }

    /**
     *
     */
    void resize() {
        ListOfPerson = Arrays.copyOf(ListOfPerson, ListOfPerson.length * 2);
        length *= 2;
    }

    public void add(Person p) {
        if (++id < ListOfPerson.length - 1) {
            ListOfPerson[id] = p;
        } else {
            resize();
            ListOfPerson[id] = p;
        }
    }

    public Person getPerson(int id) {
        return ListOfPerson[id];
    }

    public void delete(int id) {
        int i = -1;

        for (Person p : ListOfPerson) {
            i++;
            if (p.getId() == id) {
                for (; i < ListOfPerson.length - 1; i++) {
                    ListOfPerson[i] = ListOfPerson[i + 1];
                }
                //ListOfPerson[i+1] = null;
                return;
            }
        }
    }

    public void printer() {
        for (Person p : ListOfPerson)
            if (p != null)
                System.out.println("ID: " + p.getId() + " SURNAME: " + p.getSurname() + " AGE: " + p.getAge());
    }
}
