package Lesson07.guiApp.windowParts.areas;

import Lesson07.guiApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 28.04.2022
 */

public class GameInfoArea extends JPanel {

    private JLabel sizeMap;
    private JLabel levelGame;
    private JLabel countEnemies;

    private InfoPanel infoPanel;

    public GameInfoArea(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;

        setLayout(new GridLayout(4,1));

        sizeMap = new JLabel("Size map: ?x?");
        levelGame = new JLabel("Level: ?");
        countEnemies = new JLabel("Enemies: ?");

        add(new JLabel("= Game Info ="), SwingConstants.CENTER);
        add(sizeMap);
        add(levelGame);
        add(countEnemies);
    }

    public void setSizeMap(int w, int h) {
        this.sizeMap.setText("Size map: " + Integer.toString(w) + "x" + Integer.toString(h));
    }

    public void setLevel(int level) {
        this.levelGame.setText("Level: " + Integer.toString(level));
    }

    public void setEnemies(int enemies) {
        this.countEnemies.setText("EXP: " + Integer.toString(enemies));
    }
}
