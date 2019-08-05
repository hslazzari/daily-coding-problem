package dayEightFourIslands;

import java.util.HashMap;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        int[][] world = {{1, 0, 0, 0, 0},
                         {0, 0, 1, 1, 0},
                         {0, 1, 1, 0, 0},
                         {0, 0, 0, 0, 0},
                         {1, 1, 0, 0, 1},
                         {1, 1, 0, 0, 1}};

        System.out.println(numberOfIslands(world));
    }    

    public static int numberOfIslands(int[][] world) {
        int islands = 0;
        for(int i = 0; i < world.length; i++) {
            for(int j = 0; j < world[i].length; j++) {
                if(world[i][j] == 1) {
                    islands++;
                    world[i][j] = -1;
                }

                if(world[i][j] == -1) {
                    if(i+1 < world.length && world[i+1][j] == 1) {
                        world[i+1][j] = -1;
                    }
                    
                    if(i+1 < world.length && j > 0 && world[i+1][j-1] == 1) {
                        world[i+1][j-1] = -1;
                    }

                    if(i+1 < world.length && j+1 < world[i+1].length && world[i+1][j+1] == 1) {
                        world[i+1][j+1] = -1;
                    }

                    if(j+1 < world[i].length && world[i][j+1] == 1) {
                        world[i][j+1] = -1;
                    }
                }

                world[i][j] = 0;
            }
        }

        return islands;
    }
}
