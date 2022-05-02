package Lesson07.guiApp.windowParts;


import Lesson07.guiApp.MainWindow;
import Lesson07.guiApp.windowParts.areas.GameControlArea;
import Lesson07.guiApp.windowParts.areas.GameInfoArea;
import Lesson07.guiApp.windowParts.areas.PlayerControlArea;
import Lesson07.guiApp.windowParts.areas.PlayerInfoArea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 28.04.2022
 */

public class InfoPanel extends JPanel {

    private GameControlArea gameControlArea;
    private GameInfoArea gameInfoArea;
    private PlayerInfoArea playerInfoArea;
    private PlayerControlArea playerControlArea;

    private JTextArea logs;
    private JScrollPane scrollBox;

    private MainWindow mainWindow;

    public InfoPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setLayout(new GridLayout(5, 1));

        gameControlArea = new GameControlArea(this);
        gameInfoArea = new GameInfoArea(this);

        createLogArea();

        add(gameControlArea);
        add(gameInfoArea);
        add(scrollBox);
    }

    private void createLogArea() {
        logs = new JTextArea();
        logs.setLineWrap(true);
        scrollBox = new JScrollPane(logs);
    }
}
