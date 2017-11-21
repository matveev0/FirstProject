package netcracker;

import org.joda.time.LocalDate;

import java.util.Scanner;

public class Menu {

    private List listOfPerson = new List(5);

    /**
     * Метод для вывода меню в консоль для работы со списком
     *
     * @throws MyException
     */
    public void ShowMenu() throws MyException {
        int Case = 0;
        addRndPerson();

        while (Case != -1) {
            System.out.println("1 - Add person");
            System.out.println("2 - Delete person");
            System.out.println("3 - Printer");
            System.out.println("4 - Sort");
            System.out.println("5 - Search");

            Scanner in = new Scanner(System.in);
            Case = in.nextInt();

            switch (Case) {
                case 1: {
                    try {
                        Person p;
                        System.out.print("Surname: ");
                        String surname = in.nextLine(); //почему пропускает строку?
                        surname = in.nextLine();
                        System.out.print("ID: ");
                        String id = in.nextLine();
                        System.out.print("Date of birth (YYYY MM DD): ");
                        String[] DateOfBirth = in.nextLine().split(" ");
                        p = new Person(Integer.parseInt(id), surname, new LocalDate(Integer.parseInt(DateOfBirth[0]),
                                Integer.parseInt(DateOfBirth[1]),
                                Integer.parseInt(DateOfBirth[2])));
                        listOfPerson.add(p);

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("ID: ");
                        in.nextLine();
                        String id = in.nextLine();
                        listOfPerson.delete(Integer.parseInt(id));
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 3: {
                    listOfPerson.printer();
                    break;
                }
                case 4: {
                    System.out.println("Select the sort type");
                    String typeSort, typeField;
                    System.out.println("1) BubbleSort    2)ShellSort   3)QuickSort");
                    typeSort = in.nextLine();
                    typeSort = in.nextLine();
                    System.out.println("Select the field");
                    System.out.println("1) ID    2)Surname   3)Age");
                    typeField = in.nextLine();

                    switch (typeField + typeSort) {
                        case "11":
                            listOfPerson.sort(List.Typefield.id, List.Sorttype.bubble);
                            break;
                        case "12":
                            listOfPerson.sort(List.Typefield.id, List.Sorttype.shell);
                            break;
                        case "13":
                            listOfPerson.sort(List.Typefield.id, List.Sorttype.quick);
                            break;
                        case "21":
                            listOfPerson.sort(List.Typefield.surname, List.Sorttype.bubble);
                            break;
                        case "22":
                            listOfPerson.sort(List.Typefield.surname, List.Sorttype.shell);
                            break;
                        case "23":
                            listOfPerson.sort(List.Typefield.surname, List.Sorttype.quick);
                            break;
                        case "31":
                            listOfPerson.sort(List.Typefield.age, List.Sorttype.bubble);
                            break;
                        case "32":
                            listOfPerson.sort(List.Typefield.age, List.Sorttype.shell);
                            break;
                        case "33":
                            listOfPerson.sort(List.Typefield.age, List.Sorttype.quick);
                            break;
                    }
                }
                break;
                case 5:
                    System.out.println("Enter surname");
                    String surname = in.nextLine();
                    surname = in.nextLine();
                    Person p = listOfPerson.search(surname);
                    if (p != null)
                        System.out.println("ID: " + p.getId() + " SURNAME: " + p.getSurname() + " AGE: " + p.getAge());
                    else
                        System.out.println("Person doesn`t exist");
            }
        }
    }

    void addRndPerson() {
        Person p1 = new Person(1, "Матвеев543", new LocalDate(1999, 10, 11));
        Person p2 = new Person(2, "Матвеев123", new LocalDate(1990, 1, 25));
        Person p3 = new Person(3, "Матвеев4", new LocalDate(1977, 3, 8));
        Person p4 = new Person(4, "Матвеев1", new LocalDate(1917, 1, 1));
        Person p5 = new Person(5, "Матвеев3423", new LocalDate(1927, 5, 15));
        Person p6 = new Person(6, "Матвеев7", new LocalDate(1957, 11, 15));
        Person p7 = new Person(7, "Матвеев3", new LocalDate(1931, 1, 15));

        listOfPerson.add(p1);
        listOfPerson.add(p2);
        listOfPerson.add(p3);
        listOfPerson.add(p4);
        listOfPerson.add(p5);
        listOfPerson.add(p6);
        listOfPerson.add(p7);
    }
}
