package com.timneville.Lists;

import com.google.common.collect.testing.ListTestSuiteBuilder;
import com.google.common.collect.testing.TestStringListGenerator;
import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.features.CollectionSize;
import com.google.common.collect.testing.features.ListFeature;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.List;
/**
@RunWith(Suite.class)

@Suite.SuiteClasses({
        GuavaTestSuite.GuavaTest.class
})

/**
 * Created by timneville on 17/7/17.
 */


/** Google Guava Testlib - testsuite that tests the behavior of Set, List and Map implementations.
 * Specify which features your collections support. Runs through hundreds of tests Google has written. */


/**
public class GuavaTestSuite {

    public static class GuavaTest {

        public static TestSuite myListTestSuite() {
            return ListTestSuiteBuilder.using(
                    // Creates collection, and provides data to be put into the collection.

                    // Then Abstract generator creates strings
                    // which will be put into the collection
                    new TestStringListGenerator() {
                        @Override
                        protected List<String> create(String[] elements) {
                            // Fill here your collection with the given elements
                            return new SinglyLinkedListImpList<>(elements);
                        }
                    })
                    // The name of the test suite
                    .named("My List Tests")
                    // Here we give a hit what features our collection supports
                    .withFeatures(ListFeature.GENERAL_PURPOSE,
                            CollectionFeature.ALLOWS_NULL_VALUES,
                            CollectionFeature.SERIALIZABLE,
                            CollectionFeature.FAILS_FAST_ON_CONCURRENT_MODIFICATION,
                            CollectionSize.ANY)
                    .createTestSuite();
        }
    }
}

*/
