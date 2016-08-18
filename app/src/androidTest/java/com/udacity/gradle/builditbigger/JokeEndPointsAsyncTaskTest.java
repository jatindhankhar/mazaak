package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jatin on 18/8/16.
 */
public class JokeEndPointsAsyncTaskTest extends AndroidTestCase {
    public void testJokeRetreival()
    {
        final CountDownLatch signal = new CountDownLatch(1);

        JokeEndPointsAsyncTask jokeEndPointsAsyncTask = (JokeEndPointsAsyncTask) new JokeEndPointsAsyncTask(new JokeEndPointsAsyncTask.AsyncResponse() {
            @Override
            public void processResponse(String output) {
                assertNotNull(output);
                assertNotSame(output,"");
                signal.countDown();
            }
        }).execute();

        try {
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("Operation timed out!");
        }
    }
}
