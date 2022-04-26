package Lesson04;

import java.util.Random;
import java.util.Scanner;

public class Homework04 {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static String playerName = "Lancelot";
    public static char player = '@';
    public static int playerHealth = 100;
    public static int playerCoins = 0;
    public static int playerExp = 0;
    public static int playerPosX;
    public static int playerPosY;
    public static final int playerMoveUp = 8;
    public static final int playerMoveDown = 2;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;

    public static char enemy = 'E';
    public static int enemyHealth;
    public static int enemyPower;
    public static int enemiesCount;
    public static int enemyValueMin = 20;
    public static int enemyValueMax = 50;

    public static int mapWidth;
    public static int mapHeight;
    public static int mapSizeMin = 2;
    public static int mapSizeMax = 10;
    public static char[][] map;
    public static char emptyCell = '_';

    public static char coinCell = 'o';
    public static int coinsCount;

    public static int levelsCount = 0;

    public static void main(String[] args) {

        createNewLevel();

        while (true) {

            playerMoveAction();

            if (!isPlayerAlive()) {
                System.out.println(playerName + " is dead. Count coins = " + playerCoins);
                break;
            }

            showMap(true);

            if (!isCoinsExist()) {
                System.out.println(playerName + " is win. Count coins = " + playerCoins);
                createNewLevel();
            }

        }
        showMap(false);
        System.out.println("Game over!");
    }

    public static void createNewLevel() {
        levelsCount++;
        System.out.println("======== LEVEL " + levelsCount +" ========");
        createMap();
        spawnPlayer();
        spawnEnemies();
        spawnCoins();
        showMap(false);
    }
    public static void createMap() {
        mapWidth = randomValue(mapSizeMin, mapSizeMax);
        mapHeight = randomValue(mapSizeMin, mapSizeMax);
        map = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
            }
        }
        System.out.println("Create map [" + mapWidth + "x" + mapHeight + "]");
    }

    public static void showMap(boolean isEnemiesHided) {
        System.out.println("========== MAP ==========");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                if(map[y][x] == enemy && isEnemiesHided) {
                    System.out.print(emptyCell + "|");
                } else {
                    System.out.print(map[y][x] + "|");
                }
            }
            System.out.println();
        }
        System.out.println("=========================");
    }

    public static void spawnPlayer() {
        playerPosX = randomValue(0, mapWidth - 1);
        playerPosY = randomValue(0, mapHeight - 1);
        map[playerPosY][playerPosX] = player;
        System.out.println(playerName + " has spawn in [" + playerPosY + ":" + playerPosX + "]");
    }

    public static void spawnEnemies() {
        enemyHealth = randomValue(enemyValueMin, enemyValueMax);
        enemyPower = randomValue(enemyValueMin, enemyValueMax);

        enemiesCount = (mapWidth + mapHeight) / 2; //random math.formula

        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemiesCount; i++) {

            do {
                enemyPosX = random.nextInt(mapWidth);
                enemyPosY = random.nextInt(mapHeight);
            } while (!isCellClear(enemyPosX, enemyPosY));
            map[enemyPosY][enemyPosX] = enemy;
        }
        System.out.println(("Enemy count: " + enemiesCount + ". HP=" + enemyHealth + ", PWR=" + enemyPower));
    }

    public static void spawnCoins() {
        //К этому моменту игрок и враги уже распределены, поэтому исходим из количества оставшихся полей.
        coinsCount = (mapWidth * mapHeight - 1 - enemiesCount) / 4;
        //Не очень правильно конечно, т.к ничто не предостережет нас от вызова этого метода перед spawnEnemies();
        //Если по формуле получилось 0 монеток, то добавим 1, чтоб была хотя бы одна монетка
        coinsCount += coinsCount == 0 ? 1 : 0;

        int coinPosX;
        int coinPosY;

        for (int i = 1; i <= coinsCount; i++) {

            do {
                coinPosX = random.nextInt(mapWidth);
                coinPosY = random.nextInt(mapHeight);
            } while (!isCellClear(coinPosX, coinPosY));
            map[coinPosY][coinPosX] = coinCell;
        }
        System.out.println("Coins count: " + coinsCount);
    }

    public static void playerMoveAction() {
        int playerLastPositionX = playerPosX;
        int playerLastPositionY = playerPosY;

        int playerMoveCode;

        do {
            System.out.print("Enter destination: (UP-" + playerMoveUp + "|DOWN-" + playerMoveDown +
                    "|LEFT-" + playerMoveLeft + "|RIGHT-" + playerMoveRight + ") > ");
            playerMoveCode = scanner.nextInt();

            switch (playerMoveCode) {
                case playerMoveUp:
                    playerPosY -= 1;
                    break;
                case playerMoveDown:
                    playerPosY += 1;
                    break;
                case playerMoveLeft:
                    playerPosX -= 1;
                    break;
                case playerMoveRight:
                    playerPosX += 1;
                    break;
            }

        } while (!isValidPlayerMove(playerLastPositionX, playerLastPositionY, playerPosX, playerPosY));

        playerNextCellAction();

        map[playerPosY][playerPosX] = player;
        map[playerLastPositionY][playerLastPositionX] = emptyCell;

    }

    public static boolean isValidPlayerMove(int lastX, int lastY, int nextX, int nextY) {
        if (isCellValid(nextX, nextY)) {
            System.out.println(playerName + " has move to [" + nextY + ":" + nextX + "]");
            return true;
        } else {
            System.out.println(playerName + " move to [" + nextY + ":" + nextX + "] invalid");
            playerPosX = lastX;
            playerPosY = lastY;
            return false;
        }
    }

    public static void playerNextCellAction() {
        if (map[playerPosY][playerPosX] == enemy) {
            playerHealth -= enemyPower;
            enemiesCount--;
            playerExp += 250;
            System.out.println(playerName + " get damage " + enemyPower + ". " + playerName + " HP= " + playerHealth);
        }
        if (map[playerPosY][playerPosX] == coinCell) {
            int count = randomValue(100, 300);
            playerCoins += count;
            coinsCount--;
            System.out.println(playerName + " get " + count + " coins. " + playerName + " coins = " + playerCoins);
        }
    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isCellClear(int x, int y) {
        return map[y][x] == emptyCell;
    }

    public static boolean isCellValid(int x, int y) {
        return x >= 0 && x < mapWidth && y >= 0 && y < mapHeight;
    }

    public static boolean isPlayerAlive() {
        return playerHealth > 0;
    }

    public static boolean isCoinsExist() {
        return coinsCount > 0;
    }
}
