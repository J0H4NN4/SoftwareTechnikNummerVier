package de.medieninformatik.softwaretechnik;

public class TempViewer implements IBeobachter{
    TempSensor sensor;
    TempMachine heaterOrCooler;
    String name;

    //Wenn neuer Heater oder Cooler erzeugt wird, dann wird auch ein neuer Tempviewer erzeugt, der sich beim SEnsor registriert
    public TempViewer(TempSensor sens, TempMachine heaterOrCooler, String name){
        this.sensor = sens;
        this.name = name;
        this.heaterOrCooler = heaterOrCooler;
        this.sensor.anmelden(this);
    }

    public void aktualisieren(IBeobachtbar tempMachine) {
        System.out.println("Nachricht an "+this.name.substring(10)+" : Temperatur hat sich geändert");
        this.heaterOrCooler.changeTemp(sensor.gibZustand());
    }
}
