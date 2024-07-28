package com.rag_dsa.final_assignment.priority_queue_2;

import java.time.LocalTime;

class PatientArrivalData implements Comparable<PatientArrivalData> {
    int priorityLevel;
    LocalTime arrivalTime;
    String name="";

    public PatientArrivalData(int priorityLevel, LocalTime arrivalTime) {
        this.priorityLevel = priorityLevel;
        this.arrivalTime = arrivalTime;
    }

    public PatientArrivalData(String name,int priorityLevel, LocalTime arrivalTime) {
        this.priorityLevel = priorityLevel;
        this.arrivalTime = arrivalTime;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public int compareTo(PatientArrivalData o) {
        return Integer.compare(this.priorityLevel, o.priorityLevel);
    }

}