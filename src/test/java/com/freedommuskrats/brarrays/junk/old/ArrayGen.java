package com.freedommuskrats.brarrays.junk.old;

import java.util.Random;

public class ArrayGen {

    public static Object[] genArray1d(Class<?> type, Object filler, int[] size) {
        Object[] arr = new Object[size[0]];
        for (int i1 = 0; i1 < size[0]; i1++) {
            arr[i1] = getFiller(filler, type);
        }
        return arr;
    }

    public static Object[][] genArray2d(Class<?> type, Object filler, int[] size) {
        Object[][] arr = new Object[size[1]][size[0]];
        for (int i1 = 0; i1 < size[1]; i1++) {
            for (int i2 = 0; i2 < size[0]; i2++) {
                arr[i1][i2] = getFiller(filler, type);
            }
        }
        return arr;
    }

    public static Object[][][] genArray3d(Class<?> type, Object filler, int[] size) {
        Object[][][] arr = new Object[size[2]][size[1]][size[0]];
        for (int i1 = 0; i1 < size[2]; i1++) {
            for (int i2 = 0; i2 < size[1]; i2++) {
                for (int i3 = 0; i3 < size[0]; i3++) {
                    arr[i1][i2][i3] = getFiller(filler, type);
                }
            }
        }
        return arr;
    }

