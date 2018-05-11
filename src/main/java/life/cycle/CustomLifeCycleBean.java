package life.cycle;

import org.apache.ignite.IgniteException;
import org.apache.ignite.lifecycle.LifecycleBean;
import org.apache.ignite.lifecycle.LifecycleEventType;

/**
 * Bean specifies what operations need to being done at each stage of ignite lifecycle.
 *
 * Created by Lakhno Anton
 * at 22:57 11.05.2018.
 *
 * @author Lakhno Anton
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CustomLifeCycleBean implements LifecycleBean {

	@Override
	public void onLifecycleEvent(LifecycleEventType lifecycleEventType) throws IgniteException {

		// Switching between lifecycle events.
		switch (lifecycleEventType) {
			case BEFORE_NODE_START: break;
			case AFTER_NODE_START:	break;
			case BEFORE_NODE_STOP:	break;
			case AFTER_NODE_STOP:	break;
			default: break;
		}
	}
}
