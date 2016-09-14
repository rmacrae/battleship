package edu.clemson.cpsc2151.project1;


public class ship {


    int length = 0;
    int[] location_x;
    int[] location_y;
    ship(int len)
    {
        length = len;
        location_x = new int[length];
        location_y = new int[length];
    }

    void setLocation(int starting_x, int starting_y, int orientation)
    {
        if(orientation == 0)
        {
            for(int i = 0; i<length; i++)
            {
                location_x[i] = starting_x + i;
                location_y[i] = starting_y;
            }
        }
        else
        {
            for(int i = 0; i<length; i++)
            {
                location_x[i] = starting_x;
                location_y[i] = starting_y + i;
            }
        }
    }
    int isHit(int x, int y)
    {
        int count = 0;

        for(int z = 0; z<length; z++)
        {
            if((location_x[z]) == x && (location_y[z]) == y)
            {
                count++;
            }
        }
        if(count > 0)
        {
            return 0;
        }
        else
        {
            return -1;
        }

    }
}
