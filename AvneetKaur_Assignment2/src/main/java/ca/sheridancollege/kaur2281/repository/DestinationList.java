package ca.sheridancollege.kaur2281.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import ca.sheridancollege.kaur2281.beans.Destination;

@Repository
public interface DestinationList {

	public CopyOnWriteArrayList<Destination> getDestinationList();

	public void saveDestination(Destination destination);

	public CopyOnWriteArrayList<Destination> searchDestinations(int year);

}
