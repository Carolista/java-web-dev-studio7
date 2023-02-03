package org.launchcode.studio7;

import java.util.ArrayList;

public abstract class BaseDisc implements OpticalDisc {

    private final String title;
    private final String author;
    private final String discType;
    private final int speed;
    private final int capacity;
    private ArrayList<File> files = new ArrayList<>();

    public BaseDisc(String title, String author, String discType) {
        this.title = title;
        this.author = author;
        this.discType = discType;
        this.speed = SPEEDS.get(discType);
        this.capacity = CAPACITIES.get(discType);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDiscType() {
        return discType;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public String toString() {
        return "\n" + discType + ":" +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nSpeed: " + speed + " RPM" +
                "\nStorage Capacity: " + capacity;
    }

    public int getSpaceUsed() {
        int total = 0;
        for (File file : files) {
            total += file.getSize();
        }
        return total;
    }

    @Override
    public void spinDisc() {
        System.out.printf("The " + discType + " " + title +
                " is spinning at " + speed + " RPM.");
    }

    @Override
    public abstract void readData();

    @Override
    public abstract void runFile(File file);

    @Override
    public void writeData(File file) {
        if (getSpaceUsed() + file.getSize() > capacity) {
            System.out.println("There is not enough space on the " +
                    discType + " for " + file.getName());
        } else {
            files.add(file);
        }
    }
}
