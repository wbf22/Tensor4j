package com.freedommuskrats.brarrays.util;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.freedommuskrats.brarrays.util.GeneralUtil.newLine;
import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;

public class DDClassGenerator {

    public final static String INDENT = "    ";

    public static void generate(int dimension, String savePath) throws IOException {
        String classString = Files.readString(
                Path.of("src/main/resources/dataDoubleClassGenSource.txt"),
                StandardCharsets.UTF_8
        );

        String arrayString = "double";
        for (int i = 0; i < dimension; i++) {
            arrayString += "[]";
        }

        String arrayStringLess = "double";
        for (int i = 0; i < dimension - 1; i++) {
            arrayStringLess += "[]";
        }

        classString = classString.replaceAll("<arrayType>", arrayString);
        classString = classString.replaceAll("<arrayTypeLess>", arrayStringLess);
        classString = classString.replaceAll("<num>", Integer.toString(dimension));
        classString = classString.replaceAll("<numLess>", Integer.toString(dimension - 1));

        String accessString = "data";
        for (int i = 0; i < dimension; i++) {
            accessString += "[index[" + i + "]]";
        }
        classString = classString.replaceAll("<access>", accessString);


        String appendMethod = genAppendMethod(classString, dimension, arrayString);
        classString = classString.replaceAll("<appendMethod>", appendMethod);

        String appendLessMethod = genAppendLessMethod(classString, dimension, arrayString, arrayStringLess);
        classString = classString.replaceAll("<appendLessMethod>", appendLessMethod);

        String verifyDimMethod = genVerifyDimsMethod(dimension);
        verifyDimMethod += genVerifyDimsMethod(dimension - 1);
        classString = classString.replaceAll("<verifyDimMethod>", verifyDimMethod);

        String toStringMethod = genToString(dimension);
        classString = classString.replaceAll("<toString>", toStringMethod);

        String getMethods = genGetMethod(dimension, dimension);
        for (int i = dimension - 1; i > 0; i--) {
            getMethods += genGetMethod(dimension, i);
        }
        classString = classString.replaceAll("<getMethod>", getMethods);



        Files.writeString(
                Path.of(savePath),
                classString,
                StandardCharsets.UTF_8
        );
    }

