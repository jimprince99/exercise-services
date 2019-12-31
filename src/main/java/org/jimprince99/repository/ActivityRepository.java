package org.jimprince99.repository;

import java.util.List;

import org.jimprince99.model.Activity;
import org.jimprince99.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findAllActivity(String activityId);

	void create(Activity activity);

	Activity update(Activity activity);

	void delete(String activityId);

	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Activity> findByConstraints(ActivitySearch search);

}