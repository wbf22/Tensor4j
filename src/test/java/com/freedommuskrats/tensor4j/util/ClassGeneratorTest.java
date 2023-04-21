package com.freedommuskrats.tensor4j.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;


@Disabled
class ClassGeneratorTest {

    public static final String path = "src/main/java/com/freedommuskrats/tensor4j/data/Tensor";
    public static final String overidePath = "src/main/java/com/freedommuskrats/tensor4j/Tensor";

    @Test
    void gen() throws IOException {
        int dim = 4;
        DDClassGenerator.generate(
                dim,
                path + dim + "d.java"
        );
    }

    @Test
    void gen4_16() throws IOException {
        System.out.println("****************DFk;asdlkfja;lsdkj********************");
        for (int dim = 1; dim <= 16; dim++) {
            String p = (dim > 3)? overidePath : path;
            DDClassGenerator.generate(
                    dim,
                    p + dim + "d.java"
            );
        }
    }


}
