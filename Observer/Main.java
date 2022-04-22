package Observer;

import java.util.HashSet;

interface IObservable {
    public void add(IObserver observer);
    public void remove(IObserver observer);
    public void broadcast();
}

interface IObserver {
    public void update();
}

/**
 * One to many Relationship
 * One Observable has one or many Observers
 */
class WeatherStation implements IObservable {
    private final HashSet<IObserver> subscribers = new HashSet<>();
    private int state;

    public WeatherStation(int initialState) {
        this.state = initialState;
    }

    @Override
    public void add(IObserver observer) {
        subscribers.add(observer);
        
    }

    @Override
    public void remove(IObserver observer) {
        subscribers.remove(observer);
        
    }

    @Override
    public void broadcast() {
        for(IObserver observer: subscribers) {
            observer.update();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int newState) {
        state = newState;
        broadcast();
    }

}

class PhoneApp implements IObserver {
    final private WeatherStation station;

    public PhoneApp(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void update() {
        System.out.println("Phone App " + this.station.getState());
    }

}

public class Main {

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation(0);

        //Some subscribers
        PhoneApp phoneApp1 = new PhoneApp(station);
        PhoneApp phoneApp2 = new PhoneApp(station);
        PhoneApp phoneApp3 = new PhoneApp(station);

        //one update 
        //This can also be a network socket update
        station.setState(2);

        //Susbcribing to station
        station.add(phoneApp1);


        station.setState(3);

        //Susbcribing to station
        station.add(phoneApp2);
        station.add(phoneApp3);
        station.remove(phoneApp1);

        station.setState(5);
            
    }
    

}
