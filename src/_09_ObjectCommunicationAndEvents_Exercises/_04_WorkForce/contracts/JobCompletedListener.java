package _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.contracts;

import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.events.JobCompletedEvent;

public interface JobCompletedListener {

    void handleJobCompleted(JobCompletedEvent event);
}
