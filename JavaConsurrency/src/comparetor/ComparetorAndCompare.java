package comparetor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Person {
	private Integer id;
	private String name;
	
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String toString() {
		return "[ID : " + id + " Name : " + name + "]";
	}
}
public class ComparetorAndCompare {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person(0, "Ketan"));
		persons.add(new Person(2, "Garima"));
		persons.add(new Person(1, "Naresh"));
		persons.add(new Person(3, "Falu"));
		
		System.out.println(persons);
		
		Collections.sort(persons,new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});
		
		System.out.println(persons);
	}
}
