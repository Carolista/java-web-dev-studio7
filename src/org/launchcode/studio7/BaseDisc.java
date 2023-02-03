package org.launchcode.studio7;

import java.util.ArrayList;

public abstract class BaseDisc implements OpticalDisc {

    private final String title;
    private final String author;
    private final String discType;
    private final String productionCo;
    private ArrayList<File> files = new ArrayList<>();

    public BaseDisc(String title, String author, String discType, String productionCo) {
        this.title = title;
        this.author = author;
        this.discType = discType;
        this.productionCo = productionCo;
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

    public String getProductionCo() {
        return productionCo;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public String toString() {
        return "\n***** " + discType + " *****" +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nProduction Company: " + productionCo +
                "\nSpeed: " + SPEEDS.get(discType) + " RPM" +
                "\nStorage Capacity: " + CAPACITIES.get(discType) +
                "\nSpace Available: " + getSpaceAvailable();
    }

    public int getSpaceUsed() {
        int total = 0;
        for (File file : files) {
            total += file.getSize();
        }
        return total;
    }

    public int getSpaceAvailable() {
        return CAPACITIES.get(discType) - getSpaceUsed();
    }

    public String getFormattedFiles(String header) {
        StringBuilder fileList = new StringBuilder();
        if (files.size() > 0) {
            fileList.append("\n").append(header).append(":");
            for (File file : files) {
                fileList.append("\n\t").append(file);
            }
        }
        return fileList.toString();
    }

    @Override
    public void spinDisc() {
        System.out.printf("\nThe " + discType + " " + title +
                " is spinning at " + SPEEDS.get(discType) + " RPM.\n");
    }

    @Override
    public abstract void readData();

    @Override
    public abstract void runFile(File file);

    @Override
    public abstract void writeData(File file);
}
