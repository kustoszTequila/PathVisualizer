package GUI;

import javax.swing.*;

public class SettingsFrame extends JFrame {
    private SettingsPanel settingsPanel;

    public SettingsFrame()
    {
        this.setTitle("Welcome to the pathfinder");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsPanel = new SettingsPanel(400,400);
        this.add(settingsPanel);
        this.setVisible(true);
    }
}
