import Objects.Nation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePlanViewer {

    private Nation nation;
    private MyFrame frame;

    public GamePlanViewer(Nation nation) throws IOException {
        this.nation = nation;
        frame = new MyFrame("Kingdom of Xerox",nation);
    }

    public void show(){
        //frame.setSize(new Dimension(1920, 1080));
        frame.pack();
        //frame.setResizable(false);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.addKeyListener(frame);

    }

    public void tick(){
        //updateFrame();
        System.out.print("tick");
        updateFrame();

    }


    public void updateFrame(){
        frame.update(frame.getGraphics());
    }

    public void addComponentToFrame(GamePlanComponent component){
        frame.add(component, BorderLayout.CENTER);
    }

    public MyFrame getFrame() {
        return frame;
    }
}
