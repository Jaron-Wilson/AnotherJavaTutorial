package org.jmw.answer;

import java.util.Scanner;

    public class Answer01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter height: ");

        // This method reads the number provided using keyboard
        int height = scan.nextInt();

        // Closing Scanner after the use
        scan.close();
        draw(height, 'X');
    }

    /**
     * This method draws a triangle given the two parameters. For example, if
     * you call draw(5,'X') the output will look like:
     * <pre>
     *    X
     *    XX
     *    XXX
     *    XXXX
     *    XXXXX
     * </pre>
     *
     * @param height The height of the triangle.
     * @param c      The character to draw shape with.
     */
    public static void draw(int height, char c) {
        //Starts at 1 and goes to your height.
        for (int y = 1; y <= height; y++) {
            //Starts at 1 and goes while less than height.
            for (int x = 1; x <= y; x++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    public static void debug(int height, char c) {
        //Starts at 1 and goes to your height.
        for (int i = 1; i <= height; i++) {

            System.out.print("i=" + i + " ");
            //Starts at 1 and goes while less than height.
            for (int j = 1; j <= i; j++) {
                System.out.print("[j=" + j + "]");
            }
            System.out.println();
        }
    }
}
