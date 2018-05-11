package service;

import exception.IgniteServerException;

/**
 * Created by Lakhno Anton
 * at 23:47 11.05.2018.
 *
 * @author Lakhno Anton
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface CounterService {

	String CACHE_NAME = "counter";

	int increment() throws IgniteServerException;
	int get() throws IgniteServerException;

}
