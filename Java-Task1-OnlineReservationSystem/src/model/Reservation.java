package model;

public class Reservation {

    private int reservationId;
    private String pnrNumber;
    private String passengerName;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String journeyDate;
    private String fromStation;
    private String toStation;

    // Constructor
    public Reservation(
            int reservationId,
            String pnrNumber,
            String passengerName,
            String trainNumber,
            String trainName,
            String classType,
            String journeyDate,
            String fromStation,
            String toStation) {

        this.reservationId = reservationId;
        this.pnrNumber = pnrNumber;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    // Setters
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }
}