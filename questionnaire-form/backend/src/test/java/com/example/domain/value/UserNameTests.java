package com.example.domain.value;

import com.example.exception.user.ShortageUserNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserNameTests {

    @Test
    void construct() {
        var userName = new UserName("admin");
        assertEquals("admin", userName.getValue());
    }

    @Test
    void nullUserName() {
        assertThrows(IllegalArgumentException.class,
                () -> new UserName(null));
    }

    @Test
    void shortageUserName() {
        assertThrows(ShortageUserNameException.class,
                () -> new UserName("admi"));
    }
}
