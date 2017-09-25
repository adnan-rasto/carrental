package com.zbw.carrental.entities;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><address>Teststrasse 11</address><city>Testhausen</city><firstname>MaxTest</firstname><id>0</id><lastname>MusterTest</lastname><zipcode>9200</zipcode></customer>";

    @Test
    public void shouldMarshall() throws Exception{
        Customer customer = new Customer("MaxTest", "MusterTest", "Teststrasse 11", 9200, "Testhausen");

        // Marshals the object into a String
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Customer.class);
        Marshaller m = context.createMarshaller();
        m.marshal(customer, writer);

        assertEquals(writer.toString().trim(), expectedXML);
        System.out.println(writer);
    }
}
