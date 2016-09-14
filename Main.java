/*  Ryan MacRae
    CPSC 2150
    Battleship Project - Assignment 1
    September 13, 2016
    Description: A program that will allow 2 players (Human or AI) to play battleship
 */

package edu.clemson.cpsc2151.project1;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {

        System.out.println("   ___       __  __  __        __   _    ");
        System.out.println("  / _ )___ _/ /_/ /_/ /__ ___ / /  (_)__ ");
        System.out.println(" / _  / _ `/ __/ __/ / -_|_-</ _ \\/ / _ \\");
        System.out.println("/____/\\_,_/\\__/\\__/_/\\__/___/_//_/_/ .__/");
        System.out.println("                                  /_/    ");
        boolean tf = false;
        grid p1 = new grid(10,10);
        grid p2 = new grid(10,10);
        int direction = 0;

        System.out.println();
        System.out.println("Please Choose a Player 1: Human or AI");
        System.out.println("Press 1 for Human or 2 for AI:");
        Scanner ch1 = new Scanner(System.in);
        int one = ch1.nextInt();
        System.out.println("Please Choose a Player 2: Human or AI");
        System.out.println("Press 1 for Human or 2 for AI:");
        Scanner ch2 = new Scanner(System.in);
        int two = ch2.nextInt();

        switch(one){
            case 1:
                while(!tf)
                {
                    p1.displayGrid(true);
                    System.out.println("PLAYER 1:");
                    System.out.println("Please place your Carrier (length 5)");
                    Scanner a = new Scanner(System.in);
                    String a1 = a.nextLine();
                    String a2[] = a1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner b = new Scanner(System.in);
                    String b1 = b.nextLine();

                    if (b1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }
                    tf = p1.place(Integer.parseInt(a2[0]),Integer.parseInt(a2[1]),direction,"CARRIER");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }

                tf = false;
                while(!tf)
                {
                    p1.displayGrid(true);
                    System.out.println("PLAYER 1:");
                    System.out.println("Please place your Battleship (length 4)");
                    Scanner c = new Scanner(System.in);
                    String c1 = c.nextLine();
                    String c2[] = c1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner d = new Scanner(System.in);
                    String d1 = d.nextLine();
                    if (d1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p1.place(Integer.parseInt(c2[0]), Integer.parseInt(c2[1]), direction, "BATTLESHIP");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }

                tf = false;
                while(!tf)
                {
                    p1.displayGrid(true);
                    System.out.println("PLAYER 1:");
                    System.out.println("Please place your Cruiser (length 3)");
                    Scanner e = new Scanner(System.in);
                    String e1 = e.nextLine();
                    String e2[] = e1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner f = new Scanner(System.in);
                    String f1 = f.nextLine();
                    if (f1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p1.place(Integer.parseInt(e2[0]), Integer.parseInt(e2[1]), direction, "CRUISER");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }

                tf = false;
                while (!tf)
                {
                    p1.displayGrid(true);
                    System.out.println("PLAYER 1:");
                    System.out.println("Please place your Submarine (length 3)");
                    Scanner g = new Scanner(System.in);
                    String g1 = g.nextLine();
                    String g2[] = g1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner h = new Scanner(System.in);
                    String h1 = h.nextLine();
                    if (h1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p1.place(Integer.parseInt(g2[0]), Integer.parseInt(g2[1]), direction, "SUBMARINE");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }

                tf = false;
                while(!tf)
                {
                    p1.displayGrid(true);
                    System.out.println("PLAYER 1:");
                    System.out.println("Please place your Destroyer (length 2)");
                    Scanner i = new Scanner(System.in);
                    String i1 = i.nextLine();
                    String i2[] = i1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner j = new Scanner(System.in);
                    String j1 = j.nextLine();
                    if (j1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p1.place(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), direction, "DESTROYER");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }
            case 2:
                HAL hal = new HAL(10,10);
                int[] value1;
                value1 = hal.choose();
                tf = p1.place(value1[0], value1[1], value1[2], "BATTLESHIP");
                while(!tf)
                {
                    value1 = hal.choose();
                    tf = p1.place(value1[0], value1[1], value1[2], "BATTLESHIP");
                }
                value1 = hal.choose();
                tf = p1.place(value1[0], value1[1], value1[2], "CARRIER");
                while(!tf)
                {
                    value1 = hal.choose();
                    tf = p1.place(value1[0], value1[1], value1[2], "CARRIER");
                }
                value1 = hal.choose();
                tf = p1.place(value1[0], value1[1], value1[2], "CRUISER");
                while(!tf)
                {
                    value1 = hal.choose();
                    tf = p1.place(value1[0], value1[1], value1[2], "CRUISER");
                }
                tf = p1.place(value1[0], value1[1], value1[2], "SUBMARINE");
                while(!tf)
                {
                    value1 = hal.choose();
                    tf = p1.place(value1[0], value1[1], value1[2], "SUBMARINE");
                }
                tf = p1.place(value1[0], value1[1], value1[2], "DESTROYER");
                while(!tf)
                {
                    value1 = hal.choose();
                    tf = p1.place(value1[0], value1[1], value1[2], "DESTROYER");
                }
                System.out.println("PLAYER 1 Grid");
                p1.displayGrid(true);
        }

        switch(two){
            case 1:
                tf = false;
                while(!tf)
                {

                    p2.displayGrid(true);
                    System.out.println("PLAYER 2:");
                    System.out.println("Please place your Carrier (length 5)");
                    Scanner k = new Scanner(System.in);
                    String k1 = k.nextLine();
                    String k2[] = k1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner l = new Scanner(System.in);
                    String l1 = l.nextLine();
                    if (l1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p2.place(Integer.parseInt(k2[0]), Integer.parseInt(k2[1]), direction, "CARRIER");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }

                tf = false;
                while(!tf)
                {
                    p2.displayGrid(true);
                    System.out.println("PLAYER 2:");
                    System.out.println("Please place your Battleship (length 4)");
                    Scanner m = new Scanner(System.in);
                    String m1 = m.nextLine();
                    String m2[] = m1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner n = new Scanner(System.in);
                    String n1 = n.nextLine();
                    if (n1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p2.place(Integer.parseInt(m2[0]), Integer.parseInt(m2[1]), direction, "BATTLESHIP");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }

                tf = false;
                while(!tf)
                {
                    p2.displayGrid(true);
                    System.out.println("PLAYER 2:");
                    System.out.println("Please place your Cruiser (length 3)");
                    Scanner o = new Scanner(System.in);
                    String o1 = o.nextLine();
                    String o2[] = o1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner u = new Scanner(System.in);
                    String u2 = u.nextLine();
                    if (u2.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p2.place(Integer.parseInt(o2[0]), Integer.parseInt(o2[1]), direction, "CRUISER");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }

                tf = false;
                while(!tf)
                {

                    p2.displayGrid(true);
                    System.out.println("PLAYER 2:");
                    System.out.println("Please place your Submarine (length 3)");
                    Scanner q = new Scanner(System.in);
                    String q1 = q.nextLine();
                    String q2[] = q1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner r = new Scanner(System.in);
                    String r1 = r.nextLine();
                    if (r1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p2.place(Integer.parseInt(q2[0]), Integer.parseInt(q2[1]), direction, "SUBMARINE");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }
                tf = false;
                while(!tf)
                {
                    p2.displayGrid(true);

                    System.out.println("PLAYER 2:");
                    System.out.println("Please place your Destroyer (length 2)");
                    Scanner s = new Scanner(System.in);
                    String s1 = s.nextLine();
                    String s2[] = s1.split(",");
                    System.out.println("Choose Orientation (d/r):");
                    Scanner t = new Scanner(System.in);
                    String t1 = t.nextLine();
                    if (t1.equalsIgnoreCase("d")) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }

                    tf = p2.place(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]), direction, "DESTROYER");
                    if(!tf)
                    {
                        System.out.println("Error, please choose another location");
                    }
                }
                p2.displayGrid(true);
            case 2:
                HAL hal2 = new HAL(10,10);
                int[] value2;
                value2 = hal2.choose();
                tf = p2.place(value2[0], value2[1], value2[2], "BATTLESHIP");
                while(!tf)
                {
                    value2 = hal2.choose();
                    tf = p2.place(value2[0], value2[1], value2[2], "BATTLESHIP");
                }
                value2 = hal2.choose();
                tf = p2.place(value2[0], value2[1], value2[2], "CARRIER");
                while(!tf)
                {
                    value2 = hal2.choose();
                    tf = p2.place(value2[0], value2[1], value2[2], "CARRIER");
                }
                value2 = hal2.choose();
                tf = p2.place(value2[0], value2[1], value2[2], "CRUISER");
                while(!tf)
                {
                    value2 = hal2.choose();
                    tf = p2.place(value2[0], value2[1], value2[2], "CRUISER");
                }
                tf = p2.place(value2[0], value2[1], value2[2], "SUBMARINE");
                while(!tf)
                {
                    value2 = hal2.choose();
                    tf = p2.place(value2[0], value2[1], value2[2], "SUBMARINE");
                }
                tf = p2.place(value2[0], value2[1], value2[2], "DESTROYER");
                while(!tf)
                {
                    value2 = hal2.choose();
                    tf = p2.place(value2[0], value2[1], value2[2], "DESTROYER");
                }
                System.out.println("PLAYER 2 Grid");
                p2.displayGrid(true);
        }


        int hits_p1 = 0;
        int hits_p2 = 0;

        boolean attempted = true;
        while(true)
        {
            switch(one){
                case 1:
                    attempted = true;
                    p1.displayGrid(false);
                    while(attempted) {
                        attempted = false;
                        System.out.println("PLAYER 1:");
                        System.out.println("Take a Shot!");
                        Scanner in = new Scanner(System.in);
                        String in1 = in.nextLine();
                        String in2[] = in1.split(",");
                        if (p1.hasBeenAttempted(Integer.parseInt(in2[0]), Integer.parseInt(in2[1])) == true) {
                            attempted = true;
                        }
                        if(!attempted) {
                            int ret = p2.shoot(Integer.parseInt(in2[0]), Integer.parseInt(in2[1]));

                            if (ret == -1) {
                                System.out.println("Miss!");
                                p1.updateHits(Integer.parseInt(in2[0]), Integer.parseInt(in2[1]), -3);
                            } else if (ret == 0) {
                                System.out.println("Hit!");
                                p1.updateHits(Integer.parseInt(in2[0]), Integer.parseInt(in2[1]), -2);
                                hits_p1++;
                            } else if (ret == 1) {
                                p1.updateHits(Integer.parseInt(in2[0]), Integer.parseInt(in2[1]), -2);
                                hits_p1++;
                            }
                        }
                    }
                    if(hits_p1 >= 17 || hits_p2 >= 17)
                    {
                        break;
                    }
                case 2:
                    System.out.println();
                    System.out.println("PLAYER 1:");
                    attempted = true;
                    p1.displayGrid(false);
                    while(attempted){
                        attempted = false;
                        HAL hal = new HAL(10,10);
                        int choice[];
                        choice = hal.choose();
                        if (p1.hasBeenAttempted(choice[0], choice[1]) == true) {
                            attempted = true;
                        }
                        if(!attempted) {
                            int ret = p2.shoot(choice[0], choice[1]);

                            if (ret == -1) {
                                System.out.println("Miss!");
                                p1.updateHits(choice[0], choice[1], -3);
                            } else if (ret == 0) {
                                System.out.println("Hit!");
                                p1.updateHits(choice[0], choice[1], -2);
                                hits_p1++;
                            } else if (ret == 1) {
                                p1.updateHits(choice[0], choice[1], -2);
                                hits_p1++;
                            }
                        }
                    }
                    if(hits_p1 >= 17 || hits_p2 >= 17)
                    {
                        break;
                    }
                    }
            if(hits_p1 >= 17 || hits_p2 >= 17)
            {
                break;
            }

                    switch(two){
                        case 1:
                            p2.displayGrid(false);
                            attempted = true;
                            while(attempted) {
                                attempted = false;
                                System.out.println("PLAYER 2:");
                                System.out.println("Take a Shot!");
                                Scanner in3 = new Scanner(System.in);
                                String in4 = in3.nextLine();
                                String in5[] = in4.split(",");
                                if (p2.hasBeenAttempted(Integer.parseInt(in5[0]), Integer.parseInt(in5[1])) == true) {
                                    attempted = true;
                                }
                                if(!attempted) {
                                    int ret1 = p1.shoot(Integer.parseInt(in5[0]), Integer.parseInt(in5[1]));
                                    System.out.println(ret1);
                                    if (ret1 == -1) {
                                        System.out.println("Miss!");
                                        p2.updateHits(Integer.parseInt(in5[0]), Integer.parseInt(in5[1]), -3);
                                    } else if (ret1 == 0) {
                                        System.out.println("Hit!");
                                        p2.updateHits(Integer.parseInt(in5[0]), Integer.parseInt(in5[1]), -2);
                                        hits_p2++;
                                    } else if (ret1 == 1) {
                                        p2.updateHits(Integer.parseInt(in5[0]), Integer.parseInt(in5[1]), -2);
                                        hits_p2++;
                                    }
                                }
                            }
                            if(hits_p1 >= 17 || hits_p2 >= 17)
                            {
                                break;
                            }
                        case 2:
                            System.out.println();
                            System.out.println("PLAYER 2:");
                            attempted = true;
                            p2.displayGrid(false);
                            while(attempted){
                                attempted = false;
                                HAL hal = new HAL(10,10);
                                int choice[];
                                choice = hal.choose();
                                if (p2.hasBeenAttempted(choice[0],choice[1]) == true) {
                                    attempted = true;
                                }
                                if(!attempted) {
                                    int ret = p1.shoot(choice[0], choice[1]);

                                    if (ret == -1) {
                                        System.out.println("Miss!");
                                        p2.updateHits(choice[0], choice[1], -3);
                                    } else if (ret == 0) {
                                        System.out.println("Hit!");
                                        p2.updateHits(choice[0], choice[1], -2);
                                        hits_p2++;
                                    } else if (ret == 1) {
                                        p2.updateHits(choice[0], choice[1], -2);
                                        hits_p2++;
                                    }
                                }
                            }
                            if(hits_p1 >= 17 || hits_p2 >= 17)
                            {
                                break;
                            }
                    }
            if(hits_p1 >= 17 || hits_p2 >= 17)
            {
                break;
            }

        }
        if(hits_p1 > hits_p2)
        {
            System.out.println("Player 1 Wins!");
        }
        else
        {
            System.out.println("Player 2 Wins!");
        }

    }
}

