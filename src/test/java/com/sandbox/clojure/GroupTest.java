package com.sandbox.clojure;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GroupTest {
	private static final Person JON = new Person("Jon", 28);
	private static final Person NICK = new Person("Nick", 31);
	private static final Person NAS = new Person("Nas", 42);

	private Group group = new Group();

	@Before public void
	populateGroup() {
		group.add(NAS);
		group.add(JON);
		group.add(NICK);
	}

	@Test public void
	findsYoungestPersonInGroup() {
		assertThat(group.findYoungest(), is(JON));
	}

	@Test public void
	findsOldestPersonInGroup() {
		assertThat(group.findOldest(), is(NAS));
	}
}