package org.jmw.answer;

import java.util.Scanner;

public class Answer10 {
    private static char c;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter height dad: ");
        // This method reads the number provided using keyboard
        int height = scan.nextInt();

        // Closing Scanner after the use
        scan.close();
        draw(height, 'X');
    }

    /**
     * This method draws a triangle given the two parameters. For example, if
     * you call draw(5, '*') the output will look like:
     * <pre>
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     * </pre>
     *
     * @param h The height of the triangle.
     * @param c      The character to draw shape with.
     */
    public static void draw(int h, char c) {
        //Starts at 1 and goes to your height.
        for (int y = h; y > 0; y--) {
            //Starts at 1 and goes while less than height.
            for (int x = 0; x < h; x++) {
                System.out.print(x < y ? " " : c + "X");
            }
            System.out.println();
        }
    }
}
