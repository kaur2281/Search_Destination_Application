package ca.sheridancollege.kaur2281.beans;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
	
	private String destinationName;
	private int durationOfStay;
	private String wentWith;
	private int year;
	private String comments;

}
