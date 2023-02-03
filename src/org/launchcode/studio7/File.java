package org.launchcode.studio7;

public class File {

    private final String name;
    private final int size;
    private final String fileType;

    public File(String name, int size, String fileType) {
        this.name = name;
        this.size = size;
        this.fileType = fileType;
    }
    @Override
    public String toString() {
        return name + " - " + size + " MB";
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getFileType() {
        return fileType;
    }
}
