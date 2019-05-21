package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by vanessa on 19/05/2019.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTaskAndroidTest implements OnTaskCompleted {

    @Test
    public void testJokeIsNotEmpty() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        EndpointsAsyncTask testTask = new EndpointsAsyncTask(this) {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (result != null){
                    assertTrue(result.length() > 0);
                    latch.countDown();
                }
            }
        };
        testTask.execute(null, null);
        latch.await();
    }

    @Override
    public void onTaskCompleted(String result) {
        //Nothing to do, just for implementation of OnTaskCompleted
    }
}


