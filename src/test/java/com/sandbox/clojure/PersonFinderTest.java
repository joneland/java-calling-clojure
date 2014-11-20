package com.sandbox.clojure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonFinderTest {
	private PersonFinder personFinder = new PersonFinder();
	private List<Person> group;

	@Before public void
	populateGroup() {
		group = new ArrayList<Person>();
		group.add(new Person("Nas", 42));
		group.add(new Person("Jon", 28));
		group.add(new Person("Nick", 31));
	}

	@Test public void
	findsYoungestPersonInGroup() {
		assertThat(personFinder.findYoungestIn(group), is("Jon"));
	}

	@Test public void
	findsOldestPersonInGroup() {
		assertThat(personFinder.findOldestIn(group), is("Nas"));
	}
}