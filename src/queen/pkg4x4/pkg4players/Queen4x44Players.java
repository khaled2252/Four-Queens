package queen.pkg4x4.pkg4players;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Khaled
 */
public class Queen4x44Players {

    final public static int boardSize = 8;
    final public static int playerNumber = 4;
    public static ArrayList<Point> solution = new ArrayList<Point>();
    public static ArrayList<ArrayList<Point>> solutions = new ArrayList();

    public static void main(String[] args) {
        for (int i = 0; i < boardSize / 2; i++) {
            for (int j = 0; j < boardSize / 2; j++) {
                if (solution.size() == 1) { //Check if returning from inner loop
                    solution.remove(solution.size() - 1);
                }
                Point currentPlayer = new Point(i, j);//place first player
                solution.add(currentPlayer);

                for (int k = 0; k < boardSize / 2; k++) {
                    for (int l = 0; l < boardSize / 2; l++) {
                        if (solution.size() == 2) { //Check if returning from inner loop
                            solution.remove(solution.size() - 1);
                        }
                        currentPlayer = new Point(k, l); //place second player

                        if (isGameOver(currentPlayer, solution.get(0))) {
                            if (k == (boardSize / 2 - 1) && l == (boardSize / 2 - 1)) { //Check if iterated board without finding solution
                                solution.remove(solution.size() - 1);
                            }
                            continue;
                        }

                        solution.add(currentPlayer);

                        for (int m = 0; m < boardSize / 2; m++) {
                            for (int n = 0; n < boardSize / 2; n++) {
                                if (solution.size() == 3) { //Check if returning from inner loop
                                    solution.remove(solution.size() - 1);
                                }
                                currentPlayer = new Point(m, n);//place third player

                                if (isGameOver(currentPlayer, solution.get(0)) || isGameOver(currentPlayer, solution.get(1))) {
                                    if (m == (boardSize / 2 - 1) && n == (boardSize / 2 - 1)) {//Check if iterated board without finding solution
                                        solution.remove(solution.size() - 1);
                                    }
                                    continue;
                                }

                                solution.add(currentPlayer);

                                for (int o = 0; o < boardSize / 2; o++) {
                                    for (int q = 0; q < boardSize / 2; q++) {

                                        currentPlayer = new Point(o, q);//place fourth player
                                        if (isGameOver(currentPlayer, solution.get(0)) || isGameOver(currentPlayer, solution.get(1)) || isGameOver(currentPlayer, solution.get(2))) {
                                            if (q == (boardSize / 2 - 1) && o == (boardSize / 2 - 1)) { //Check if iterated board without finding solution
                                                solution.remove(solution.size() - 1);
                                            }
                                            continue;
                                        }

                                        solution.add(currentPlayer);
                                        solutions.add((ArrayList<Point>) solution.clone());
                                        solution.remove(solution.size() - 1);

                                        if (q == (boardSize / 2 - 1) && o == (boardSize / 2 - 1)) { //Check if iterated board after finding solution
                                            solution.remove(solution.size() - 1);
                                        }

                                    }

                                }

                            }

                        }
                    }
                }

            }
        }
        for (int z = 0; z < solutions.size(); z++) {
            System.out.println(z+1+" : "+solutions.get(z));
        }

    }

    public static boolean isGameOver(Point p1, Point p2) {
        if (p1.x == p2.x || p1.y == p2.y || (Math.abs(p2.y - p1.y) == Math.abs(p2.x - p1.x))) //Check for intersetion in x,y axes or diagonals
        {
            return true;
        }
        return false;
    }

}
