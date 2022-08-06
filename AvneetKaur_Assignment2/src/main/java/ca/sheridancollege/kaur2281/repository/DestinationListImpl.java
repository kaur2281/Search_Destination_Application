package ca.sheridancollege.kaur2281.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.sheridancollege.kaur2281.beans.Destination;

@Repository
public class DestinationListImpl implements DestinationList {

	
	private CopyOnWriteArrayList<Destination> destinationList = new CopyOnWriteArrayList<Destination>();

	@Override
	public CopyOnWriteArrayList<Destination> getDestinationList() {
		// TODO Auto-generated method stub
		return destinationList;
	}

	@Override
	public void saveDestination(Destination destination) {
		destinationList.add(destination);		
	}

	@Override
	public CopyOnWriteArrayList<Destination> searchDestinations(int year) {
		if(year!=0) {
			CopyOnWriteArrayList<Destination> list = new CopyOnWriteArrayList<Destination>(); 
			for(Destination destination : destinationList) {
				if(destination.getYear() == year) {
					list.add(destination);
				}
			}
			return list;
		}else {
			return destinationList;
		}
	}

}
