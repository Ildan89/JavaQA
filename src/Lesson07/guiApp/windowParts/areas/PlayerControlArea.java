package Lesson07.guiApp.windowParts.areas;

import Lesson07.guiApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 28.04.2022
 */

public class PlayerControlArea extends JPanel{
    private JButton buttonUp;
    private JButton buttonDown;
    private JButton buttonLeft;
    private JButton buttonRight;
    private InfoPanel infoPanel;

    public PlayerControlArea(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
        buttonRight = new JButton(">");
        buttonLeft = new JButton("<");
        buttonDown = new JButton("v");
        buttonUp = new JButton("^");

        setLayout(new GridLayout(1, 4));
        add(buttonUp);
        add(buttonDown);
        add(buttonLeft);
        add(buttonRight);

        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Вниз");
            }
        });

        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Вверх");
            }
        });

        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Влево");
            }
        });

        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Вправо");
            }
        });
    }
}
