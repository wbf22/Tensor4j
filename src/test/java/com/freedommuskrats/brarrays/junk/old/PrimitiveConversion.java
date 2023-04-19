package com.freedommuskrats.brarrays.junk.old;

public class PrimitiveConversion {

    //TODO defaultValue is actually just a hack but could be used to protect null casting. Implement that
    //TODO wrap this class in something so users don't see errors from here

    public static double[] toPrimitive(Object[] array, double defaultValue) {
        double[] ret = new double[array.length];
        for (int i1 = 0; i1 < array.length; i1++) {
            ret[i1] = (double) array[i1];
        }
        return ret;
    }

    public static double[][] toPrimitive(Object[][] array, double defaultValue) {
        double[][] ret = new double[array.length][array[0].length];
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = 0; i2 < array[0].length; i2++) {
                ret[i1][i2] = (double) array[i1][i2];
            }
        }
        return ret;
    }

    public static double[][][] toPrimitive(Object[][][] array, double defaultValue) {
        double[][][] ret = new double[array.length][array[0].length][array[0][0].length];
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = 0; i2 < array[0].length; i2++) {
                for (int i3 = 0; i3 < array[0][0].length; i3++) {
                    ret[i1][i2][i3] = (double) array[i1][i2][i3];
                }
            }
        }
        return ret;
    }

    public static double[][][][] toPrimitive(Object[][][][] array, double defaultValue) {
        double[][][][] ret = new double[array.length][array[0].length][array[0][0].length][array[0][0][0].length];
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = 0; i2 < array[0].length; i2++) {
                for (int i3 = 0; i3 < array[0][0].length; i3++) {
                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
                        ret[i1][i2][i3][i4] = (double) array[i1][i2][i3][i4];
                    }
                }
            }
        }
        return ret;
    }

    public static double[][][][][] toPrimitive(Object[][][][][] array, double defaultValue) {
        double[][][][][] ret = new double[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length];
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = 0; i2 < array[0].length; i2++) {
                for (int i3 = 0; i3 < array[0][0].length; i3++) {
                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
                            ret[i1][i2][i3][i4][i5] = (double) array[i1][i2][i3][i4][i5];
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static double[][][][][][] toPrimitive(Object[][][][][][] array, double defaultValue) {
        double[][][][][][] ret = new double[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length];
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = 0; i2 < array[0].length; i2++) {
                for (int i3 = 0; i3 < array[0][0].length; i3++) {
                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
                                ret[i1][i2][i3][i4][i5][i6] = (double) array[i1][i2][i3][i4][i5][i6];
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static double[][][][][][][] toPrimitive(Object[][][][][][][] array, double defaultValue) {
        double[][][][][][][] ret = new double[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length][array[0][0][0][0][0][0].length];
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = 0; i2 < array[0].length; i2++) {
                for (int i3 = 0; i3 < array[0][0].length; i3++) {
                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
                                for (int i7 = 0; i7 < array[0][0][0][0][0][0].length; i7++) {
                                    ret[i1][i2][i3][i4][i5][i6][i7] = (double) array[i1][i2][i3][i4][i5][i6][i7];
                                }
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static double[][][][][][][][] toPrimitive(Object[][][][][][][][] array, double defaultValue) {
        double[][][][][][][][] ret = new double[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length][array[0][0][0][0][0][0].length][array[0][0][0][0][0][0][0].length];
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = 0; i2 < array[0].length; i2++) {
                for (int i3 = 0; i3 < array[0][0].length; i3++) {
                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
                                for (int i7 = 0; i7 < array[0][0][0][0][0][0].length; i7++) {
                                    for (int i8 = 0; i8 < array[0][0][0][0][0][0][0].length; i8++) {
                                        ret[i1][i2][i3][i4][i5][i6][i7][i8] = (double) array[i1][i2][i3][i4][i5][i6][i7][i8];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

//
//    public static int[] toPrimitive(Object[] array, int defaultValue) {
//        int[] ret = new int[array.length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            ret[i1] = (int) array[i1];
//        }
//        return ret;
//    }
//
//    public static int[][] toPrimitive(Object[][] array, int defaultValue) {
//        int[][] ret = new int[array.length][array[0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                ret[i1][i2] = (int) array[i1][i2];
//            }
//        }
//        return ret;
//    }
//
//    public static int[][][] toPrimitive(Object[][][] array, int defaultValue) {
//        int[][][] ret = new int[array.length][array[0].length][array[0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    ret[i1][i2][i3] = (int) array[i1][i2][i3];
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static int[][][][] toPrimitive(Object[][][][] array, int defaultValue) {
//        int[][][][] ret = new int[array.length][array[0].length][array[0][0].length][array[0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        ret[i1][i2][i3][i4] = (int) array[i1][i2][i3][i4];
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static int[][][][][] toPrimitive(Object[][][][][] array, int defaultValue) {
//        int[][][][][] ret = new int[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            ret[i1][i2][i3][i4][i5] = (int) array[i1][i2][i3][i4][i5];
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static int[][][][][][] toPrimitive(Object[][][][][][] array, int defaultValue) {
//        int[][][][][][] ret = new int[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                ret[i1][i2][i3][i4][i5][i6] = (int) array[i1][i2][i3][i4][i5][i6];
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static int[][][][][][][] toPrimitive(Object[][][][][][][] array, int defaultValue) {
//        int[][][][][][][] ret = new int[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length][array[0][0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                for (int i7 = 0; i7 < array[0][0][0][0][0][0].length; i7++) {
//                                    ret[i1][i2][i3][i4][i5][i6][i7] = (int) array[i1][i2][i3][i4][i5][i6][i7];
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static int[][][][][][][][] toPrimitive(Object[][][][][][][][] array, int defaultValue) {
//        int[][][][][][][][] ret = new int[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length][array[0][0][0][0][0][0].length][array[0][0][0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                for (int i7 = 0; i7 < array[0][0][0][0][0][0].length; i7++) {
//                                    for (int i8 = 0; i8 < array[0][0][0][0][0][0][0].length; i8++) {
//                                        ret[i1][i2][i3][i4][i5][i6][i7][i8] = (int) array[i1][i2][i3][i4][i5][i6][i7][i8];
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//
//    public static float[] toPrimitive(Object[] array, float defaultValue) {
//        float[] ret = new float[array.length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            ret[i1] = (float) array[i1];
//        }
//        return ret;
//    }
//
//    public static float[][] toPrimitive(Object[][] array, float defaultValue) {
//        float[][] ret = new float[array.length][array[0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                ret[i1][i2] = (float) array[i1][i2];
//            }
//        }
//        return ret;
//    }
//
//    public static float[][][] toPrimitive(Object[][][] array, float defaultValue) {
//        float[][][] ret = new float[array.length][array[0].length][array[0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    ret[i1][i2][i3] = (float) array[i1][i2][i3];
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static float[][][][] toPrimitive(Object[][][][] array, float defaultValue) {
//        float[][][][] ret = new float[array.length][array[0].length][array[0][0].length][array[0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        ret[i1][i2][i3][i4] = (float) array[i1][i2][i3][i4];
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static float[][][][][] toPrimitive(Object[][][][][] array, float defaultValue) {
//        float[][][][][] ret = new float[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            ret[i1][i2][i3][i4][i5] = (float) array[i1][i2][i3][i4][i5];
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static float[][][][][][] toPrimitive(Object[][][][][][] array, float defaultValue) {
//        float[][][][][][] ret = new float[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                ret[i1][i2][i3][i4][i5][i6] = (float) array[i1][i2][i3][i4][i5][i6];
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static float[][][][][][][] toPrimitive(Object[][][][][][][] array, float defaultValue) {
//        float[][][][][][][] ret = new float[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length][array[0][0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                for (int i7 = 0; i7 < array[0][0][0][0][0][0].length; i7++) {
//                                    ret[i1][i2][i3][i4][i5][i6][i7] = (float) array[i1][i2][i3][i4][i5][i6][i7];
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static float[][][][][][][][] toPrimitive(Object[][][][][][][][] array, float defaultValue) {
//        float[][][][][][][][] ret = new float[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length][array[0][0][0][0][0][0].length][array[0][0][0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                for (int i7 = 0; i7 < array[0][0][0][0][0][0].length; i7++) {
//                                    for (int i8 = 0; i8 < array[0][0][0][0][0][0][0].length; i8++) {
//                                        ret[i1][i2][i3][i4][i5][i6][i7][i8] = (float) array[i1][i2][i3][i4][i5][i6][i7][i8];
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//
//    public static long[] toPrimitive(Object[] array, long defaultValue) {
//        long[] ret = new long[array.length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            ret[i1] = (long) array[i1];
//        }
//        return ret;
//    }
//
//    public static long[][] toPrimitive(Object[][] array, long defaultValue) {
//        long[][] ret = new long[array.length][array[0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                ret[i1][i2] = (long) array[i1][i2];
//            }
//        }
//        return ret;
//    }
//
//    public static long[][][] toPrimitive(Object[][][] array, long defaultValue) {
//        long[][][] ret = new long[array.length][array[0].length][array[0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    ret[i1][i2][i3] = (long) array[i1][i2][i3];
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static long[][][][] toPrimitive(Object[][][][] array, long defaultValue) {
//        long[][][][] ret = new long[array.length][array[0].length][array[0][0].length][array[0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        ret[i1][i2][i3][i4] = (long) array[i1][i2][i3][i4];
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static long[][][][][] toPrimitive(Object[][][][][] array, long defaultValue) {
//        long[][][][][] ret = new long[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            ret[i1][i2][i3][i4][i5] = (long) array[i1][i2][i3][i4][i5];
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static long[][][][][][] toPrimitive(Object[][][][][][] array, long defaultValue) {
//        long[][][][][][] ret = new long[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                ret[i1][i2][i3][i4][i5][i6] = (long) array[i1][i2][i3][i4][i5][i6];
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static long[][][][][][][] toPrimitive(Object[][][][][][][] array, long defaultValue) {
//        long[][][][][][][] ret = new long[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length][array[0][0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                for (int i7 = 0; i7 < array[0][0][0][0][0][0].length; i7++) {
//                                    ret[i1][i2][i3][i4][i5][i6][i7] = (long) array[i1][i2][i3][i4][i5][i6][i7];
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    public static long[][][][][][][][] toPrimitive(Object[][][][][][][][] array, long defaultValue) {
//        long[][][][][][][][] ret = new long[array.length][array[0].length][array[0][0].length][array[0][0][0].length][array[0][0][0][0].length][array[0][0][0][0][0].length][array[0][0][0][0][0][0].length][array[0][0][0][0][0][0][0].length];
//        for (int i1 = 0; i1 < array.length; i1++) {
//            for (int i2 = 0; i2 < array[0].length; i2++) {
//                for (int i3 = 0; i3 < array[0][0].length; i3++) {
//                    for (int i4 = 0; i4 < array[0][0][0].length; i4++) {
//                        for (int i5 = 0; i5 < array[0][0][0][0].length; i5++) {
//                            for (int i6 = 0; i6 < array[0][0][0][0][0].length; i6++) {
//                                for (int i7 = 0; i7 < array[0][0][0][0][0][0].length; i7++) {
//                                    for (int i8 = 0; i8 < array[0][0][0][0][0][0][0].length; i8++) {
//                                        ret[i1][i2][i3][i4][i5][i6][i7][i8] = (long) array[i1][i2][i3][i4][i5][i6][i7][i8];
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }

}
