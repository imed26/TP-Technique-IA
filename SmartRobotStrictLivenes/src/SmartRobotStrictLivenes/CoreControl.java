package SmartRobotStrictLivenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CoreControl {

    public static class Grid extends JPanel {
        private List<Point> fillCells;
        public Grid() {
            fillCells = new ArrayList<>(25);
        }

        @Override
        protected synchronized void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Point fillCell : fillCells) {
                int cellX = 50 + (fillCell.x * 50);
                int cellY = 50 + (fillCell.y * 50);
                g.fillRect(cellX, cellY, 50, 50);
                g.setColor(Color.BLACK);
            }
            g.drawRect(50, 50, 250, 250);
            for (int i = 50; i <= 300; i += 50) {
                g.drawLine(i, 50, i, 300);
            }
            for (int i = 50; i <= 300; i += 50) {
                g.drawLine(50, i, 300, i);
            }
        }
        public synchronized void fillCell(int x, int y) {
            fillCells.add(new Point(x, y));
            repaint();
        }

        public synchronized void removeCell(int x, int y) {
            fillCells.remove(new Point(x,y));
            repaint();
        }

        public synchronized void switchOnCell(int x, int y) {
            this.fillCell(x,y);
            //repaint();
        }

        public synchronized void switchOffCell(int x, int y) {
            fillCells.remove(new Point(x,y));
            repaint();
        }

        public synchronized void colorRoadMap(){
            JFrame window = new JFrame();
            window.setSize(720, 720);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(this);
            window.setVisible(true);
        }
    }
}
