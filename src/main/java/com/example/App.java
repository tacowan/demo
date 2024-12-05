package com.example;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.models.GeoPosition;
import com.azure.maps.timezone.TimeZoneClient;
import com.azure.maps.timezone.TimeZoneClientBuilder;
import com.azure.maps.timezone.models.TimeZoneCoordinateOptions;
import com.azure.maps.timezone.models.TimeZoneOptions;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String sharedKey = "<you get this in the Azure portal>";
        AzureKeyCredential credential = new AzureKeyCredential(sharedKey);
        TimeZoneClient client = new TimeZoneClientBuilder()
            .credential(credential)
            .buildClient();
        GeoPosition cd = new GeoPosition(-122, 47.0);
        TimeZoneCoordinateOptions op = new TimeZoneCoordinateOptions(cd).setTimezoneOptions(TimeZoneOptions.ALL);
        var result = client.getTimezoneByCoordinates(op);
        for (var tz : result.getTimeZones()) {
            System.out.println("Timezone: " + tz.getId());
        }
    }
}
