package tests;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    @DataProvider
    public Iterator<Object[]>validCitiesUsingCSV() throws IOException {
        List<Object[]> list  = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/cities_list.csv")));
        String line =  reader.readLine();
        while (line!=null){
            list.add(line.split(","));
            line =   reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

}
