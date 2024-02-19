package tests;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker;

    {
        faker = new Faker();
    }

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            gender = faker.options().option("Male", "Female", "Other"),
            email = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10),
            birthDay = String.valueOf(faker.number().numberBetween(1, 28)),
            birthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"),
            birthYear = String.valueOf(faker.number().numberBetween(1900, 2024)),
            subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry",
            "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies",
            "History", "Civics"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("7.png", "8.png", "9.png"),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getCity(state);
    public String getCity(String state) {
        if (state.equals("NCR"))
            return faker.options().option("Delhi", "Gurgaon", "Haryana", "Noida");
        if (state.equals("Uttar Pradesh"))
            return faker.options().option("Agra", "Lucknow", "Merrut", "Rajasthan");
        if (state.equals("Haryana"))
            return faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan"))
            return faker.options().option("Jaipur", "Jaiselmer");
        return null;
    }
}
