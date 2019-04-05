/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package test;

/**
 * TestFinalize.
 *
 * @author Ilya_Gulevskiy
 */
public class TestFinalize {

    static class Test {
        @Override
        protected void finalize() {
            System.out.println("From finalize");
        }
    }

    public static void run() {
        Test t = new Test();
//        System.exit(0);

//        t.toString();
    }

}
