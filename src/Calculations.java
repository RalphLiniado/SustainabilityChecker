public class Calculations extends StartFrame{
    // House Energy Use Calculations
    public void calculateEnergy() {
        energyPerPerson = energyInt / personsInt;
        double energyWeight = energyPerPerson * 0.994;
        System.out.println(energyWeight);
    }

    // Car Energy Use Calculations
    public void calculateCarEnergy() {
        int gasUsage = milesInt / MPGInt;
        double gasWeight = gasUsage * 19.6;
        System.out.println(gasWeight);
    }
}