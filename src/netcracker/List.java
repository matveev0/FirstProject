package netcracker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class List {
    private static int id = -1;
    private Person[] listOfPerson;
    private int length;

    /**
     * @param capacity размер списка
     */
    public List(int capacity) {
        listOfPerson = new Person[capacity];
        length = capacity;
    }

    public int getLength() {
        return length;
    }

    /**
     * Увеличение размера списка в 2 раза
     */
    void resize() {
        listOfPerson = Arrays.copyOf(listOfPerson, listOfPerson.length * 2);
        length *= 2;
    }

    /**
     * Добавление в список персоны.
     * В случае отсутствия места для вставки, увеличение размера
     *
     * @param p
     */
    public void add(Person p) {
        if (++id < listOfPerson.length - 1) {
            listOfPerson[id] = p;
        } else {
            resize();
            listOfPerson[id] = p;
        }
    }

    public Person getPerson(int id) {
        return listOfPerson[id];
    }

    /**
     * Удаление элемента в списке по id
     *
     * @param id Id удаляемого элемента. Удаляется первое вхождение.
     */
    public void delete(int id) {
        int i = -1;

        for (Person p : listOfPerson) {
            i++;
            if (p.getId() == id) {
                for (; i < listOfPerson.length - 1; i++) {
                    listOfPerson[i] = listOfPerson[i + 1];
                }
                //ListOfPerson[i+1] = null;
                return;
            }
        }
    }

    /**
     * Вывод в коноль списка персон
     */
    public void printer() {
        for (Person p : listOfPerson)
            if (p != null)
                System.out.println("ID: " + p.getId() + " SURNAME: " + p.getSurname() + " AGE: " + p.getAge());
    }

    public void search() {

    }

    public static final Comparator<Person> COMPARE_BY_ID = new Comparator<Person>() {
        @Override
        public int compare(Person lhs, Person rhs) {
            return lhs.getId() - rhs.getId();
        }
    };

    public static final Comparator<Person> COMPARE_BY_SURNAME = new Comparator<Person>() {
        @Override
        public int compare(Person lhs, Person rhs) {
            return lhs.getSurname().compareTo(rhs.getSurname());
        }
    };

    public static final Comparator<Person> COMPARE_BY_AGE = new Comparator<Person>() {
        @Override
        public int compare(Person lhs, Person rhs) {
            return lhs.getAge() - rhs.getAge();
        }
    };

    void bubbleSort(int field, Comparator<Person> comparator) {
        int n = listOfPerson.length;
        Person temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(comparator.compare(listOfPerson[j-1], listOfPerson[j])>0){
                    //swap elements
                    temp = listOfPerson[j-1];
                    listOfPerson[j-1] = listOfPerson[j];
                    listOfPerson[j] = temp;
                }
            }
        }
    }

    public void sort(int field) {
        switch (field) {
            case 1:
                Arrays.sort(listOfPerson, COMPARE_BY_AGE);
                break;
            case 2:
                Arrays.sort(listOfPerson, COMPARE_BY_SURNAME);
                break;
            case 3:
                Arrays.sort(listOfPerson, COMPARE_BY_ID);
                break;
        }
    }
}
