package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
    Person person = new Person("Juan", 123456789, 25, Gender.MALE, true);
    RegisterResult result = registry.registerVoter(person);
    Assert.assertEquals(RegisterResult.VALID, result);
}

    @Test
    public void testValidAge() {
        Person person = new Person("Juan", 123456789, 25, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void testInvalidAge() {
        Person person = new Person("Maria", 987654321, 15, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void testDeceasedPerson() {
        Person person = new Person("Pedro", 555555555, 35, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void testDuplicatedPerson() {
        new Person("Ana", 111111111, 30, Gender.FEMALE, true);
        
        // Intentar registrar una persona con el mismo número de documento
        Person newPerson = new Person("Luis", 111111111, 40, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(newPerson);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void testUnderagePerson() {
        Person person = new Person("Laura", 222222222, 17, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
}