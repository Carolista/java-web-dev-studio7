package org.launchcode.studio7;

import java.util.ArrayList;
import java.util.Collections;

public class DVD extends BaseDisc {

    // TODO: Implement your custom interface.
    // Note: I actually implemented it on BaseDisc, but this is probably not
    // the best approach given the scope bonus missions

    // TODO: Determine which fields, methods, and constructors can be extended from the base class and which ones
    //  need to be declared separately.

    private final ArrayList<String> leadActors = new ArrayList<>();

    public DVD(String title, String author, String discType, String productionCo, String[] actorArray) {
        super(title, author, discType, productionCo);
        Collections.addAll(leadActors, actorArray);
    }

    public ArrayList<String> getLeadActors() {
        return leadActors;
    }

    @Override
    public String toString() {
        StringBuilder actorList = new StringBuilder();
        if (leadActors.size() > 0) {
            actorList.append("\nLead Actors:\n");
            for (String actor : leadActors) {
                actorList.append("\t").append(actor).append("\n");
            }
        }
        return super.toString() +
                getFormattedFiles("Segments") +
                actorList;
    }

    @Override
    public void readData() {
        System.out.println(this);
    }

    @Override
    public void runFile(File file){
        System.out.println("\nYou are now watching \"" + file.getName() + ".\"");
    }

    @Override
    public void writeData(File file) {
        if (getSpaceUsed() + file.getSize() > CAPACITIES.get(getDiscType())) {
            System.out.println("There is not enough space on the " +
                    getDiscType() + " for " + file.getName());
        } else {
            getFiles().add(file);
        }
    }

}
