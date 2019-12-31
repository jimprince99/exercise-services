package org.jimprince99.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.jimprince99.model.Activity;
import org.jimprince99.model.ActivitySearch;
import org.jimprince99.model.ActivitySearchType;
import org.junit.Test;

public class ActivityClientTest {
	
	@Test
	public void testSearchObject() {
		ActivitySearchClient client = new ActivitySearchClient();
		
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("biking");
		searchValues.add("running");
		
		ActivitySearch search = new ActivitySearch();
		search.setDescriptions(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(55);
		search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);
		
		List<Activity> activities = client.search(search);
		
		System.out.println(activities);
		
		assertNotNull(activities);
		
		
	}
	
	@Test
	public void testSearch() {
		ActivitySearchClient client = new ActivitySearchClient();
		
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("swimming");
		searchValues.add("running");
		
		String secondParam = "durationFrom";
		int durationFrom = 30;
		
		String thirdParam = "durationTo";
		int durationTo = 55;
		
		List<Activity> activities = client.search(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);
		System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	@Test
	public void testDelete() {
		ActivityClient client = new ActivityClient();
		client.delete("1234");
	}
	
	@Test
	public void testPut() {
		Activity activity = new Activity();
		
		activity.setId("3456");
		activity.setDescription("Bikram Yogo");
		activity.setDuration(90);
		
		ActivityClient client = new ActivityClient();
		activity = client.update(activity);
		assertNotNull(activity);
		
		
	}
	
	@Test
	public void testCreate() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = new Activity();
		activity.setDescription("swimming");
		activity.setDuration(90);
		
		activity = client.create(activity);
		assertNotNull(activity);
	}

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("1234");

		System.out.println(activity);
		assertNotNull(activity);
	}

	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		assertNotNull(activities);

	}

	@Test(expected = RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		client.get("123");
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetWithNotFound() {
		ActivityClient client = new ActivityClient();
		client.get("7777");
	}
	

}
