package tech.parkhurst.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RestapiApplicationTests {

    @Test
    void contextLoads() {
        int a =1;
        assertEquals(1,a);
    }

}
