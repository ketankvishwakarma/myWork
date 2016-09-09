package naturalordering;

import java.util.Set;
import java.util.TreeSet;



class Person implements Comparable<Person> {
	private Integer id;
	private String name;

	public Person(int id, String name) {
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

	@Override
	public int compareTo(Person person) {

		return this.getName().compareTo(person.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

public class NaturalOrgering {
	public static void main(String[] args) {
		
		Set<Person> persons = new TreeSet<Person>();

		persons.add(new Person(0, "Ketan"));
		persons.add(new Person(2, "Garima"));
		persons.add(new Person(1, "Naresh"));
		persons.add(new Person(3, "Falu"));
		persons.add(new Person(1, "Naresh"));
		
        System.out.println(persons);
		
		//Collections.sort(persons);
		System.out.println();
		System.out.println(persons);

	}
}
