package com.zbw.carrental.entities;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

    private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><vehicle><brand>Testbran</brand><dailycharge>120</dailycharge><fahrzeugklasse>Luxus</fahrzeugklasse><id>0</id><model>Testmodel</model></vehicle>";
    @Test
    public void shouldMarshall() throws Exception{
        Vehicle vehicle = new Vehicle("Testbran","Testmodel", "Luxus", BigDecimal.valueOf(120));

        // Marshals the object into a String
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Vehicle.class);
        Marshaller m = context.createMarshaller();
        m.marshal(vehicle, writer);

        assertEquals(writer.toString().trim(), expectedXML);
        System.out.println(writer);
    }
}
