package edu.clemson.cpsc2151.project1;

import java.util.Random;

class HAL {

    int max_x = 0;
    int max_y = 0;
    int[][] hit;
    HAL(int x_max, int y_max) {
        max_x = x_max;
        max_y = y_max;
        hit = new int[x_max][y_max];
        for (int i = 0; i < x_max; i++) {
            for(int j = 0; j < y_max; j++)
            {
                hit[i][j] = 0;
            }
        }
    }

    int[] choose()
    {
        int[] retval = new int[3];
        Random r = new Random();
        retval[0] = r.nextInt(max_x);
        retval[1] = r.nextInt(max_y);
        retval[2] = r.nextInt(2);
        return retval;

    }

}
