package Everdell.Events.SpecialEvent;

import Everdell.Events.Event;

public abstract class SpecialEvent extends Event {
    public SpecialEvent(String name, String requirement, String reward) {
        super(name, requirement, reward);
    }

}
