package org.launchcode.studio7;

public class Main {

    public static void main(String[] args){

        // TODO: Declare and initialize a CD and a DVD object.
        CD theNorthBorders = new CD("The North Borders", "Bonobo", "CD", "Ninja Tune", "downtempo");
        File firstFires = new File("First Fires", 50, "audio");
        File cirrus = new File("Cirrus", 60, "audio");
        File transit = new File("Transit", 60, "audio");

        String[] friendsActors = new String[] {
                "Jennifer Aniston",
                "Courteney Cox",
                "Lisa Kudrow",
                "Matt LeBlanc",
                "Matthew Perry",
                "David Schwimmer"
        };
        DVD friendsS3 = new DVD(
                "Friends Season 3",
                "David Crane & Marta Kauffman",
                "DVD",
                "Bright/Kauffman/Crane Productions",
                friendsActors
                );
        File s3e1 = new File("The One with the Princess Leia Fantasy", 420, "video");
        File s3e2 = new File("The One Where No One's Ready", 430, "video");
        File s3e3 = new File("The One with the Jam", 415, "video");
        File s3e4 = new File("The One with the Metaphorical Tunnel", 425, "video");

        // TODO: Call each CD and DVD method to verify that they work as expected.

        theNorthBorders.spinDisc();
        theNorthBorders.readData(); // no files yet
        theNorthBorders.writeData(firstFires);
        theNorthBorders.writeData(cirrus);
        theNorthBorders.writeData(transit);
        theNorthBorders.readData(); // tracks listed
        theNorthBorders.runFile(cirrus);

        friendsS3.spinDisc();
        friendsS3.readData(); // no files yet
        friendsS3.writeData(s3e1);
        friendsS3.writeData(s3e2);
        friendsS3.writeData(s3e3);
        friendsS3.writeData(s3e4);
        friendsS3.readData(); // segments listed
        friendsS3.runFile(s3e4);


    }
}
