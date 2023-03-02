package org.example;

import java.util.ArrayList;
import java.util.List;

public class Toy {
    protected int id; //id игрушки
    protected String name; // текстовое название
    protected int count; // количество


    public Toy(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }

    public static int prize(List<Toy> toys) {
        while (true) {
            if (toys.size() > 1) {
                int id = (int) (Math.random() * toys.size());
                if (toys.size() > 0 && toys.get(id).getCount() > 0){
                    toys.get(id).setCount(toys.get(id).getCount() - 1);
                    return id;
                } else {
                    toys.remove(id);
                }
            } else {
                break;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }


}
