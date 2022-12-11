package de.medieninformatik.softwaretechnik;

public class Heater extends TempMachine {

    private final int MIN_TEMP = -10;
    private boolean isHeaterOn = false;

    /**
     * Aendert die von der Heizung gespeicherten Temperatur im Smart-Home und stellt die Heizung nach Bedarf an, bzw. aus.
     * @param newTemp Vom Temperatursensor uebermittelte Temperatur
     */
    @Override
    public void changeTemp(int newTemp) {
        //schalte Heizung ein, falls Heizung aus, und Temp unter MIN_TEMP
        if (newTemp < MIN_TEMP && !isHeaterOn) {
            turnHeaterOn();
        }
        //schalte Heizung aus, falls Heizung an, und Temp über MIN_TEMP
        else if (newTemp >= MIN_TEMP && isHeaterOn) {
            turnHeaterOff();
        }
    }

    private void turnHeaterOn() {
        //gibt aus, dass Heizung an ist
        isHeaterOn = true;
        System.out.println("Heizung eingeschaltet.");
    }

    private void turnHeaterOff() {
        //gibt aus, dass Heizung aus ist
        isHeaterOn = false;
        System.out.println("Heizung ausgeschaltet.");
    }
}
