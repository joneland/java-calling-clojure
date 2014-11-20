package com.sandbox.clojure;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GroupTest {
	private Group group = new Group();

	@Before public void
	populateGroup() {
		group.add(new Person("Nas", 42));
		group.add(new Person("Jon", 28));
		group.add(new Person("Nick", 31));
	}

	@Test public void
	findsYoungestPersonInGroup() {
		assertThat(group.findYoungest(), is("Jon"));
	}

	@Test public void
	findsOldestPersonInGroup() {
		assertThat(group.findOldest(), is("Nas"));
	}
}