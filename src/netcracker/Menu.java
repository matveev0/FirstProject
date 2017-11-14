package netcracker;

import org.joda.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private List ListOfPerson = new List(5);

    public void ShowMenu() throws MyException {
        int Case = 0;
        while (Case != -1) {
            System.out.println("1 - Add person");
            System.out.println("2 - Delete person");
            System.out.println("3 - Printer");

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
                        ListOfPerson.add(p);

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 2: {
                    try{
                        System.out.print("ID: ");
                        in.nextLine();
                        String id = in.nextLine();
                        ListOfPerson.delete(Integer.parseInt(id));
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 3: {
                    ListOfPerson.printer();
                }
            }
        }
    }
}
