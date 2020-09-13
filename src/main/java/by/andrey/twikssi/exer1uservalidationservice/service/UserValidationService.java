package by.andrey.twikssi.exer1uservalidationservice.service;

import by.andrey.twikssi.exer1uservalidationservice.bean.User;
import by.andrey.twikssi.exer1uservalidationservice.exceptions.UserValidationExceptiom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserValidationService {
    public static final Logger logger = LoggerFactory.getLogger(UserValidationService.class);

    private UserValidationService() {
    }

    public static void getFirstNameWithValidate(User user, String name) throws UserValidationExceptiom {
        if (name.length() >= 3 && name.length() < 15){
            user.setFirstName(name);
        } else {
                throw new UserValidationExceptiom();
        }
    }

    public static void getLastNameWithValidate(User user, String name) throws UserValidationExceptiom {
        if (name.length() >= 3 && name.length() < 15){
            user.setFirstName(name);
        } else {
            throw new UserValidationExceptiom();
        }
    }

    public static void getAgeWithValidate(User user, int age) throws UserValidationExceptiom {
        if (age >= 0 && age <= 120){
            user.setAge(age);
        } else {
            throw new UserValidationExceptiom();
        }
    }
}
