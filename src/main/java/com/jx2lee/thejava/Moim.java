package com.jx2lee.thejava;

public class Moim {

    public int maxNumberOfAttendees;
    public int numberOfEnrollment;

    public boolean isEnrollmentFull() {
        if (maxNumberOfAttendees == 0) {
            return false;
        }

        if (numberOfEnrollment < maxNumberOfAttendees) {
            return false;
        }

        return true;
    }
}
