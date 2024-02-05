import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */

public class CA3_Question9
{
    enum DIRECTION {NORTH, SOUTH,EAST,WEST}

    //maze based on the one in the pdf file
    private static final int[][] maze = {
    {1,1,1,1,1,1,1,1},
    {1,0,0,0,0,0,0,1},
    {1,1,1,1,0,1,1,1},
    {9,0,0,0,0,0,0,1},
    {1,1,1,1,0,1,1,1},
    {1,0,0,0,0,1,1,1},
    {1,1,1,1,0,1,1,1},
    {1,1,1,1,1,1,1,1}};

    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }
    public static void solve(int x, int y)
    {
        Stack<List<Integer>> stack = new Stack<>(); //a stack for possible paths
        List<Integer> path = new ArrayList<>(); //list for current path
        //add the starting position
        path.add(x);
        path.add(y);
        //push the path onto the stack
        stack.push(path);

        //runs as long as there is any path in the stack
        while(!stack.isEmpty())
        {
            path = stack.pop(); //pop the current path from the stack
            // get current coordinates
            int curX = path.get(path.size() - 2); //size -> 2, therefore X is at the position 0
            int curY = path.get(path.size() - 1); //size -> 2, therefore Y is at the position 1

            //check if the current position is the exit
            if (maze[curX][curY] == 9)
            {
                System.out.println("Path found!");
                return;
            }

            maze[curX][curY] = 2; //marks current position as visited

            for(DIRECTION dir : DIRECTION.values()) //loop through all directions
            {
                int nextX = curX; //assign starting position before updates
                int nextY = curY; //assign starting position before updates

                //update coordinates based on the direction
                switch (dir)
                {
                    case NORTH:
                        nextX--; //cell up
                        break;
                    case SOUTH:
                        nextX++; //cell down
                        break;
                    case EAST:
                        nextY++; //cell to the right
                        break;
                    case WEST:
                        nextY--; //cell to the left
                        break;
                }

                //check if the next position is valid:
                //firstly it checks if the position even is in the array (maze);
                //the array's length = maze.length -> therefore number assigned to each part of the new position must be between 0 and the array's length
                //then it checks whether the value in the cell is either 0 or 9, as if it's 1, there is a dead end
                if(nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && (maze[nextX][nextY] == 0 || maze[nextX][nextY] == 9))
                {
                    List<Integer> newPath = new ArrayList<>(); //create new path with next coordinates
                    newPath.add(nextX); //adds new coordinates
                    newPath.add(nextY); //adds new coordinates
                    stack.push(newPath); //push new path onto the stack
                }
            }
            System.out.println("Coordinates: " + curX + ", " + curY); //display coordinates after every time that the loop runs to check if the program is working correctly
        }
        //if no path is found:
        System.out.println("No path found!");
    }

    public static void main(String[] args)
    {
        System.out.println("Maze: ");
        System.out.println();
        display(maze);
        System.out.println();
        System.out.println("Solving maze: ");
        solve(3,4); //solves the maze starting in the point (3,4)

    }
}
