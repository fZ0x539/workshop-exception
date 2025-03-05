package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {
	public static void main(String[] args) {
        //TODO:

		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List <String> lastNames = null;
        try {
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);
        try{
            // nameService.addMaleFirstName("Erik"); Exception in thread "main" Message: Male name already exists, Duplicate Name: Erik
            nameService.addFemaleFirstName("Sapphire");
            nameService.addMaleFirstName("Mehrdad");
            nameService.addLastName("Krusberg");

            nameService.saveAllNames();
        } catch (DuplicateNameException e){
            System.err.println(e.getMessage());
        }


        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

	}

}
