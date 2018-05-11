import exception.IgniteServerException;
import life.cycle.CustomLifeCycleBean;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import service.CounterService;
import service.CounterServiceImpl;

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

	public static void main(String[] args) {
		IgniteConfiguration config = new IgniteConfiguration();
		config.setLifecycleBeans(new CustomLifeCycleBean());

		try (Ignite ignite = Ignition.start(config)) {

			ignite.createCache("counter");

			// Deploying a single instance of the Service
			// in the whole cluster.
			ignite.services().deployClusterSingleton("CounterService",
					new CounterServiceImpl(ignite));

			// Requesting current weather for London.
			CounterService service = ignite.services().service("CounterService");

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

}
