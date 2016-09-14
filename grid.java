package edu.clemson.cpsc2151.project1;


class grid
{
    private int x_max;
    private int y_max;
    private int[][] hits;
    private int[][] ship;

    private ship Carrier = new ship(5);
    private ship Battleship = new ship(4);
    private ship Cruiser = new ship(3);
    private ship Submarine = new ship(3);
    private ship Destroyer = new ship(2);

    private int battleshiphits = 0;
    private int carrierhits = 0;
    private int cruiserhits = 0;
    private int submarinehits = 0;
    private int destroyerhits = 0;

    grid(int x_max, int y_max)
    {
        setGridDimensions(x_max,y_max);

    }

    /**
     *
     * @param x_max largest grid value (x)
     * @param y_max largest grid value (y)
     */
    private void setGridDimensions(int x_max, int y_max)
    {
        this.x_max = x_max;
        this.y_max = y_max;
        hits = new int[x_max+1][y_max+1];
        ship = new int[x_max+1][y_max+1];
        for(int i=1; i<=x_max; i++ )
        {
            for(int z=1;z<=y_max; z++)
            {
                hits[i][z] = -1;
            }
        }
        for(int c = 0; c<x_max;c++)
        {
            hits[c+1][0] = c;
            ship[c+1][0] = c;
        }
        for(int c = 0; c<y_max;c++)
        {
            hits[0][c+1] = c;
            ship[0][c+1] = c;
        }

        for(int a=1; a<=x_max; a++ )
        {
            for(int b=1;b<=y_max; b++)
            {
                ship[a][b] = -1;
            }
        }
    }

    /**
     *
     * @param starting_x location to place (column-wise) on the grid
     * @param starting_y location to place (row-wise) on the grid
     * @param length length of the ship being placed
     * @param direction direction ship is facing
     */
    private void placeShip(int starting_x, int starting_y, int length, int direction)
    {
        if(direction == 0)
        {
            for(int i = 0; i<length; i++)
            {
                ship[starting_x + i][starting_y] = -2;
            }
        }

        else
        {
            for(int i = 0; i<length; i++)
            {
                ship[starting_x][starting_y + i] = -2;
            }
        }
    }

    /**
     *
     * @param starting_x location to place (column-wise) on the grid
     * @param starting_y location to place (row-wise) on the grid
     * @param length length of the ship being placed
     * @param direction direction ship is facing
     * @return true if ship has already been placed there or if it goes out of bounds.
     */

    private boolean isConflictingShipPlacement(int starting_x, int starting_y, int length, int direction)
    {

        if(direction == 0 && (starting_x  + length) > (y_max+1))
        {
            return true;
        }
        else if(direction == 1 && (starting_y  + length) > (x_max+1))
        {
            return true;
        }
        if(direction == 0)
        {
            for (int i = 0; i < length; i++) {
                if (ship[starting_x + i][starting_y] == -2) {
                    return true;
                }
            }
        }
        else if(direction == 1)
        {
            for (int i = 0; i < length; i++) {
                if (ship[starting_x][starting_y + i] == -2) {
                    return true;
                }
            }
        }
            return false;
    }

    /**
     *
     * @param x location to ask other player if ship location is there column-wise
     * @param y location to ask other player if ship location is there row-wise
     * @return 1 if hit ship and sunk, return 0 if a ship is hit, return -1 otherwise
     */
    int shoot(int x, int y)
    {
        if(Battleship.isHit(x,y) == 0)
        {
            battleshiphits++;
            if(battleshiphits == 4)
            {
                System.out.println("You have sunk the battleship");
                return 1;
            }
            return 0;
        }
        else if(Carrier.isHit(x,y) == 0)
        {
            carrierhits++;
            if(carrierhits == 5)
            {
                System.out.println("You have sunk the carrier");
                return 1;
            }
            return 0;
        }
        else if(Cruiser.isHit(x,y) == 0)
        {
            cruiserhits++;
            if(cruiserhits == 3)
            {
                System.out.println("You have sunk the cruiser");
                return 1;
            }
            return 0;
        }
        else if(Submarine.isHit(x,y) == 0)
        {
            submarinehits++;
            if(submarinehits == 3)
            {
                System.out.println("You have sunk the submarine");
                return 1;
            }
            return 0;
        }
        else if(Destroyer.isHit(x,y) == 0)
        {
            destroyerhits++;
            if(destroyerhits == 2)
            {
                System.out.println("You have sunk the destroyer");
                return 1;
            }
            return 0;
        }
        else
        {
            return -1;
        }
    }

