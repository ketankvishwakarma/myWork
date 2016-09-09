package hashandequles;

import java.util.HashMap;
import java.util.Map;

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;

	}

	public String toString() {
		return "[ID : " + id + " Name : " + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

public class MapOfObjects {

	public static void main(String[] args) {

		Person p1 = new Person(0, "ketan");
		Person p2 = new Person(0, "ketan");
		Person p3 = new Person(0, "falu");
		Person p4 = new Person(0, "ketan");
		
		Map<Person, Integer> map = new HashMap<Person, Integer>();
		map.put(p1, 1);
		map.put(p2, 2);
		map.put(p3, 3);
		map.put(p4, 4);
		
		for(Person p : map.keySet())
			System.out.println(p);
	}
	
}
