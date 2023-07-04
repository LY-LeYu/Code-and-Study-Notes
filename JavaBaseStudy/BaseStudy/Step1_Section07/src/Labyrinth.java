public class Labyrinth {
    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入迷宫长度：");
        int ROW = scanner.nextInt();
        System.out.print("请输入迷宫宽度：");
        int COL = scanner.nextInt();*/
        int ROW = 8,COL = 7;
        int[][] map = new int[ROW][COL];
        game c = new game();
        c.initialMap(map);
        int START_ROW = 1;
        int START_COL = 1;
        c.findWay(map,START_ROW ,START_COL);
        c.printMap(map);
    }
}
class game {
    public void initialMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (j == 0 || j == map[i].length - 1 || i == 0 || i == map.length - 1) {
                    map[i][j] = 1;
                }
            }
        }
        map[3][1] = map[3][2] = map[2][2] = 1;
    }
    public void printMap(int[][] map) {
        for (int[] i : map) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }
    }
    public boolean findWay(int[][] map, int R, int C) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[R][C] == 0) {
                map[R][C] = 2;
                if (findWay(map,R+1,C)) {
                    return true;
                } else if (findWay(map,R,C+1)) {
                    return true;
                } else if (findWay(map,R,C-1)) {
                    return true;
                } else if (findWay(map,R-1,C)) {
                    return true;
                } else {
                    map[R][C] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }


}