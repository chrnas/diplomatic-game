import Makers.KingdomOfXeroxMaker;
import Objects.*;

import java.io.IOException;

public class RunGame {

    public static void main(String[] args) throws IOException {

        String file ="Res/InitValues.txt";
        KingdomOfXeroxMaker maker = new KingdomOfXeroxMaker(file);
        Nation nation = maker.makeTestKingdomFromTextFile();
        GamePlanComponent component = new GamePlanComponent(nation);
        GamePlanViewer viewer = new GamePlanViewer(nation);
        for (Ruler ruler : nation.getRulers()) {
            ruler.increaseCurrent(1000);
            for (City city : ruler.getCities()) {
                if(city.getCityNr() == 1) {
                    viewer.getFrame().addStartingCityMenu (city, ruler);
                }
                viewer.getFrame().addCity(city.getPosition().x, city.getPosition().y);
            }
        }
        viewer.addComponentToFrame(component);

        viewer.show();

    }
}
