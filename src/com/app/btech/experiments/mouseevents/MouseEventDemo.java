package com.app.btech.experiments.mouseevents;

import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame {
    private String eventMessage = "Perform a Mouse Action";

    public MouseEventDemo() {
        setTitle("Mouse Event Demo");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Add Mouse Listener using Adapter
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventMessage = "Mouse Clicked";
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                eventMessage = "Mouse Pressed";
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                eventMessage = "Mouse Released";
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                eventMessage = "Mouse Entered";
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                eventMessage = "Mouse Exited";
                repaint();
            }
        });

        // Add Mouse Motion Listener using Adapter
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                eventMessage = "Mouse Dragged";
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                eventMessage = "Mouse Moved";
                repaint();
            }
        });

        // Close window handler
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(eventMessage)) / 2;
        int y = getHeight() / 2;
        g.drawString(eventMessage, x, y);
    }

    public static void main(String[] args) {
        new MouseEventDemo();
    }
}

