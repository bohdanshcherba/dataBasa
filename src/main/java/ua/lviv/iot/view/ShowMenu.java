package ua.lviv.iot.view;

public class ShowMenu {
    public void displayMenu() {
        System.out.println("┌⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊|⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊┓");
        System.out.println("|              Table:              |                CRUD:               |");
        System.out.println("|__________________________________|____________________________________|");
        System.out.println("|   |                              |   |                                |");
        System.out.println("| 1 | car                          | 1 | GET ALL                        |");
        System.out.println("| 2 | location                     | 2 | CREATE                         |");
        System.out.println("| 3 | user                         | 3 | UPDATE                         |");
        System.out.println("| 4 | fine                         | 4 | DELETE                         |");
        System.out.println("|   |                              |   |                                |");
        System.out.println("| 0 | close                        | 0 | menu                           |");
        System.out.println("L___|______________________________|___|________________________________⅃");
    }
}
