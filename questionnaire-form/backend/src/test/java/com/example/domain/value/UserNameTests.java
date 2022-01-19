package com.example.domain.value;

import com.example.exception.user.IncludingUnavailableCharacterUserNameException;
import com.example.exception.user.LongageUserNameException;
import com.example.exception.user.ShortageUserNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserNameTests {

    @Test
    void construct() {
        var userName = new UserName("admin");
        assertDoesNotThrow(() -> new UserName("admin"));
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

    @Test
    void longageUserName() {
        assertThrows(LongageUserNameException.class,
                () -> new UserName("a".repeat(65)));
    }

    @Test
    void useOnlyAlphabetDigitHyphenUnderscore() {
        assertDoesNotThrow(() -> new UserName("a_dmin"));
        assertDoesNotThrow(() -> new UserName("a-dmin"));
        assertDoesNotThrow(() -> new UserName("a6min"));
        assertDoesNotThrow(() -> new UserName("Admin"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("あどみにすた"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("aどmin"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("アドミニスタ"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("aドmin"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("ＡＤＭＩＮ"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("aＤmin"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("@dmin"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("*&a#d^m!)([]n"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("a min"));
        assertThrows(IncludingUnavailableCharacterUserNameException.class,
                () -> new UserName("a　min"));
    }
}
