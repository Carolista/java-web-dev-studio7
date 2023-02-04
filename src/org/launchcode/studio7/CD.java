package org.launchcode.studio7;

public class CD extends BaseDisc {

    // TODO: Implement your custom interface.
    // Note: I actually implemented it on BaseDisc, but this is probably not
    // the best approach given the scope bonus missions

    // TODO: Determine which fields, methods, and constructors can be extended from the base class and which ones
    //  need to be declared separately.

    private final String genre;

    public CD(String title, String author, String discType, String productionCo, String genre) {
        super(title, author, discType, productionCo);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() +
                getFormattedFiles("Tracks") +
                "\nGenre: " + genre;
    }

    @Override
    public void readData() {
        System.out.println(this);
    }

    @Override
    public void runFile(File file){
        System.out.println("\nYou are now enjoying \"" + file.getName() + "\" by " + getAuthor() + ".");
    }

    @Override
    public void writeData(File file) {
        if (!file.getFileType().equals("audio")) {
            System.out.printf("The " + file.getFileType() + " type cannot be written to a CD.");
        } else if (getSpaceUsed() + file.getSize() > CAPACITIES.get(getDiscType())) {
            System.out.println("There is not enough space on the " +
                    getDiscType() + " for " + file.getName());
        } else {
            getFiles().add(file);
        }
    }

}
