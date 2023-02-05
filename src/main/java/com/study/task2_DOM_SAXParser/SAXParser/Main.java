package com.study.task2_DOM_SAXParser.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {
        final String fileName = "C:\\Users\\user\\IdeaProjects\\Java_Lesson16_Serialization_XML_JSON\\src\\main\\java\\com\\study\\task2\\1.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
                boolean city = false;
                boolean street = false;
                boolean building = false;
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes){
                    if (qName.equalsIgnoreCase("city")){
                        city = true;
                    }
                    if (qName.equalsIgnoreCase("street")){
                        street = true;
                    }
                    if (qName.equalsIgnoreCase("building")){
                        building = true;
                    }
                }
                @Override
                public void  characters(char ch[], int start, int length) throws SAXException{
                    if (city){
                        System.out.println("City: " + new String(ch, start, length));
                        city = false;
                    }
                    if (street){
                        System.out.println("Street: " + new String(ch, start, length));
                        street = false;
                    }
                    if (building){
                        System.out.println("Building: " + new String(ch, start, length));
                        building = false;
                    }
                }
            };
            saxParser.parse(fileName, handler);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
