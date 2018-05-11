package processor;

import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.MutableEntry;

/**
 * Simple entry processor.
 *
 * Just for training, because of, I think, this solution won't being useful.
 *
 * Created by Lakhno Anton
 * at 0:04 12.05.2018.
 *
 * @author Lakhno Anton
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CounterEntryProcessor implements EntryProcessor<String, Integer, Integer> {

	@Override
	public Integer process(MutableEntry<String, Integer> entry, Object... arguments) throws EntryProcessorException {
		int newVal = entry.exists() ? entry.getValue() + 1 : 1;

		// Update cache.
		entry.setValue(newVal);

		return newVal;
	}

}
