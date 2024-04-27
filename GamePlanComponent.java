import Objects.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GamePlanComponent extends JPanel {
     private final Nation nation;
     Random random;

     public GamePlanComponent(Nation nation) {
          this.nation = nation;
          this.setPreferredSize(new Dimension(1920, 1080));
          this.setFocusable(true);
          random = new Random();
     }

     public void mapChanged() {
          repaint();
     }

     @Override
     protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          final Graphics2D g2d = (Graphics2D) g;
          this.drawBackground(g2d,nation);
          //this.drawTrees(g2d,nation);
          //this.drawCities(g2d,nation);

     }

     public void drawBackground(final Graphics g2d,Nation nation){
          g2d.drawImage(nation.getBackgroundImage(),0,0,null);
     }

     public void drawTrees(final Graphics g2d,Nation nation){
          int x = 50;
          int y = 50;
          for (int i = 0; i < 100; i++) {
               x = 50 + random.nextInt(2000);
               y = 50 + random.nextInt(1000);
               g2d.drawImage(nation.getTreeImage(),x,y,null);
               }
          }

     public void drawCities(final Graphics g2d,Nation nation){

          for(Ruler ruler : nation.getRulers()){
               for (City city: ruler.getCities()) {
                    g2d.drawImage(nation.getCityImage(),city.getPosition().x,city.getPosition().y,50,50,null);
               }
          }

     }
}

