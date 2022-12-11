package de.medieninformatik.softwaretechnik;

public class Main {

    public static void main(String[] args) {

        //Verbindung der Klimaanlage mit dem Temperatursensor
        TempSensor sensor = new TempSensor();

        //Instanziierung der Klimanlage
        Heater heater1 = new Heater();
        Heater heater2 = new Heater();
        Cooler cooler1 = new Cooler();
        Cooler cooler2 = new Cooler();

        //Für jede neue Heizung oder Kühlung wird ein neuer Beobachter erzeugt, der sich beim Sensor anmeldet
        TempViewer tempViewerHeater1 = new TempViewer(sensor, heater1, "tempViewerHeater1");
        TempViewer tempViewerHeater2 = new TempViewer(sensor, heater2, "tempViewerHeater2");
        TempViewer tempViewerCooler1 = new TempViewer(sensor, cooler1, "tempViewerCooler1");
        TempViewer tempViewerCooler2 = new TempViewer(sensor, cooler2, "tempViewerCooler2");

        //Simulation einer Temperaturänderung im Smart-Home
        sensor.setTemp(0);
        System.out.println();       //Keine Geräte eingeschaltet

        sensor.setTemp(-20);
        System.out.println();       //Heizung schaltet sich ein

        sensor.setTemp(60);
        System.out.println();       //Heizung schaltet sich wieder aus, Kühlung aber an

        sensor.setTemp(20);
        System.out.println();       //Kühlung schaltet sich auch wieder aus

    }
}
