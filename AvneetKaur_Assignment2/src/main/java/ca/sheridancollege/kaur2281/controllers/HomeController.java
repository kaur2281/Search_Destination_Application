package ca.sheridancollege.kaur2281.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.kaur2281.beans.Destination;
import ca.sheridancollege.kaur2281.repository.DestinationList;
import ca.sheridancollege.kaur2281.repository.DestinationListImpl;

@Controller
public class HomeController {

	DestinationList list;

	@Autowired
	public HomeController(DestinationList list) {
		this.list = list;
	}

	@GetMapping("/")
	public String goHome() {

		return "index";
	}

	@GetMapping("/addDestination")
	public String goHome(Model model) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", list.getDestinationList());
		return "addDestination";
	}

	@GetMapping("/listDestinations")
	public String goHome1(Model model) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", list.getDestinationList());
		return "listDestinations";
	}

	@GetMapping("/listDestination")
	public String goHome3(Model model) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", list.getDestinationList());
		return "listDestination";
	}

	@GetMapping("/searchDestination")
	public String goHome2(Model model) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", list.getDestinationList());
		return "searchDestination";
	}

	@PostMapping("/listDestination")
	public String searchDestination(Model model, @ModelAttribute Destination destination) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", list.searchDestinations(destination.getYear()));
		return "listDestination";
	}

	@PostMapping("/addDestination")
	public String addDestination(Model model, @ModelAttribute Destination destination) {
		boolean allvalid = true;
		String message = "";
		if(destination.getDestinationName()!=null && destination.getDestinationName().isEmpty()) {
			message += "<br>Please Enter Some Value in Destination Name<br>";
			allvalid = false;
		}
		if(destination.getWentWith()!=null && destination.getWentWith().isEmpty()) {
			message += "<br>Please Enter Some Value in Went With<br>";
			allvalid = false;
		}
		if(destination.getDurationOfStay() == 0) {
			message += "<br>Duration of Stay must be greater than 0<br>";
			allvalid = false;
		}
		if(destination.getYear() == 0) {
			message += "<br>Year must be greater than 0<br>";
			allvalid = false;
		}
		if (allvalid) {
			list.saveDestination(destination);
			message = "<div class=\"alert alert-success  alert-dismissible\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>Destination Details are saved successfully</div>";
		} else {
			message = "<div class=\"alert alert-danger alert-dismissible\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>" + message + "</div>";
		}
		model.addAttribute("error",message);
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", list.getDestinationList());

		return "addDestination";
	}

	@PostMapping("/listDestinations")
	public String name(Model model, @ModelAttribute Destination destination) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", list.getDestinationList());
		return "listDestinations";
	}
}
