package tests;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> validCities(){
        List<Object[]> list  = new ArrayList<>();
        list.add(new Object[]{"Tel-Aviv", "Tallinn"});
        list.add(new Object[]{"Sochi", "Turin"});
        list.add(new Object[]{"Frankfurt", "Stockholm"});
        list.add(new Object[]{"Nice", "St Petersburg"});

        return list.iterator();
    }



}
