package com.zbw.carrental.entities;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><order><customer><address>Teststrasse 11</address><city>Testhausen</city><firstname>MaxTest</firstname><id>0</id><lastname>MusterTest</lastname><zipcode>9200</zipcode></customer><fahrzeug><brand>Testbran</brand><dailycharge>120</dailycharge><fahrzeugklasse>Luxus</fahrzeugklasse><id>0</id><model>Testmodel</model></fahrzeug><orderID>0</orderID></order>";
    @Test
    public void shouldMarshall() throws Exception{

        Customer customer = new Customer("MaxTest", "MusterTest", "Teststrasse 11", 9200, "Testhausen");
        Vehicle vehicle = new Vehicle("Testbran","Testmodel", "Luxus", BigDecimal.valueOf(120));

        Order order = new Order(vehicle, customer);

        // Marshals the object into a String
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Order.class);
        Marshaller m = context.createMarshaller();
        m.marshal(order, writer);

        assertEquals(writer.toString().trim(), expectedXML);
        System.out.println(writer);
    }
}
