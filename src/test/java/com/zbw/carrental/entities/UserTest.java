package com.zbw.carrental.entities;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user><password>TestPassword</password><username>TestUsername</username></user>";

    @Test
    public void shouldMarshall() throws Exception{
        User user = new User("TestUsername", "TestPassword");

        // Marshals the object into a String
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller m = context.createMarshaller();
        m.marshal(user, writer);

        assertEquals(writer.toString().trim(), expectedXML);
        System.out.println(writer);
    }
}