    public static Object[][][][] genArray4d(Class<?> type, Object filler, int[] size) {
        Object[][][][] arr = new Object[size[3]][size[2]][size[1]][size[0]];
        for (int i1 = 0; i1 < size[3]; i1++) {
            for (int i2 = 0; i2 < size[2]; i2++) {
                for (int i3 = 0; i3 < size[1]; i3++) {
                    for (int i4 = 0; i4 < size[0]; i4++) {
                        arr[i1][i2][i3][i4] = getFiller(filler, type);
                    }
                }
            }
        }
        return arr;
    }

//    public static Object[][][][][] genArray5d(Class<?> type, Object filler, int[] size) {
//        Object[][][][][] arr = new Object[size[0]][size[1]][size[2]][size[3]][size[4]];
//        for (int i1 = 0; i1 < size[0]; i1++) {
//            for (int i2 = 0; i2 < size[1]; i2++) {
//                for (int i3 = 0; i3 < size[2]; i3++) {
//                    for (int i4 = 0; i4 < size[3]; i4++) {
//                        for (int i5 = 0; i5 < size[4]; i5++) {
//                            arr[i1][i2][i3][i4][i5] = getFiller(filler, type);
//                        }
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][][][][] genArray6d(Class<?> type, Object filler, int[] size) {
//        Object[][][][][][] arr = new Object[size[0]][size[1]][size[2]][size[3]][size[4]][size[5]];
//        for (int i1 = 0; i1 < size[0]; i1++) {
//            for (int i2 = 0; i2 < size[1]; i2++) {
//                for (int i3 = 0; i3 < size[2]; i3++) {
//                    for (int i4 = 0; i4 < size[3]; i4++) {
//                        for (int i5 = 0; i5 < size[4]; i5++) {
//                            for (int i6 = 0; i6 < size[5]; i6++) {
//                                arr[i1][i2][i3][i4][i5][i6] = getFiller(filler, type);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][][][][][] genArray7d(Class<?> type, Object filler, int[] size) {
//        Object[][][][][][][] arr = new Object[size[0]][size[1]][size[2]][size[3]][size[4]][size[5]][size[6]];
//        for (int i1 = 0; i1 < size[0]; i1++) {
//            for (int i2 = 0; i2 < size[1]; i2++) {
//                for (int i3 = 0; i3 < size[2]; i3++) {
//                    for (int i4 = 0; i4 < size[3]; i4++) {
//                        for (int i5 = 0; i5 < size[4]; i5++) {
//                            for (int i6 = 0; i6 < size[5]; i6++) {
//                                for (int i7 = 0; i7 < size[6]; i7++) {
//                                    arr[i1][i2][i3][i4][i5][i6][i7] = getFiller(filler, type);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][][][][][][] genArray8d(Class<?> type, Object filler, int[] size) {
//        Object[][][][][][][][] arr = new Object[size[0]][size[1]][size[2]][size[3]][size[4]][size[5]][size[6]][size[7]];
//        for (int i1 = 0; i1 < size[0]; i1++) {
//            for (int i2 = 0; i2 < size[1]; i2++) {
//                for (int i3 = 0; i3 < size[2]; i3++) {
//                    for (int i4 = 0; i4 < size[3]; i4++) {
//                        for (int i5 = 0; i5 < size[4]; i5++) {
//                            for (int i6 = 0; i6 < size[5]; i6++) {
//                                for (int i7 = 0; i7 < size[6]; i7++) {
//                                    for (int i8 = 0; i8 < size[7]; i8++) {
//                                        arr[i1][i2][i3][i4][i5][i6][i7][i8] = getFiller(filler, type);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return arr;
//    }

//
//    public static Object[] genArray1d(Class<?> type, Object filler, int[] size) {
//        Object[] arr = new Object[size[0]];
//        for (int i1 = 0; i1 < size[0]; i1++) {
//            arr[i1] = getFiller(filler, type);
//        }
//        return arr;
//    }
//
//    public static Object[][] genArray2d(Class<?> type, Object filler, int[] size) {
//        Object[][] arr = new Object[size[1]][size[0]];
//        for (int i1 = 0; i1 < size[1]; i1++) {
//            for (int i2 = 0; i2 < size[0]; i2++) {
//                arr[i1][i2] = getFiller(filler, type);
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][] genArray3d(Class<?> type, Object filler, int[] size) {
//        Object[][][] arr = new Object[size[2]][size[1]][size[0]];
//        for (int i1 = 0; i1 < size[2]; i1++) {
//            for (int i2 = 0; i2 < size[1]; i2++) {
//                for (int i3 = 0; i3 < size[0]; i3++) {
//                    arr[i1][i2][i3] = getFiller(filler, type);
//                }
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][][] genArray4d(Class<?> type, Object filler, int[] size) {
//        Object[][][][] arr = new Object[size[3]][size[2]][size[1]][size[0]];
//        for (int i1 = 0; i1 < size[3]; i1++) {
//            for (int i2 = 0; i2 < size[2]; i2++) {
//                for (int i3 = 0; i3 < size[1]; i3++) {
//                    for (int i4 = 0; i4 < size[0]; i4++) {
//                        arr[i1][i2][i3][i4] = getFiller(filler, type);
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][][][] genArray5d(Class<?> type, Object filler, int[] size) {
//        Object[][][][][] arr = new Object[size[4]][size[3]][size[2]][size[1]][size[0]];
//        for (int i1 = 0; i1 < size[4]; i1++) {
//            for (int i2 = 0; i2 < size[3]; i2++) {
//                for (int i3 = 0; i3 < size[2]; i3++) {
//                    for (int i4 = 0; i4 < size[1]; i4++) {
//                        for (int i5 = 0; i5 < size[0]; i5++) {
//                            arr[i1][i2][i3][i4][i5] = getFiller(filler, type);
//                        }
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][][][][] genArray6d(Class<?> type, Object filler, int[] size) {
//        Object[][][][][][] arr = new Object[size[5]][size[4]][size[3]][size[2]][size[1]][size[0]];
//        for (int i1 = 0; i1 < size[5]; i1++) {
//            for (int i2 = 0; i2 < size[4]; i2++) {
//                for (int i3 = 0; i3 < size[3]; i3++) {
//                    for (int i4 = 0; i4 < size[2]; i4++) {
//                        for (int i5 = 0; i5 < size[1]; i5++) {
//                            for (int i6 = 0; i6 < size[0]; i6++) {
//                                arr[i1][i2][i3][i4][i5][i6] = getFiller(filler, type);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][][][][][] genArray7d(Class<?> type, Object filler, int[] size) {
//        Object[][][][][][][] arr = new Object[size[6]][size[5]][size[4]][size[3]][size[2]][size[1]][size[0]];
//        for (int i1 = 0; i1 < size[6]; i1++) {
//            for (int i2 = 0; i2 < size[5]; i2++) {
//                for (int i3 = 0; i3 < size[4]; i3++) {
//                    for (int i4 = 0; i4 < size[3]; i4++) {
//                        for (int i5 = 0; i5 < size[2]; i5++) {
//                            for (int i6 = 0; i6 < size[1]; i6++) {
//                                for (int i7 = 0; i7 < size[0]; i7++) {
//                                    arr[i1][i2][i3][i4][i5][i6][i7] = getFiller(filler, type);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//
//    public static Object[][][][][][][][] genArray8d(Class<?> type, Object filler, int[] size) {
//        Object[][][][][][][][] arr = new Object[size[7]][size[6]][size[5]][size[4]][size[3]][size[2]][size[1]][size[0]];
//        for (int i1 = 0; i1 < size[7]; i1++) {
//            for (int i2 = 0; i2 < size[6]; i2++) {
//                for (int i3 = 0; i3 < size[5]; i3++) {
//                    for (int i4 = 0; i4 < size[4]; i4++) {
//                        for (int i5 = 0; i5 < size[3]; i5++) {
//                            for (int i6 = 0; i6 < size[2]; i6++) {
//                                for (int i7 = 0; i7 < size[1]; i7++) {
//                                    for (int i8 = 0; i8 < size[0]; i8++) {
//                                        arr[i1][i2][i3][i4][i5][i6][i7][i8] = getFiller(filler, type);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//



    private static Object getFiller(Object filler, Class<?> type) {
        if(filler instanceof Random) {
            if (type == Double.class) {
                return ((Random) filler).nextDouble();
            }
            else if (type == Integer.class) {
                return ((Random) filler).nextInt();
            }
        }
        else {
            return filler;
        }

        return null;
    }



}
