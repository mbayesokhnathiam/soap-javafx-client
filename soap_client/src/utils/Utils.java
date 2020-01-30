package utils;

import com.exo.soap.service.PersonneService;
import com.exo.soap.service.PersonneServiceWS;

public class Utils {
    private PersonneService personneService;

    public void initialize() {
        try {
            personneService = new PersonneServiceWS().getPersonneServicePort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PersonneService getPersonneService() {
        initialize();
        return personneService;
    }
}
