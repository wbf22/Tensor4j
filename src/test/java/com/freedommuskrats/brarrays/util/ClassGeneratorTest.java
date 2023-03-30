package com.freedommuskrats.brarrays.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ClassGeneratorTest {


    @Test
    void gen() throws IOException {
        int dim = 5;
        DDClassGenerator.generate(
                dim,
                "src/main/java/com/freedommuskrats/brarrays/data/DataDouble" + dim + "d.java"
        );
    }


}
