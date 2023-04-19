package com.freedommuskrats.tensor4j.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;


@Disabled
class ClassGeneratorTest {


    @Test
    void gen() throws IOException {
//        int dim = 3;
//        DDClassGenerator.generate(
//                dim,
//                "src/main/java/com/freedommuskrats/brarrays/data/Tensor" + dim + "d.java"
//        );
    }

    @Test
    void gen4_16() throws IOException {
        System.out.println("****************DFk;asdlkfja;lsdkj********************");
        for (int dim = 4; dim <= 16; dim++) {
            DDClassGenerator.generate(
                    dim,
                    "src/main/java/com/freedommuskrats/brarrays/data/Tensor" + dim + "d.java"
            );
        }
    }


}
