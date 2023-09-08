package utils;

import com.github.javafaker.Code;
import com.github.javafaker.Faker;

public class Utilities
{
    Faker faker;
    public void timeout (int i)
    {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String firstname()
    {
        faker = new Faker();
        String firstname = faker.name().firstName();

        return firstname;
    }

    public String lastname()
    {
        faker = new Faker();
        String lastname = faker.name().lastName();
        return lastname;
    }

    public  String postcode()
    {
        faker = new Faker();
        String zipcode = faker.address().zipCode();
        return zipcode;
    }


}