    void updateHits(int x, int y, int number)
    {
        hits[x+1][y+1] = number;
    }

    /**
     *
     * @param x value to check to see if shot has already been made at that location
     * @param y value to check to see if shot has already been made at that location
     * @return true if hit/miss already registered on array, false otherwise
     */
    boolean hasBeenAttempted(int x, int y)
    {
        return hits[x + 1][y + 1] == -2 || hits[x + 1][y + 1] == -3;
    }

    /**
     *
     * @param showShips true if ship locations are to be displayed, false if hits/misses are to be displayed
     */
    void displayGrid(boolean showShips)
    {
        if(showShips == true)
        {
            for(int sx = 0; sx<=x_max; sx++)
            {
                for(int sy = 0; sy<=y_max; sy++)
                {
                    if(ship[sx][sy] != -1 && ship[sx][sy] != -2)
                    {
                        System.out.print(ship[sx][sy] + " ");
                    }
                    else if(ship[sx][sy] == -1)
                    {
                        System.out.print("- ");
                    }
                    else
                    {
                        System.out.print("@ ");
                    }
                }
                System.out.println();
            }
        }
        else if(showShips == false)
        {
            for(int sx = 0; sx<=x_max; sx++)
            {
                for(int sy = 0; sy<=y_max; sy++)
                {
                    if(hits[sx][sy] != -1 && hits[sx][sy] != -2 && hits[sx][sy] != -3)
                    {
                        System.out.print(hits[sx][sy] + " ");
                    }
                    else if(hits[sx][sy] == -1)
                    {
                        System.out.print("- ");
                    }
                    else if(hits[sx][sy] == -2)
                    {
                        System.out.print("X ");
                    }
                    else if(hits[sx][sy] == -3)
                    {
                        System.out.print("+ ");
                    }
                }
                System.out.println();
            }
        }
    }

    boolean place(int starting_x, int starting_y, int direction, String name)
    {
        switch(name)
        {
            case "CARRIER":
                if(isConflictingShipPlacement(starting_x+1,starting_y+1,5,direction) == false)
                {
                    Carrier.setLocation(starting_x,starting_y,direction);
                    placeShip(starting_x+1,starting_y+1,5,direction);
                    return true;
                }
                else
                {
                    return false;
                }
            case "BATTLESHIP":
                if(isConflictingShipPlacement(starting_x+1,starting_y+1,4,direction) == false)
                {
                    Battleship.setLocation(starting_x,starting_y,direction);
                    placeShip(starting_x+1,starting_y+1,4,direction);
                    return true;
                }
                else
                {
                    return false;
                }
            case "CRUISER":
                if(isConflictingShipPlacement(starting_x+1,starting_y+1,3,direction) == false)
                {
                    Cruiser.setLocation(starting_x,starting_y,direction);
                    placeShip(starting_x+1,starting_y+1,3,direction);
                    return true;
                }
                else
                {
                    return false;
                }
            case "SUBMARINE":
                if(isConflictingShipPlacement(starting_x+1,starting_y+1,3,direction) == false)
                {
                    Submarine.setLocation(starting_x,starting_y,direction);
                    placeShip(starting_x+1,starting_y+1,3,direction);
                    return true;
                }
                else
                {
                    return false;
                }
            case "DESTROYER":
                if(isConflictingShipPlacement(starting_x+1,starting_y+1,2,direction) == false)
                {
                    Destroyer.setLocation(starting_x,starting_y,direction);
                    placeShip(starting_x+1,starting_y+1,2,direction);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                return false;
        }

    }

}


