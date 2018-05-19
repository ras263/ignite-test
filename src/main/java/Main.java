import exception.IgniteServerException;
import com.lakhno.ignite.life.cycle.CustomLifeCycleBean;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteServices;
import org.apache.ignite.Ignition;
import org.apache.ignite.cluster.ClusterGroup;
import org.apache.ignite.configuration.IgniteConfiguration;
import com.lakhno.ignite.service.CounterService;
import com.lakhno.ignite.service.CounterServiceImpl;

/**
 * Main application class.
 *
 * Representing by itself the server ignite node.
 *
 * Created by Lakhno Anton
 * at 22:55 11.05.2018.
 *
 * @author Lakhno Anton
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Main {

	public static final String SERVICE_NAME = "counterService";

	public static void main(String[] args) {
		IgniteConfiguration config = new IgniteConfiguration();
		config.setLifecycleBeans(new CustomLifeCycleBean());
		config.setPeerClassLoadingEnabled(true);

		// Setting up the client mode.
		// This setting requires already started server node.
		// Also a client node need to be configured for server nodes.
		Ignition.setClientMode(true);

		try (Ignite ignite = Ignition.start(config)) {

			ignite.getOrCreateCache("counter");

			/*// Deploying a single instance of the Service
			// in the whole cluster.
			ignite.services().deployClusterSingleton("CounterService",
					new CounterServiceImpl(ignite));*/

			deployService(ignite);

			// Requesting current weather for London.
			CounterService service = getProxy(ignite);

			System.out.println(service.increment());
			System.out.println(service.increment());
			System.out.println(service.increment());
			System.out.println(service.increment());
			System.out.println(service.increment());
			System.out.println(service.increment());

			System.out.println("Result value is " + service.get());
		} catch (IgniteServerException ise) {
			System.out.println("Unexpected error");
			ise.printStackTrace();
		}
	}

	/**
	 * Implementation copied from oficial ignite documentation.
	 * @param ignite Ignite object.
	 */
	private static void deployService(Ignite ignite) {
		// Cluster group which includes all caching nodes.
		ClusterGroup cacheGrp = ignite.cluster().forCacheNodes("counter");

		// Get an instance of IgniteServices for the cluster group.
		IgniteServices svcs = ignite.services(cacheGrp);

		// Deploy per-node singleton. An instance of the com.lakhno.ignite.service
		// will be deployed on every node within the cluster group.
		svcs.deployNodeSingleton(SERVICE_NAME, new CounterServiceImpl(ignite));
	}

	/**
	 * This solution is also copied from official documentation.
	 * @param ignite Ignite object.
	 * @return Proxy object of the counter.
	 */
	private static CounterService getProxy(Ignite ignite) {
		// Get com.lakhno.ignite.service proxy for the deployed com.lakhno.ignite.service.
		return ignite.services().
				serviceProxy(SERVICE_NAME, CounterService.class, /*not-sticky*/false);
	}

}
