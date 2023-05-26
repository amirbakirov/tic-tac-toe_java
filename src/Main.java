import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Character>> table = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Character> helpArr = new ArrayList<Character>();
            for (int j = 0; j < 3; j++) {
                helpArr.add('e');
            }
            table.add(helpArr);
        }
        System.out.println("Добро пожаловать в игру \"Крестики-нолики\"");

        Boolean whose_move = true; // true - крестики, false - нолики
        while (true) {
            CreateMap(table);
            if (whose_move) {
                System.out.println("Ход крестика. Чтобы ходить введите букву и цифру, например: a1");
            } else {
                System.out.println("Ход нолика. Чтобы ходить введите букву и цифру, например: a1");
            }
            String motion = sc.nextLine();
            if (motion.equals("")) {
                System.out.println("Некорректный ход. Попробуйте еще раз.");
                continue;
            }

            int one = -1;

            if (motion.charAt(0) == 'a') {
                one = 0;
            } else if (motion.charAt(0) == 'b') {
                one = 1;
            } else if (motion.charAt(0) == 'c') {
                one = 2;
            } else {
                System.out.println("Некорректный ход. Попробуйте еще раз.");
                continue;
            }
            char two = motion.charAt(1);
            if ((int) (two - '0') > 2) {
                System.out.println("Некорректный ход. Попробуйте еще раз.");
                continue;
            }

            if (table.get((int) (two - '0')).get(one) != 'e') {
                System.out.println("Неверный ход.");
                continue;
            }

            if (whose_move) {
                table.get((int) (two - '0')).set(one, 'X');
            } else {
                table.get((int) (two - '0')).set(one, 'O');
            }

            if ((table.get(0).get(0) != 'e' && table.get(0).get(0) == table.get(0).get(1) && table.get(0).get(0) == table.get(0).get(2)) ||
                    (table.get(1).get(0) != 'e' && table.get(1).get(0) == table.get(1).get(1) && table.get(1).get(0) == table.get(1).get(2)) ||
                    (table.get(2).get(0) != 'e' && table.get(2).get(0) == table.get(2).get(1) && table.get(2).get(0) == table.get(2).get(2)) ||
                    (table.get(0).get(0) != 'e' && table.get(0).get(0) == table.get(1).get(1) && table.get(0).get(0) == table.get(2).get(2)) ||
                    (table.get(0).get(2) != 'e' && table.get(0).get(2) == table.get(1).get(1) && table.get(0).get(2) == table.get(2).get(0)) ||
                    (table.get(0).get(0) != 'e' && table.get(0).get(0) == table.get(1).get(0) && table.get(0).get(0) == table.get(2).get(0)) ||
                    (table.get(0).get(1) != 'e' && table.get(0).get(1) == table.get(1).get(1) && table.get(0).get(1) == table.get(2).get(1)) ||
                    (table.get(0).get(2) != 'e' && table.get(0).get(2) == table.get(1).get(2) && table.get(0).get(2) == table.get(2).get(2))) {
                CreateMap(table);
                System.out.print("Выиграли ");
                if (whose_move) {
                    System.out.println("крестики");
                } else {
                    System.out.println("нолики");
                }
                break;
            }
            whose_move = !whose_move;
        }
    }

    public static void CreateMap(ArrayList<ArrayList<Character>> table) {
        for (int i = 0; i < 3; i++) {
            System.out.println(" +---+---+---+");
            System.out.print(i);

            String s = "";
            for (int j = 0; j < 3; j++) {
                char c = table.get(i).get(j);
                if (c == 'e') c = ' ';
                s += "| " + c + " ";
            }
            s += "|";
            System.out.println(s);
        }
        System.out.println(" +---+---+---+");
        System.out.println("   a   b   c");
    }
}