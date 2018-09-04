package _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models;

import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.contracts.JobCompletedListener;
import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.events.JobCompletedEvent;

import java.util.ArrayList;

public class ModifiedList<T> extends ArrayList<T> implements JobCompletedListener {

    @Override
    public void handleJobCompleted(JobCompletedEvent event) {
        this.remove(event.getSource());
    }
}
