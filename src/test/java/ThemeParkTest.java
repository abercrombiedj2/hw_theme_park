import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.*;
import stalls.*;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

        private ThemePark themePark;
        private RollerCoaster rollerCoaster;
        private Playground playground;
        private Dodgems dodgems;
        private Park park;
        private CandyflossStall candyflossStall;
        private IceCreamStall iceCreamStall;
        private TobaccoStall tobaccoStall;
        private Visitor visitor;

        @Before
        public void setUp(){
            themePark = new ThemePark("Theme Park");
            visitor = new Visitor(33, 190, 100);
            rollerCoaster = new RollerCoaster("Big Dipper", 5);
            playground = new Playground("Play Pen", 2);
            dodgems = new Dodgems("Jammy Dodger", 4);
            park = new Park("Park In The Park", 1);
            candyflossStall = new CandyflossStall("Candy Crush", "Willy Wonka", ParkingSpot.A1, 3);
            iceCreamStall = new IceCreamStall("Ice Ice Baby", "Mr Whippy", ParkingSpot.A2, 4);
            tobaccoStall = new TobaccoStall("Vape Nation", "Ryan", ParkingSpot.A3, 1);
            themePark.addAttraction(rollerCoaster);
            themePark.addAttraction(playground);
            themePark.addAttraction(dodgems);
            themePark.addAttraction(park);
            themePark.addStall(candyflossStall);
            themePark.addStall(iceCreamStall);
            themePark.addStall(tobaccoStall);
            themePark.visit(visitor, rollerCoaster);
        }

        @Test
        public void canGetAllReviewed(){
            assertEquals(7, themePark.getAllReviewed().size());
        }

        @Test
        public void canVisitIncrementsCount(){
            assertEquals(1, rollerCoaster.getVisitCount());
        }

        @Test
        public void canVisitAddVisitedAttraction(){
            assertEquals(1, visitor.getVisitedAttractions().size());
        }

        @Test
        public void canReturnRating(){
            HashMap<String, Integer> allReviews = themePark.getRatings();
            int rollerCoasterRating = allReviews.get("Big Dipper");
            assertEquals(5, rollerCoasterRating);
        }
}
