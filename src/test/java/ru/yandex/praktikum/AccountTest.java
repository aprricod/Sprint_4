package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Bob Brown", true},
                {"", false},
                {" ", false},
                {"bb", false},
                {"Bob Brownnnnnnnnnnnn", false},
                {"Bob Brownnnnnnnnnnn", true},
                {" Brown", false},
                {"Brown ", false},
                {"Bob Bob Brown", false},
                {"Bob", false},
                {"B B", true}
        };
    }

    @Test
    public void checkName() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}