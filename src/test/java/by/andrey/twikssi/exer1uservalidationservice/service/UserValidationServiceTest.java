package by.andrey.twikssi.exer1uservalidationservice.service;

import by.andrey.twikssi.exer1uservalidationservice.bean.User;
import by.andrey.twikssi.exer1uservalidationservice.exceptions.UserValidationExceptiom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserValidationServiceTest {
    User user;

    @Before
    public void setup(){
        user = new User();
    }

    @Test(expected = UserValidationExceptiom.class)
    public void getFirstNameWithValidateValueMoreThen15() throws UserValidationExceptiom {
        UserValidationService.getFirstNameWithValidate(user, "dfghjjjggggggggggggggggggggggggggggggggggggggggggg");
    }

    @Test(expected = UserValidationExceptiom.class)
    public void getFirstNameWithValidateValueLessThen3() throws UserValidationExceptiom {
        UserValidationService.getFirstNameWithValidate(user, "gg");
    }

    @Test
    public void getFirstNameWithValidate() throws UserValidationExceptiom {
        UserValidationService.getFirstNameWithValidate(user, "Lola");

        String expected = "Lola";
        String actual = user.getFirstName();

        assertEquals(expected,actual);
    }

    @Test
    public void getLastNameWithValidate() throws UserValidationExceptiom {
        UserValidationService.getLastNameWithValidate(user, "Lola");

        String expected = "Lola";
        String actual = user.getFirstName();

        assertEquals(expected,actual);
    }

    @Test(expected = UserValidationExceptiom.class)
    public void getLastNameWithValidateValueMoreThen15() throws UserValidationExceptiom {
        UserValidationService.getLastNameWithValidate(user, "dfghjjjggggggggggggggggggggggggggggggggggggggggggg");
    }

    @Test(expected = UserValidationExceptiom.class)
    public void getLastNameWithValidateValueLessThen3() throws UserValidationExceptiom {
        UserValidationService.getLastNameWithValidate(user, "gg");
    }

    @Test
    public void getAgeWithValidate() throws UserValidationExceptiom {
        UserValidationService.getAgeWithValidate(user,5);

        int expected = 5;
        int actual = user.getAge();

        assertEquals(expected,actual);
    }

    @Test(expected = UserValidationExceptiom.class)
    public void getAgeWitnThrowExceptionWithAgeLessThenZero() throws UserValidationExceptiom {
        UserValidationService.getAgeWithValidate(user,-90);
    }

    @Test(expected = UserValidationExceptiom.class)
    public void getAgeWitnThrowExceptionWithAgeLessThen120() throws UserValidationExceptiom {
        UserValidationService.getAgeWithValidate(user,140);
    }
}