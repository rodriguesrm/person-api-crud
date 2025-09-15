package rsoft.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonApplicationTest {

    @Test
    void deveSubirSprintSemErros() {
        assertDoesNotThrow(() -> PersonApplication.main(new String[]{}));
    }
}
