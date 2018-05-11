package service;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.services.Service;
import org.apache.ignite.services.ServiceContext;
import processor.CounterEntryProcessor;

/**
 * Created by Lakhno Anton
 * at 23:50 11.05.2018.
 *
 * @author Lakhno Anton
 */
public class CounterServiceImpl implements Service, CounterService {

	private static final String CACHE_KEY = "counter";

	private IgniteCache<String, Integer> cache;

	private String serviceName;

	public CounterServiceImpl(Ignite ignite) {
		this.cache = ignite.cache(CACHE_NAME);
	}

	//region Ignite's 'Service' methods implementation.
	@Override
	public void init(ServiceContext ctx) throws Exception {
		this.serviceName = ctx.name();
		System.out.println("Service was initialized: " + ctx.name());
	}
	@Override
	public void cancel(ServiceContext ctx) {
		System.out.println("Service was canceled: " + ctx.name());
	}

	@Override
	public void execute(ServiceContext ctx) throws Exception {
		System.out.println("Executing distributed service: " + ctx.name());
	}
	//endregion

	//region Counter service method implementation.
	@Override
	public int increment() {
		return cache.invoke(CACHE_KEY, new CounterEntryProcessor());
	}

	@Override
	public int get() {
		return cache.get(CACHE_KEY);
	}
	//endregion

}
