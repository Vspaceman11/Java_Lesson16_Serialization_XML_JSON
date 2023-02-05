package com.study.task3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Country country = new Country("Odesa", "Prymorska", "13");
        try {
            File file = new File("C:\\Users\\user\\IdeaProjects\\Java_Lesson16_Serialization_XML_JSON\\src\\main\\java\\com\\study\\task3\\2.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(country, file);
            marshaller.marshal(country, System.out);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            country = (Country) unmarshaller.unmarshal(file);
            System.out.println(country);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
