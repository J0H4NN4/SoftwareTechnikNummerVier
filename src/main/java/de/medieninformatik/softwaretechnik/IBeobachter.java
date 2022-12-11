package de.medieninformatik.softwaretechnik;

import java.util.ArrayList;
import java.util.List;

public interface IBeobachter {
    //public List<IBeobachtbar> tempMachineList;
    void aktualisieren(IBeobachtbar tempMachine);
}
