package de.medieninformatik.softwaretechnik;

public class Cooler extends TempMachine {

    private final int MAX_TEMP = 40;
    private boolean isCoolerOn = false;

    /**
     *  Aendert die von der Kuehlung gespeicherten Temperatur im Smart-Home und stellt die Kuehlung nach Bedarf an, bzw. aus.
     *  @param newTemp Vom Temperatursensor uebermittelte Temperatur
     */
    @Override
    public void changeTemp(int newTemp) {
        //schalte Kühlung ein, falls Kühlung aus, und Temp über MAX_TEMP
        if (newTemp > MAX_TEMP && !isCoolerOn) {
            turnCoolingOn();
        }
        //schalte Kühlung aus, falls Kühlung ein, und Temp unter MAX_TEMP
        else if (newTemp <= MAX_TEMP && isCoolerOn) {
            turnCoolingOff();
        }
    }

    private void turnCoolingOn() {
        //gibt an, dass Kühlung an ist
        isCoolerOn = true;
        System.out.println("Kühlung eingeschaltet.");
    }

    private void turnCoolingOff() {
        //gibt an, dass Kühlung aus ist
        isCoolerOn = false;
        System.out.println("Kühlung ausgeschaltet.");
    }
}
