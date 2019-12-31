package org.jimprince99.repository;

import java.util.ArrayList;
import java.util.List;

import org.jimprince99.model.Activity;
import org.jimprince99.model.ActivitySearch;
import org.jimprince99.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	@Override
	public List<Activity> findByConstraints(ActivitySearch search) {
		System.out.println(search.getSearchType());
		
		List<Activity> activities = new ArrayList<Activity>();

		Activity activity = new Activity();
		activity.setId("2345");
		activity.setDescription("swimming");
		activity.setDuration(55);

		activities.add(activity);

		return activities;
	}
	@Override
	public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
		// select * from activities where description in (?, ?, ?) and duration > ? and duration < ? 

		List<Activity> activities = new ArrayList<Activity>();

		Activity activity = new Activity();
		activity.setId("2345");
		activity.setDescription("swimming");
		activity.setDuration(55);

		activities.add(activity);

		return activities;
	}

	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();

		Activity activity1 = new Activity();
		activity1.setDescription("swimming");
		activity1.setDuration(55);
		activities.add(activity1);

		Activity activity2 = new Activity();
		activity2.setDescription("cycling");
		activity2.setDuration(120);
		activities.add(activity2);

		return activities;
	}

	@Override
	public Activity findAllActivity(String activityId) {

		if (activityId.equals("7777")) {
			return null;
		}

		Activity activity1 = new Activity();

		User user = new User();
		user.setId("5678");
		user.setName("jim");
		activity1.setUser(user);

		activity1.setId("1234");
		activity1.setDescription("swimming");
		activity1.setDuration(55);
		return activity1;
	}

	@Override
	public void create(Activity activity) {
		// Should issue an insert statement to our DB repository

	}

	@Override
	public Activity update(Activity activity) {
		// Search the database for that Id.
		// select * from Activity where id = ?
		// if rs.size == 0
		// insert into Activity table
		// else
		// update Activity table

		return activity;

	}

	@Override
	public void delete(String activityId) {
		// delete from activity table where id = ?

	}

}
