package netcracker;

import org.joda.time.LocalDate;

public class Person {
    private int id;
    private String Surname;
    private LocalDate DateOfBirth;

    public Person(int id, String surname, LocalDate DateOfBirth) {
        this.id = id;
        Surname = surname;
        this.DateOfBirth = DateOfBirth;
    }

    public String getSurname() {
        return Surname;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public int getId() {
        return id;
    }

    /**
     * Возвращает возраст персоны с помощью указанного дня рождения
     * @return
     */
    public int getAge() {
        int age = LocalDate.now().getYear() - DateOfBirth.getYear();
        if (LocalDate.now().getDayOfYear() <= DateOfBirth.getDayOfYear())
            age--;
        return age;
    }

}
