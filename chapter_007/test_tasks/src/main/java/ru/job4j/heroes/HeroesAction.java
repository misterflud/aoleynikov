package ru.job4j.heroes;

import ru.job4j.manage.Location;

public interface HeroesAction {
	Location move(Location oldLocation, Location newLocation);
}