    public static String genAppendMethod(String classString, int dimension, String arrayString) {
        String appendMethod = newLine(0);

        for (int dim = 0; dim < dimension; dim++) {

            appendMethod += indent(2) +  "if (dim == " + dim + ") {";
            appendMethod += newLine(0);

            appendMethod += indent(3) + "verifyDimensions(ap, new int[]{";
            for (int i = 0; i < dimension; i++) {
                appendMethod += (i == dim) ? "ap" : "data";
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
                if (j == dim) {
                    rep += " + ap";
                    for (int k = 0; k < dim; k++) {
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
                appendMethod += indent(3 + i) + forLine(i + 1, iterationPieces[i]);
                appendMethod += newLine(0);
            }

            appendMethod += indent(3 + dimension) + "if (x";
            appendMethod += dim + 1;
            appendMethod += " < data";
            appendMethod += times(dim, "[0]");
            appendMethod += ".length) {";
            appendMethod += newLine(0);

            appendMethod += indent(4 + dimension) + "newData";
            for (int i = 0; i < dimension; i++) {
                appendMethod += "[x" + (i+1) + "]";
            }
            appendMethod += " = data";
            for (int i = 0; i < dimension; i++) {
                appendMethod += "[x" + (i+1) + "]";
            }
            appendMethod += ";";
            appendMethod += newLine(3 + dimension);
            appendMethod += "} else {";
            appendMethod += newLine(0);
            appendMethod += indent(4 + dimension) + "newData";
            for (int i = 0; i < dimension; i++) {
                appendMethod += "[x" + (i+1) + "]";
            }
            appendMethod += " = ap";
            for (int i = 0; i < dimension; i++) {
                if (dim == i) {
                    appendMethod += "[x" + (i+1) + " - data";
                    for (int j = 0; j < dim; j++) {
                        appendMethod += "[0]";
                    }
                    appendMethod += ".length]";
                } else {
                    appendMethod += "[x" + (i+1) + "]";
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
            for (int j = 0; j < i; j++) {
                appendMethod += "[0]";
            }
            appendMethod += (i != dim - 2)? ".length, " : ".length});" + newLine(0);
        }

        appendMethod += indent(2) + arrayString
                + " newData = new double";
        String[] pieces = genLengthPieces(dim);
        for (int j = 0; j < pieces.length; j++) {
            String mod = pieces[j];
            String rep = (j == pieces.length - 1)? " + 1" : "";
            mod = mod.replaceAll("<p>", rep);

            appendMethod += mod;
        }
        appendMethod += ";";
        appendMethod += newLine(0);

        String[] iterationPieces = genIterationPieces(dim -1, dim);
        for (int i = 0; i < dim; i++) {
            appendMethod += indent(2 + i) + forLine(i + 1, iterationPieces[i]);
            appendMethod += newLine(0);
        }

        appendMethod += indent(2 + dim) + "if (x";
        appendMethod += dim;
        appendMethod += " < data";
        appendMethod += times(dim - 1, "[0]");
        appendMethod += ".length) {";
        appendMethod += newLine(0);

        appendMethod += indent(3 + dim) + "newData";
        for (int i = 0; i < dim; i++) {
            appendMethod += "[x" + (i+1) + "]";
        }
        appendMethod += " = data";
        for (int i = 0; i < dim; i++) {
            appendMethod += "[x" + (i+1) + "]";
        }
        appendMethod += ";";
        appendMethod += newLine(2 + dim);
        appendMethod += "} else {";
        appendMethod += newLine(0);
        appendMethod += indent(3 + dim) + "newData";
        for (int i = 0; i < dim; i++) {
            appendMethod += "[x" + (i+1) + "]";
        }
        appendMethod += " = ap";
        for (int i = 0; i < dim - 1; i++) {
            if (dim == i) {
                appendMethod += "[x" + (i+1) + " - data";
                for (int j = 0; j < dim; j++) {
                    appendMethod += "[0]";
                }
                appendMethod += ".length]";
            } else {
                appendMethod += "[x" + (i+1) + "]";
            }
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

    public static String genVerifyDimsMethod(int dim) {
        String fileString = newLine(0);

        fileString +=  indent(1) + "public static void verifyDimensions(double";
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
            String s = (i == appendDim) ? "newData" : "data";
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

    public static String genToString(int dim) {
        String method = newLine(2);
        method += "StringBuilder sb = new StringBuilder();";
        method += newLine(0);

        String[] iterationPieces = genIterationPieces(dim, dim);
        for (int i = dim - 1; i >= 0; i--) {
            method += indent(1 + dim - i) + forLine(i + 1, iterationPieces[i]);
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
                for (int j = 0; j < dim; j++) {
                    method += "[x" + (j+1) + "]";
                }
                method += ", 4));";
                method += newLine(0);
            }
        }

        method += indent(2 + dim) + "if (x1 < data.length - 1) {";
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

    public static String genGetMethod(int dim, int acc) {
        String method = newLine(0);
        method += indent(1) + "public double";
        for (int i = 0; i < dim - acc; i++) {
            method += "[]";
        }

        method += " get(";
        for (int i = 0; i < acc; i++) {
            method += "int x" + (i+1);
            method += (i == acc - 1)? ") {" : ", ";
        }
        method += newLine(0);

        method +=  indent(2) + "return data";
        for (int i = 0; i < acc; i++) {
            method += "[x" + (i+1) + "]";
        }
        method += ";";
        method += newLine(0);

        method += indent(1) + "}";
        newLine(0);

        return method;
    }
}
