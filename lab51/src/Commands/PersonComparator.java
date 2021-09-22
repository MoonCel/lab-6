package Commands;

import Elements.Person;

import java.util.Comparator;

public  class PersonComparator implements Comparator<Person> {
    public int compare(Person s1, Person s2) {
        if (s1.hashCode() > s2.hashCode())
            return 1;
        else if (s1.hashCode() < s2.hashCode())
            return -1;
        return 0;
    }
}
