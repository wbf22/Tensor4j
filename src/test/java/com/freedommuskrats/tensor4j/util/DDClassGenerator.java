package com.freedommuskrats.tensor4j.util;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DDClassGenerator {

    public final static String INDENT = "    ";

    private static List<String> documentation = new ArrayList<>();

    public static void generate(int dimension, String savePath) throws IOException {
        if (dimension < 3) {
            throw new IllegalArgumentException("Dimension must be greater than 3. We don't want to overwrite the existing classes.");
        }

        String docs = Files.readString(
                Path.of("src/test/resources/documentationSource.txt"),
                StandardCharsets.UTF_8
        );
        documentation.addAll(
                Arrays.stream(docs.split("<break>"))
//                        .map(s -> s.substring(0, s.length()-1))
                        .toList()
        );


        String classString = Files.readString(
                Path.of("src/test/resources/dataDoubleClassGenSource.txt"),
                StandardCharsets.UTF_8
        );

        String className = "Tensor" + dimension + "d";

        String arrayString = "double";
        for (int i = 0; i < dimension; i++) {
            arrayString += "[]";
        }

        String arrayStringLess = "double";
        for (int i = 0; i < dimension - 1; i++) {
            arrayStringLess += "[]";
        }

        String classDoc = documentation.get(11);
        classString = classString.replaceAll("<classDoc>", classDoc);


        String constructors = genContructors(dimension, className);
        classString = classString.replaceAll("<constructors>", constructors);

        classString = classString.replaceAll("<arrayType>", arrayString);
        classString = classString.replaceAll("<arrayTypeLess>", arrayStringLess);
        classString = classString.replaceAll("<num>", Integer.toString(dimension));
        classString = classString.replaceAll("<numLess>", Integer.toString(dimension - 1));

        String shapeString = "";
        for (int i = 0; i < dimension; i++) {
            shapeString += "data";
            for (int j = dimension - 1 - i; j > 0; j--) {
                shapeString += "[0]";
            }
            shapeString += ".length";
            shapeString += (i != dimension - 1) ? ", " : "";
        }
        classString = classString.replaceAll("<shape>", shapeString);

        String accessString = "data";
        for (int i = 0; i < dimension; i++) {
            accessString += "[index[" + i + "]]";
        }
        classString = classString.replaceAll("<access>", accessString);

        String appendMethod = genAppendMethod(classString, dimension, arrayString);
        classString = classString.replaceAll("<appendMethod>", appendMethod);

        String appendLessMethod = genAppendLessMethod(classString, dimension, arrayString, arrayStringLess);
        classString = classString.replaceAll("<appendLessMethod>", appendLessMethod);

        String sliceMethod = genSliceMethod(className, dimension, arrayString);
        classString = classString.replaceAll("<sliceMethod>", sliceMethod);

        String multiplyMethod = genMultiplyMethod(className, dimension, arrayString, arrayStringLess);
        classString = classString.replaceAll("<mulitplyMethod>", multiplyMethod);

        String matmulMethod = genMatmulMethod(className, dimension, arrayString, arrayStringLess);
        classString = classString.replaceAll("<matmulMethod>", matmulMethod);

        String verifyDimMethod = genVerifyDimsMethod(dimension);
        verifyDimMethod += genVerifyDimsMethod(dimension - 1);
        classString = classString.replaceAll("<verifyDimMethod>", verifyDimMethod);

        String reshapeMethod = genReshape(arrayString, dimension);
        classString = classString.replaceAll("<reshapeMethod>", reshapeMethod);

        String unsqueezeMethod = genUnsqeeze(dimension);
        classString = classString.replaceAll("<unsqueezeMethod>", unsqueezeMethod);

        String squeezeMethod = genSqueeze(dimension);
        classString = classString.replaceAll("<squeezeMethod>", squeezeMethod);

        String toStringMethod = genToString(dimension);
        classString = classString.replaceAll("<toString>", toStringMethod);

        String getMethods = genGetMethod(dimension, dimension);
        classString = classString.replaceAll("<getMethod>", getMethods);

        String setMethods = genSetMethod(dimension);
        classString = classString.replaceAll("<setMethod>", setMethods);

        Files.writeString(
                Path.of(savePath),
                classString,
                StandardCharsets.UTF_8
        );
    }

    private static String genContructors(int dimension, String className) {
        String constructors = newLine(0);
        constructors += "    /**\n" +
                "     * Create a new " + className + " object with the given size and filler.\n" +
                "     * @param dim1 The x size or width of the array.\n" +
                "     * @param dim2 The y size or height of the array.\n" +
                "     * @param dim3 The z size or depth of the array.\n";
        for (int i = 4; i <= dimension; i++) {
            constructors += indent(1) + " * @param dim" + i + " The dim" + i + " size of the array.\n";
        }
        constructors += "     * @param filler The value to fill the array with.";
        constructors += newLine(0) + "     */" + newLine(0);
        constructors += indent(1) + "public " + className + "(";
        for(int i = 1; i <= dimension; i++) {
            constructors += "int dim" + i;
            constructors += ", ";
        }
        constructors += "double filler) {" + newLine(0);
        constructors += indent(2) + "dims = " + dimension + ";" + newLine(0);
        constructors += indent(2) + "this.data = new double";
        for(int i = dimension; i >= 1; i--) {
            constructors += "[dim" + i;
            constructors += "]";
        }
        constructors += ";" + newLine(0);
        for(int i = dimension; i > 1; i--) {
            constructors += indent(2 + dimension - i) + forLine(i, "dim" + i) + newLine(0);
        }
        constructors += indent(2 + dimension) + "Arrays.fill(data";
        for(int i = dimension; i > 1; i--) {
            constructors += "[x" + i + "]";
        }
        constructors += ", filler);" + newLine(0);
        for(int i = dimension; i > 1; i--) {
            constructors += indent(i) + "}" + newLine(0);
        }
        constructors += indent(1) + "}" + newLine(0) + newLine(0);


        constructors += "    /**\n" +
                "     * Create a new random " + className + " object with the given size.\n" +
                "     * @param dim1 The x size or width of the array.\n" +
                "     * @param dim2 The y size or height of the array.\n" +
                "     * @param dim3 The z size or depth of the array.\n";
        for (int i = 4; i <= dimension; i++) {
            constructors += indent(1) + " * @param dim" + i + " The dim" + i + " size of the array.\n";
        }
        constructors += "     */" + newLine(0);
        constructors += indent(1) + "public " + className + "(";
        for(int i = 1; i <= dimension; i++) {
            constructors += "int dim" + i;
            if (i != dimension)
                constructors += ", ";
        }
        constructors += ") {" + newLine(0);
        constructors += indent(2) + "dims = " + dimension + ";" + newLine(0);
        constructors += indent(2) + "Random r = new Random(System.nanoTime());" + newLine(0);
        constructors += indent(2) + "this.data = new double";
        for(int i = dimension; i > 0; i--) {
            constructors += "[dim" + i;
            constructors += "]";
        }
        constructors += ";" + newLine(0);
        for(int i = dimension; i > 0; i--) {
            constructors += indent(2 + dimension - i) + forLine(i, "dim" + i) + newLine(0);
        }
        constructors += indent(dimension + 2) + "data";
        for(int i = dimension; i > 0; i--) {
            constructors += "[x" + i + "]";
        }
        constructors += " = r.nextDouble();" + newLine(0);
        for(int i = dimension; i > 0; i--) {
            constructors += indent(i + 1) + "}" + newLine(0);
        }
        constructors += indent(1) + "}" + newLine(0);


        constructors += newLine();
        for (int k = 0; k < 2; k++) {
            constructors += documentation.get(k);
            constructors += indent(1) + "public static " + className;
            constructors += (k==0)? " zeros(" : " ones(";
            for(int i = 1; i <= dimension; i++) {
                constructors += "int dim" + i;
                if (i != dimension)
                    constructors += ", ";
            }
            constructors += ") {" + newLine(0);
            constructors += indent(2) + "return new " + className + "(";
            for(int i = 1; i <= dimension; i++) {
                constructors += "dim" + i;
                constructors += ", ";
            }
            constructors += k + ");" + newLine(0);
            constructors += indent(1) + "}" + newLine(0);
        }
        constructors += newLine(0);

        return constructors;
    }


    public static String genGetMethod(int dim, int acc) {
        String method = newLine(0);
        method += documentation.get(2);
        method += indent(1) + "public ";
        method += (dim == acc) ? "double" : "Tensor" + (dim - acc) + "d";

        method += " get(";
        for (int i = dim - acc; i < dim; i++) {
            method += "int x" + (i+1);
            method += (i == dim - 1)? ") {" : ", ";
        }
        method += newLine(0);

        method += indent(2) + "return ";
        method += (dim == acc) ? "" : "new Tensor" + (dim - acc) + "d";
        method += "(data";
        for (int i = dim; i > dim - acc; i--) {
            method += "[x" + i + "]";
        }
        method += ");";
        method += newLine(0);

        method += indent(1) + "}";
        newLine(0);

        return method;
    }

    public static String genSetMethod(int dim) {
        String method = newLine(0);

        String[] valTypes = new String[dim];
        valTypes[0] = "double";
        for (int i = 1; i < dim; i++) {
            valTypes[i] = "Tensor" + i + "d";
        }


        method += documentation.get(3);
        int acc = dim;
        method += indent(1) + "public void set(";
        for (int i = 0; i < acc; i++) {
            method += "int x" + (i+1);
            method += ", ";
        }
        method += valTypes[dim-acc] + " val) {";
        method += newLine(0);

        method +=  indent(2) + "data";
        for (int i = acc; i > 0; i--) {
            method += "[x" + i + "]";
        }
        method += (acc==dim)? " = val;" : " = val.getData();";
        method += newLine(0);

        method += indent(1) + "}";
        method += newLine(0);
        method += newLine(0);
        return method;
    }

    public static String genSliceMethod(String className, int dim, String arrayString) {
        String method = newLine(0);
        method += documentation.get(4);
        method += indent(1) + "public " + className + " slice(";
        for (int i = 0; i < dim; i++) {
            method += "Range x" + (i+1) + "Range";
            method += (i == dim - 1)? ") {" + newLine() : ", ";
        }

        for (int i = 0; i < dim; i++) {
            method += indent(2) + "int[] x" + (i+1) + "Seq = x" + (i+1) + "Range.getSequence();" + newLine(0);
        }
        method += newLine(0);

        for (int i = 0; i < dim; i++) {
            method += indent(2) + "x" + (i+1) + "Seq = (x" + (i+1) + "Seq == null)";
            method += "? range(data" + times(dim -1 - i, "[0]") + ".length).getSequence() : " + "x" + (i+1) + "Seq;" + newLine(0);
        }

        method += newLine(0);
        method += indent(2) + arrayString + " newData = new double";
        for (int i = dim; i > 0; i--) {
            method += "[x" + i + "Seq.length]";
        }
        method += ";" + newLine(0);
        for (int i = dim; i > 0; i--) {
            method += indent(2 + dim - i) + forLine(i, "x" + (i) + "Seq.length") + newLine();
        }

        method += indent(2 + dim) + "newData";
        for (int i = dim; i > 0; i--) {
            method += "[x" + i + "]";
        }
        method += " = data";
        for (int i = dim; i > 0; i--) {
            method += "[x" + i + "Seq[x" + i + "]]";
        }
        method += ";" + newLine(0);

        for (int i = dim; i > 0; i--) {
            method += indent(1 + i) + "}" + newLine(0);
        }
        method += newLine(0);

        method += indent(2) + "return new " + className + "(newData);" + newLine(0);
        method += indent(1) + "}" + newLine(0);
        return method;
    }

    public static String genAppendMethod(String classString, int dimension, String arrayString) {
        String appendMethod = newLine(0);

        for (int dim = 0; dim < dimension; dim++) {

            appendMethod += indent(2) +  "if (dim == " + dim + ") {";
            appendMethod += newLine(0);

            appendMethod += indent(3) + "verifyDimensions(ap, new int[]{";
            for (int i = 0; i < dimension; i++) {
                appendMethod += (dimension - 1 - i == dim) ? "ap" : "data";
                for (int j = 0; j < i; j++) {
                    appendMethod += "[0]";
                }
                appendMethod += (i != dimension - 1)? ".length, " : ".length});" + newLine(0);
            }

            appendMethod += indent(3) + arrayString
                    + " newData = new double";
            String[] pieces = genLengthPieces(dimension);
            for (int j = 0; j < pieces.length; j++) {
                String mod = pieces[j];
                String rep = "";
                if (dimension - 1 - j == dim) {
                    rep += " + ap";
                    for (int k = dimension - 1 - dim; k > 0; k--) {
                        rep += "[0]";
                    }
                    rep += ".length";
                }
                mod = mod.replaceAll("<p>", rep);

                appendMethod += mod;
            }
            appendMethod += ";";
            appendMethod += newLine(0);

            String[] iterationPieces = genIterationPieces(dim, dimension);
            for (int i = 0; i < dimension; i++) {
                appendMethod += indent(3 + i) + forLine(dimension - i, iterationPieces[i]);
                appendMethod += newLine(0);
            }

            appendMethod += indent(3 + dimension) + "if (x";
            appendMethod += dim + 1;
            appendMethod += " < data";
            appendMethod += times(dimension - dim - 1, "[0]");
            appendMethod += ".length) {";
            appendMethod += newLine(0);

            appendMethod += indent(4 + dimension) + "newData";
            for (int i = dimension; i > 0; i--) {
                appendMethod += "[x" + i + "]";
            }
            appendMethod += " = data";
            for (int i = dimension; i > 0; i--) {
                appendMethod += "[x" + i + "]";
            }
            appendMethod += ";";
            appendMethod += newLine(3 + dimension);
            appendMethod += "} else {";
            appendMethod += newLine(0);
            appendMethod += indent(4 + dimension) + "newData";
            for (int i = dimension; i > 0; i--) {
                appendMethod += "[x" + i + "]";
            }
            appendMethod += " = ap";
            for (int i = dimension; i > 0; i--) {
                if (i - 1 == dim) {
                    appendMethod += "[x" + i + " - data";
                    for (int j = dimension - 1 - dim; j > 0; j--) {
                        appendMethod += "[0]";
                    }
                    appendMethod += ".length]";
                } else {
                    appendMethod += "[x" + i + "]";
                }
            }
            appendMethod += ";";

            appendMethod += newLine(0);
            appendMethod += indent(3 + dimension) + "}";
            appendMethod += newLine(0);
            for (int i = dimension - 1; i >= 0; i--) {
                appendMethod += indent(i + 3) + "}";
                appendMethod += newLine(0);

            }

            appendMethod += indent(3) + "data = newData;";
            appendMethod += newLine(0);
            appendMethod += indent(2) + "}";
            appendMethod += newLine(0);
        }

        return appendMethod;
    }

    public static String genAppendLessMethod(String classString, int dim, String arrayString, String arrayLessString) {

        String appendMethod = newLine(0);

        appendMethod += indent(2) + "verifyDimensions(ap, new int[]{";
        for (int i = 0; i < dim - 1; i++) {
            appendMethod += "data";
            for (int j = 0; j < i + 1; j++) {
                appendMethod += "[0]";
            }
            appendMethod += (i != dim - 2)? ".length, " : ".length});" + newLine(0);
        }

        appendMethod += indent(2) + arrayString
                + " newData = new double";
        String[] pieces = genLengthPieces(dim);
        for (int j = 0; j < pieces.length; j++) {
            String mod = pieces[j];
            String rep = (j == 0)? " + 1" : "";
            mod = mod.replaceAll("<p>", rep);

            appendMethod += mod;
        }
        appendMethod += ";";
        appendMethod += newLine(0);

        String[] iterationPieces = genIterationPieces(dim -1, dim);
        for (int i = 0; i < dim; i++) {
            appendMethod += indent(2 + i) + forLine(dim - i, iterationPieces[i]);
            appendMethod += newLine(0);
        }

        appendMethod += indent(2 + dim) + "if (x";
        appendMethod += dim;
        appendMethod += " < data";
        appendMethod += ".length) {";
        appendMethod += newLine(0);

        appendMethod += indent(3 + dim) + "newData";
        for (int i = dim; i > 0; i--) {
            appendMethod += "[x" + i + "]";
        }
        appendMethod += " = data";
        for (int i = dim; i > 0; i--) {
            appendMethod += "[x" + i + "]";
        }
        appendMethod += ";";
        appendMethod += newLine(2 + dim);
        appendMethod += "} else {";
        appendMethod += newLine(0);
        appendMethod += indent(3 + dim) + "newData";
        for (int i = dim; i > 0; i--) {
            appendMethod += "[x" + i + "]";
        }
        appendMethod += " = ap";
        appendMethod += "[x" + dim + " - data.length]";
        for (int i = dim - 1; i > 1; i--) {
            appendMethod += "[x" + i + "]";
        }
        appendMethod += ";";

        appendMethod += newLine(0);
        appendMethod += indent(2 + dim) + "}";
        appendMethod += newLine(0);
        for (int i = dim - 1; i >= 0; i--) {
            appendMethod += indent(i + 2) + "}";
            appendMethod += newLine(0);

        }

        appendMethod += indent(2) + "data = newData;";
        appendMethod += newLine(0);

        return appendMethod;
    }

    public static String genMultiplyMethod(String classString, int dim, String arrayString, String arrayLessString) {

        String multiplyMethod = newLine(0);

        multiplyMethod += documentation.get(5);
        multiplyMethod += indent(1) + "public static " + classString + " multiply("
                + classString + " array, double scalar) {" + newLine(0);
        multiplyMethod += indent(2) + "double" + times(dim, "[]") + " data = array.getData();" + newLine(0);

        multiplyMethod += newLine(0);
        String[] pieces = genPieces("data", dim);
        for (int i = dim; i > 0; i--) {
            multiplyMethod += indent(2 + dim - i) + forLine(i, pieces[dim - i]) + newLine(0);
        }

        multiplyMethod += indent(2 + dim) + "data";
        for (int i = dim; i > 0; i--) {
            multiplyMethod += "[x" + i + "]";
        }
        multiplyMethod += " *= scalar;" + newLine(0);
        for(int i = dim - 1; i >= 0; i--) {
            multiplyMethod += indent(2 + i) + "}" + newLine(0);
        }

        multiplyMethod += indent(2) + "return new " + classString + "(data);" + newLine(0);
        multiplyMethod += indent(1) + "}" + newLine(0);

        return multiplyMethod;
    }

    public static String genMatmulMethod(String classString, int dim, String arrayString, String arrayLessString) {

        String matmulMethod = newLine(0);

        matmulMethod += documentation.get(6);
        matmulMethod += indent(1) + "public static " + classString + " matmul("
                + classString + " mul, " + classString + " toMul) {" + newLine(0);
        matmulMethod += indent(2) + "checkDims(mul, toMul);" + newLine(0);
        matmulMethod += indent(2) + "return new " + classString + "(matmul(mul.getData(), toMul.getData()));" + newLine(0);
        matmulMethod += indent(1) + "}";

        matmulMethod += newLine(0);
        matmulMethod += newLine(0);
        matmulMethod += documentation.get(7);
        matmulMethod += indent(1) + "public static " + arrayString + " matmul(" + arrayString
                + " mul, " + arrayString + " toMul) {" + newLine(0) + newLine(0);

        matmulMethod += indent(2) + arrayString + " result = new double[";
        for (int i = 0; i < dim - 1; i++) {
            matmulMethod += "mul" + times(i, "[0]") + ".length][";
        }
        matmulMethod += "toMul" + times(dim - 1, "[0]") + ".length];" + newLine(0);

        matmulMethod += newLine(0);
        String[] pieces = genPieces("mul", dim);
        for (int i = dim; i > 2; i--) {
            matmulMethod += indent(2 + dim-i) + forLine(i, pieces[dim - i]) + newLine(0);
        }
        matmulMethod += indent(dim) + "result";
        for (int i = dim; i > 2; i--) {
            matmulMethod += "[x" + i + "]";
        }
        matmulMethod += " =  Tensor2d.matmul(mul";
        for (int i = dim; i > 2; i--) {
            matmulMethod += "[x" + i + "]";
        }
        matmulMethod += ", toMul";
        for (int i = dim; i > 2; i--) {
            matmulMethod += "[x" + i + "]";
        }
        matmulMethod += ", MUL_TILE_SIZE);" + newLine(0);
        for (int i = dim; i > 2; i--) {
            matmulMethod += indent(i - 1) + "}";
            matmulMethod += newLine(0);
        }

        matmulMethod += newLine(0);
        matmulMethod += indent(2) + "return result;";
        matmulMethod += newLine(0);
        matmulMethod += indent(1) + "}";

        return matmulMethod;
    }

    public static String genVerifyDimsMethod(int dim) {
        String fileString = newLine(0);

        fileString +=  indent(1) + "private static void verifyDimensions(double";
        for (int i = 0; i < dim; i++) {
            fileString += "[]";
        }
        fileString += " array, int[]expectedDimensions) {";
        fileString += newLine(0);

        fileString +=
                "        if (array.length != expectedDimensions[0]) {\n" +
                "            throw new DataException(\n" +
                "                    String.format(\"Size of first dimension of array must be %s, but was %s\", expectedDimensions[0], array.length)\n" +
                "            );\n" +
                "        }\n" +
                "        else if (array[0].length != expectedDimensions[1]) {\n" +
                "            throw new DataException(\n" +
                "                    String.format(\"Size of second dimension of array must be %s, but was %s\", expectedDimensions[1], array[0].length)\n" +
                "            );\n" +
                "        }\n" +
                "        else if (array[0][0].length != expectedDimensions[2]) {\n" +
                "            throw new DataException(\n" +
                "                    String.format(\"Size of third dimension of array must be %s, but was %s\", expectedDimensions[2], array[0][0].length)\n" +
                "            );\n" +
                "        }";
        fileString += newLine(0);

        for (int i = 3; i < dim; i++) {
            fileString += indent(2);
            fileString += "else if (array";
            fileString += times(i, "[0]");
            fileString += ".length != expectedDimensions[";
            fileString += i;
            fileString += "]) {\n" +
                    "            throw new DataException(\n" +
                    "                    String.format(\"";
            fileString += "Size of dimension " + (i + 1) + " of array must be %s, but was %s\", expectedDimensions[";
            fileString += i;
            fileString += "], array";
            fileString += times(i, "[0]");
            fileString += ".length)\n" +
                    "            );\n" +
                    "        }";

            fileString += newLine(0);
        }
        fileString += indent(1) + "}";
        fileString += newLine(0);
        fileString += newLine(0);

        return fileString;
    }

    public static String genReshape(String arrayString, int dim){
        String method = newLine(0);

        method += documentation.get(8);
        method += indent(1) + "public void reshape(";
        for (int i = 0; i < dim; i++) {
            method += "int dim" + (i + 1);
            if (i != dim - 1) {
                method += ", ";
            }
        }
        method += ") {" + newLine(0);

        method += indent(2) + "int[] shape = shape();" + newLine(0);
        method += indent(2) + "int[] remappings = new int[" + dim + "];" + newLine(0);
        for (int i = 1; i <= dim; i++) {
            method += indent(2) + "boolean dim" + i + "F = false;" + newLine(0);
        }

        method += indent(2) + "for (int i = 0; i < shape.length; i++) {" + newLine(0);
        method += indent(3) + "if (dim1 == shape[i] && !dim1F) {" + newLine(0);
        method += indent(4) + "remappings[0] = i;" + newLine(0);
        method += indent(4) + "dim1F = true;" + newLine(0);
        method += indent(3) + "}" + newLine(0);
        for(int i =2; i <= dim; i++) {
            method += indent(3) + "else if (dim" + i + " == shape[i] && !dim" + i + "F) {" + newLine(0);
            method += indent(4) + "remappings[" + (i-1) + "] = i;" + newLine(0);
            method += indent(4) + "dim" + i + "F = true;" + newLine(0);
            method += indent(3) + "}" + newLine(0);
        }
        method += "            else {\n" +
                "                throw new DataException(\"For reshape the given dimensions must be \" +\n" +
                "                        \"the same as current dimensions howbeit in a different order.\");\n" +
                "            }";
        method += newLine();

        method += indent(2) + "}" + newLine(0) + newLine();

        method += indent(2) + arrayString + " newData = new double";
        for (int i = dim - 1; i >= 0; i--) {
            method += "[shape[remappings[" + i + "]]]";
        }
        method += ";" + newLine() + newLine();

        method += indent(2) + "int[] indices = new int[" + dim + "];" + newLine(0);
        String[] pieces = genPieces("data", dim);
        for (int i = 1; i <= dim; i++) {
            method += indent(1 + i) + forLine(i, pieces[dim-i]) + newLine();
        }
        method += indent(2 + dim) + "for (int i = 0; i < indices.length; i++) {" + newLine(0);
        for (int i = 0; i < dim; i++) {
            method += indent(3 + dim) + "if (remappings[i] == " + i + ") {" + newLine(0);
            method += indent(4 + dim) + "indices[i] = x" + (i+1) + ";" + newLine(0);
            method += indent(3 + dim) + "}" + newLine(0);
        }
        method += indent(2 + dim) + "}" + newLine(0);

        method += indent(2 + dim) + "newData";
        for (int j = dim - 1; j >= 0; j--) {
            method += "[indices[" + j + "]]";
        }
        method += " =  data";
        for (int j = dim; j > 0; j--) {
            method += "[x" + j + "]";
        }
        method += ";" + newLine(0);

        for (int i = 0; i < dim; i++) {
            method += indent(1 + dim - i) + "}" + newLine(0);
        }

        method += indent(2) + "this.data = newData;" + newLine(0);
        method += indent(1) + "}" + newLine(0);

        return method;
    }

    public static String genUnsqeeze(int dim) {
        String method = newLine(0);

        method += documentation.get(9);
        method += indent(1) + "public Tensor" + (dim+1) + "d unsqueeze(int dim) {" + newLine(0);
        method += indent(2) + "double" + times(dim+1, "[]") + " newData;" + newLine(0);

        method += indent(2);
        for (int i = 0; i < dim+1; i++) {
            method += "if (dim == " + i + ") {" + newLine(0);
            method += indent(3) + "newData = new double";
            for (int j = 0; j < dim+1; j++) {
                int t = (j > dim-i)? j-1 : j;
                method += (j == dim-i)? "[1]" : "[data" + times(t, "[0]") + ".length]";
            }
            method += ";" + newLine(0);
            method += indent(2) + "}" + newLine(0);
            method += indent(2) + "else ";
        }

        method += "{" + newLine(0);
        method += indent(3) + "throw new DataException(\"Dimension must be between 0 and "
                + dim + "\");" + newLine();

        method += indent(2) + "}" + newLine() + newLine();

        String[] pieces = genPieces("data", dim);
        for (int i = 1; i <= dim; i++) {
            method += indent(1 + i) + forLine(i, pieces[dim-i]) + newLine();
        }
        method += indent(2 + dim);
        for (int i = 0; i <= dim; i++) {
            method += "if (dim == " + i + ") {" + newLine(0);
            method += indent(3 + dim) + "newData";
            int index = dim;
            for (int j = dim+1; j > 0; j--) {
                if (j == i+1) {
                    method += "[0]";
                } else {
                    method += "[x" + index + "]";
                    index--;
                }
            }
            method += " =  data";
            for (int j = dim; j > 0; j--) {
                method += "[x" + j + "]";
            }
            method += ";" + newLine(0);
            method += indent(2 + dim) + "}" + newLine(0);
            method += (i==dim)? "" : indent(2 + dim) + "else ";
        }

        for (int i = 0; i < dim; i++) {
            method += indent(1 + dim - i) + "}" + newLine(0);
        }

        method += newLine();
        method += indent(2) + "return new Tensor" + (dim+1) + "d(newData);" + newLine(0);

        method += indent(1) + "}" + newLine(0);

        return method;
    }

    public static String genSqueeze(int dim) {
        String method = newLine(0);

        method += documentation.get(10);
        method += indent(1) + "public Tensor" + (dim-1) + "d squeeze(int dim) {" + newLine(0);
        method += indent(2) + "int[] shape = shape();" + newLine();

        method += indent(2) + "if (shape[dim] > 1) {" + newLine(0);
        method += indent(3) + "throw new DataException(\"Dim " + dim + " must be of size 1 or 0 but was \" + shape[dim]);" + newLine();
        method += indent(2) + "}" + newLine() + newLine();

        method += indent(2) + "int[] newShape = new int[" + (dim-1) + "];" + newLine();
        method += indent(2) + "int newIndex = 0;" + newLine();

        method += indent(2) + "for (int i = 0; i < shape.length; i++) {" + newLine();
        method += indent(3) + "if (i != dim) {" + newLine();
        method += indent(4) + "newShape[newIndex] = shape[i];" + newLine();
        method += indent(4) + "newIndex++;" + newLine();
        method += indent(3) + "}" + newLine();
        method += indent(2) + "}" + newLine();

        method += indent(2) + "double" + times(dim-1, "[]") + " newData = new double";
        for (int i = dim-1; i > 0; i--) {
            method += "[newShape[" + (i-1) + "]]";
        }
        method += ";" + newLine();


        String[] pieces = genPieces("newData", dim);
        for (int i = 1; i < dim; i++) {
            method += indent(1 + i) + forLine(i, pieces[dim-1-i]) + newLine();
        }
        method += indent(1 + dim);
        for (int i = 0; i < dim; i++) {
            method += "if (dim == " + i + ") {" + newLine(0);
            method += indent(2 + dim) + "newData";
            for (int j = dim-1; j > 0; j--) {
                method += "[x" + j + "]";
            }

            int index = dim-1;
            method += " =  data";
            for (int j = dim-1; j >= 0; j--) {
                if (j == i) {
                    method += "[0]";
                } else {
                    method += "[x" + index + "]";
                    index--;
                }
            }

            method += ";" + newLine(0);
            method += indent(2 + dim) + "}" + newLine(0);
            method += (i==dim-1)? "" : indent(1 + dim) + "else ";
        }

        for (int i = 0; i < dim-1; i++) {
            method += indent(1 + dim - i) + "}" + newLine(0);
        }

        method += newLine();
        method += indent(2) + "return new Tensor" + (dim-1) + "d(newData);" + newLine(0);

        method += indent(1) + "}" + newLine(0);

        return method;
    }

    public static String[] genPieces(String arrayName, int dimensions) {
        String[] pieces = new String[dimensions];
        for (int i = 0; i < dimensions; i++) {
            String p = arrayName;
            for (int j = 0; j < i; j++) {
                p += "[0]";
            }
            p += ".length";
            pieces[i] = p;
        }
        return pieces;
    }

    public static String[] genLengthPieces(int dimensions) {
        String[] pieces = new String[dimensions];
        for (int i = 0; i < dimensions; i++) {
            String p = "[data";
            for (int j = 0; j < i; j++) {
                p += "[0]";
            }
            p += ".length<p>]";
            pieces[i] = p;
        }
        return pieces;
    }

    public static String[] genIterationPieces(int appendDim, int dimensions) {
        String[] pieces = new String[dimensions];
        for (int i = 0; i < dimensions; i++) {
            String s = (dimensions - 1 - i == appendDim) ? "newData" : "data";
            for (int j = 0; j < i; j++) {
                s += "[0]";
            }
            s += ".length";
            pieces[i] = s;
        }
        return pieces;
    }

    public static String forLine(int index, String piece) {
        return "for (int x" + index + " = 0; x"
                + index + " < " + piece + "; x" + index + "++) {";
    }

    public static String indent(int num) {
        return times(num, INDENT);
    }

    public static String times(int num, String s) {
        String fin = "";
        for (int i = 0; i < num; i++) {
            fin += s;
        }
        return fin;
    }

    public static String newLine(int indent) {
        return "\n" + indent(indent);
    }

    public static String newLine() {
        return "\n";
    }

    public static String genToString(int dim) {
        String method = newLine(2);
        method += "StringBuilder sb = new StringBuilder();";
        method += newLine(0);

        String[] iterationPieces = genIterationPieces(dim, dim);
        for (int i = dim - 1; i >= 0; i--) {
            method += indent(1 + dim - i) + forLine(i + 1, iterationPieces[dim - 1 - i]);
            method += newLine(0);
            method += indent(2 + dim - i);
            if (i == dim - 1) {
                method += "sb.append(\"[\");";
                method += newLine(0);
            } else if (i > 0 && i < dim - 1) {
                method += "sb.append(newLine());";
                method += newLine(0);
                method += indent(2 + dim - i) + "sb.append(\"";
                method += times(dim - 1 - i, " ");
                method += "[\");";
                method += newLine(0);
            } else if (i == 0){
                method += "sb.append(roundPrint(data";
                for (int j = dim; j > 0; j--) {
                    method += "[x" + j + "]";
                }
                method += ", 4));";
                method += newLine(0);
            }
        }

        method += indent(2 + dim) + "if (x1 < data";
        method += times(dim - 1, "[0]");
        method += ".length - 1) {";
        method += newLine(0);
        method += indent(3 + dim) + "sb.append(\", \");";
        method += newLine(2 + dim);
        method += "}";

        method += newLine(0);
        for (int i = dim - 1; i >= 0; i--) {
            method += indent(2 + i) + "}";
            method += newLine(0);
            if (i == dim - 1) {
                method += indent(2 + i) + "sb.append(\"]\");";
                method += newLine(0);
            }else if (i > 1 && i < dim - 1) {
                method += indent(2 + i) + "sb.append(newLine());";
                method += newLine(0);
                method += indent(2 + i) + "sb.append(\"";
                method += times(dim - 1 - i, " ");
                method += "]\");";
                method += newLine(0);
            }else if (i == 1) {
                method += indent(2 + i) + "sb.append(newLine());";
                method += newLine(0);
                method += indent(2 + i) + "sb.append(\"]\");";
                method += newLine(0);
                method += indent(2 + i) + "sb.append(newLine());";
                method += newLine(0);
            }
        }
        method += indent(2) + "return sb.toString();";

        return method;
    }

//
//    @Override
//    public String toString() {
//
//        StringBuilder sb = new StringBuilder();
//        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
//            sb.append("[");
//            for (int x3 = 0; x3 < data[0][0].length; x3++) {
//                sb.append(newLine());
//                sb.append(" [");
//                for (int x2 = 0; x2 < data[0].length; x2++) {
//                    sb.append(newLine());
//                    sb.append("  [");
//                    for (int x1 = 0; x1 < data.length; x1++) {
//                        sb.append(roundPrint(data[x1][x2][x3][x4], 4));
//                        if (x1 < data.length - 1) {
//                            sb.append(", ");
//                        }
//                    }
//                    sb.append("]");
//                }
//                sb.append(newLine());
//                sb.append(" ]");
//            }
//            sb.append(newLine());
//            sb.append("]");
//            sb.append(newLine());
//        }
//        return sb.toString();
//    }

}
