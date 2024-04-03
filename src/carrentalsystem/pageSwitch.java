/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.awt.Component;

public class pageSwitch {

    public static void switchPage(Component parentComponent, Component destination) {
        int x = destination.getLocation().x;
        int y = destination.getLocation().y;

        int xOffset = parentComponent.getLocation().x - x;
        int yOffset = parentComponent.getLocation().y - y;
        x += xOffset;
        y += yOffset;

        destination.setLocation(x, y);
        destination.setVisible(true);

        if (parentComponent instanceof java.awt.Window) {
            ((java.awt.Window) parentComponent).dispose();
        }
    }

}