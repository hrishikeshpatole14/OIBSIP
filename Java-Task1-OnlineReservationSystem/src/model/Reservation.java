package model;

public class Reservation {

    private int reservationId;
    private String passengerName;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String journeyDate;
    private String fromStation;
    private String toStation;

    public Reservation(int reservationId,
                       String passengerName,
                       String trainNumber,
                       String trainName,
                       String classType,
                       String journeyDate,
                       String fromStation,
                       String toStation) {

        this.reservationId = reservationId;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public int getReservationId() {
        return reservationId;
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
}