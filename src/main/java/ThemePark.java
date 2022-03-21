import attractions.Attraction;
import behaviours.IReviewed;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private String name;
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private ArrayList<IReviewed> allReviewed;
    private HashMap<String, Integer> hashReviews;

    public ThemePark(String name) {
        this.name = name;
        this.attractions = new ArrayList<Attraction>();
        this.stalls = new ArrayList<Stall>();
        this.allReviewed = new ArrayList<IReviewed>();
        this.hashReviews = new HashMap<>();
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void setStalls(ArrayList<Stall> stalls) {
        this.stalls = stalls;
    }

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
        this.allReviewed.add(attraction);
        this.hashReviews.put(attraction.getName(), attraction.getRating());
    }

    public void addStall(Stall stall){
        this.stalls.add(stall);
        this.allReviewed.add(stall);
        this.hashReviews.put(stall.getName(), stall.getRating());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return allReviewed;
    }

    public void visit(people.Visitor visitor, Attraction attraction){
        int currentVisitCount = attraction.getVisitCount();
        int newVisitCount = currentVisitCount += 1;
        attraction.setVisitCount(newVisitCount);
        visitor.addAttraction(attraction);
    }

    public HashMap<String, Integer> getRatings(){
        return hashReviews;
    }
}


