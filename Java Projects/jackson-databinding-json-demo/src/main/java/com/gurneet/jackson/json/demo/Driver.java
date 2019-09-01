package com.gurneet.jackson.json.demo;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {
            //create object mapper
            ObjectMapper mapper = new ObjectMapper();



            //read JSON file and map/convert to Java Pojo:
            // data/sample-lite.json


            Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

            //print firstname and last name.
            System.out.println("First name = " + theStudent.getFirstName());
            System.out.println("Last name = " + theStudent.getLastName());


            //print out address: street and city

            Address tempAddress = theStudent.getAddress();
            System.out.println("City : " + tempAddress.getCity());
            System.out.println("Street " + tempAddress.getStreet());


            //print out the languages

            for(String tempLang: theStudent.getLanguages()){
                System.out.println(tempLang);
            }



        } catch (Exception exp){
            exp.printStackTrace();
        }


    }
}
