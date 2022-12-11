package de.medieninformatik.softwaretechnik;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TempSensor implements IBeobachtbar{

    private int temp;       //aktuelle Temperatur
    private Heater heater;
    private Cooler cooler;

    public List <TempViewer> beobachterListe;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Konstruktor zur Instanziierung neuer Temperatursensoren.
     * Verbindet den Sensor mit einer Heizung und einer Kuehlung
     */
    public TempSensor() {
        //in dieser Liste befinden sich für jede Heizung un den Kühler ein Observer
        beobachterListe = new ArrayList<TempViewer>();
    }

    /**
     * Setzt die vom Sensor aufgenommene Temperatur auf einen bestimmten Wert.
     * Informiert Heizung und Kuehlung ueber die Temperaturaenderung
     * @param temp Neu-aufgezeichnete Temperatur
     */
    public void setTemp(int temp) {
        this.temp = temp;
        //Ausgabe Statusnachricht in der Konsole
        statusMessage();

        //wenn die Temperatur sich ändert wird jeder Heater und Cooler in der Liste informiert
        //für jeden Oberver(Beobachter) in der Liste aller Beobachter
        for(TempViewer observer : this.beobachterListe) {
            //Die Beobachter geben die geänderte Temperatur jeweils weiter
            observer.aktualisieren(this);
        }
    }

    private void statusMessage() {
        System.out.printf("Sensor meldet %s Grad.\n", temp);
    }

    //Ein neuer tempViwer meldet sich beim Sensor an, wenn eine Heizung oder Kühlung hinzugefügt wird
    @Override
    public void anmelden(IBeobachter tempViewer) {
        this.beobachterListe.add((TempViewer) tempViewer);
        System.out.println(((TempViewer) tempViewer).name + " hat sich gerade angemeldet");
    }

    @Override
    public void abmelden(IBeobachter tempViewer) {
        this.beobachterListe.remove((TempViewer) tempViewer);
    }

    @Override
    public int gibZustand() {
        return this.temp;
    }
}
