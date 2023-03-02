package org.example;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Toy chess = new Toy(0, "Шахматы", 2);
        Toy backgammon = new Toy(1, "Нарды", 3);
        Toy car = new Toy(2, "Машинка", 1);
//        Toy gun = new Toy(3, "Пистолет", 20);
//        Toy doll = new Toy(4, "Кукла", 3);

        List<Toy> toys = new ArrayList();
        toys.add(chess);
        toys.add(backgammon);
        toys.add(car);
//        toys.add(gun);
//        toys.add(doll);
        Scanner scanner = new Scanner(System.in);
        FileWriter fw = new FileWriter("my_toys.txt");
        while (true) {
            System.out.println("Участвуют в розыгрыше:");
            for (int i = 0; i < toys.size(); i++) {
                if (toys.get(i).getCount() > 0) {
                    System.out.printf("%s %s шт.\n", toys.get(i).getName(), toys.get(i).getCount());
                }
            }
            System.out.println("Разыграть приз? (y)");
            String prize = scanner.nextLine();
            if (prize.equals("y")) {
                int id = Toy.prize(toys);
                if (id != -1 && toys.size() >= 1) {
                    System.out.printf("Вы выиграли %s\n", toys.get(id).getName());
                    fw.write(toys.get(id).getName());
                } else {
                    System.out.println("Больше не осталось призов! Вы всё выиграли! ))");
                    break;
                }

            } else {
                System.out.println("До свидос!");

                break;
            }
        }
        fw.close();
    }
}