package _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce;

import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models.employees.Employee;
import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models.employees.PartTimeEmployee;
import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models.employees.StandartEmployee;
import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models.ModifiedList;
import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models.jobs.Job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        ModifiedList<Job> jobs = new ModifiedList<>();
        Map<String, Employee> employeesByName = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] parameters = line.split(" ");
            switch (parameters[0]) {
                case "Job": {
                    Employee employeeForJob = employeesByName.get(parameters[3]);
                    Job newJob = new Job(parameters[1], Integer.parseInt(parameters[2]), employeeForJob);
                    newJob.addJobCompletedListener(jobs);
                    jobs.add(newJob);
                    break;
                }

                case "StandartEmployee": {
                    Employee newStandartEmployee = new StandartEmployee(parameters[1]);
                    employeesByName.put(parameters[1], newStandartEmployee);
                    break;
                }

                case "PartTimeEmployee": {
                    Employee newPartTimeEmployee = new PartTimeEmployee(parameters[1]);
                    employeesByName.put(parameters[1], newPartTimeEmployee);
                    break;
                }

                case "Pass": {
                    Job[] jobsToUpdate = new Job[jobs.size()];
                    jobs.toArray(jobsToUpdate);
                    for (Job job : jobsToUpdate) {
                        job.update();
                    }
                    break;
                }

                case "Status": {
                    for (Job job : jobs) {
                        System.out.println(job);
                    }
                }
            }
        }
    }
}
