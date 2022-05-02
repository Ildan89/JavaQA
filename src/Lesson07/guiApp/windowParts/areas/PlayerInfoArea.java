package Lesson07.guiApp.windowParts.areas;

import Lesson07.guiApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 28.04.2022
 */

public class PlayerInfoArea extends JPanel {
    private JLabel hp;
    private JLabel exp;
    private JLabel coins;
    private InfoPanel infoPanel;

    public PlayerInfoArea (InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
        hp = new JLabel("HP: ?");
        exp = new JLabel("EXP: ?");
        coins = new JLabel("COINS: ?");

        setLayout(new GridLayout(4, 1));

        add(new JLabel("= PLAYER INFO ="));
        add(hp);
        add(exp);
        add(coins);
    }

    public void setCoins(int coins) {
        this.coins.setText("COINS: " + Integer.toString(coins));
    }

    public void setHp(int hp) {
        this.coins.setText("HP: " + Integer.toString(hp));
    }

    public void setExp(int exp) {
        this.coins.setText("EXP: " + Integer.toString(exp));
    }

}
