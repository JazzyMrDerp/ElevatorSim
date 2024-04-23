package org.example.elevatorsimguifinal2;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class HelloController extends HelloApplication {


    @FXML
    private TextField inputFloors;
    @FXML
    private TextField iterationsNum;
    @FXML
    private Label ErrorLabel;
    @FXML
    private VBox Express1;
    @FXML
    private VBox Express2;
    @FXML
    private VBox Standard1;
    @FXML
    private VBox Standard2;
    @FXML
    private Button StartButton;
    @FXML
    private TextField PassengerInput;
    @FXML
    private Button runBTN;
    @FXML
    private AnchorPane ElevatorAnchor;
    @FXML
    private VBox TIMEvbox;




    // List of all of the rectangles
    protected List<Rectangle> Standard1List = new ArrayList<>();
    protected List<Rectangle> Standard2List = new ArrayList<>();
    protected List<Rectangle> Express1List = new ArrayList<>();
    protected List<Rectangle> Express2List = new ArrayList<>();

// List of all of the labels next to the rectangles
    protected List<Label> Standard1Label = new ArrayList<>();
    protected List<Label> Standard2Label = new ArrayList<>();
    protected List<Label> Express1Label = new ArrayList<>();
    protected List<Label> Express2Label = new ArrayList<>();

    Random randomPass = new Random();
    Random random = new Random();

    // List of the passengers
    List<Passenger> passengers = new ArrayList<>();


    Standard standardElevator = new Standard();
    Express expressElevator = new Express();


// Making the floors
    @FXML
    public void onButtonFloorsNun(ActionEvent actionEvent) {

//        Clear everything
        Standard1.getChildren().clear();
        Standard2.getChildren().clear();
        Express1.getChildren().clear();
        Express2.getChildren().clear();

//      Labeling the elevators
        Text elevator1 = new Text();
        elevator1.setText("Elevator 1");
        Standard1.getChildren().add(elevator1);

        Text elevator2 = new Text();
        elevator2.setText("Elevator 2");
        Standard2.getChildren().add(elevator2);

        Text elevator3 = new Text();
        elevator3.setText("Elevator 3");
        Express1.getChildren().add(elevator3);

        Text elevator4 = new Text();
        elevator4.setText("Elevator 4");
        Express2.getChildren().add(elevator4);


        // Read the value from the inputFloors TextField
        String FloorsText = inputFloors.getText();

        String PassengerText = PassengerInput.getText();


        try {
//        cast type to int
            int floors = Integer.parseInt((FloorsText));
            int NumPassenger = Integer.parseInt(PassengerText);

//          Making the floors
            int c = 0;
            while (c < floors) {
//              Numbering the elevators
                Text tStandard1 = new Text();
                tStandard1.setText(Integer.toString(c + 1));
                Text tStandard2 = new Text();
                tStandard2.setText(Integer.toString(c + 1));
                Text tExpress1 = new Text();
                tExpress1.setText(Integer.toString(c + 1));
                Text tExpress2 = new Text();
                tExpress2.setText(Integer.toString(c + 1));
// Label next to rectangle---------------------------------------------------------------------------------
                Label nextToStandard1 = new Label();

                Label nextToStandard2 = new Label();

                Label nextToExpress1 = new Label();

                Label nextToExpress2 = new Label();



//STANDARD -----------------------------------------------------------------------------------------------------------
                Rectangle r = new Rectangle();
                //r.setX(100);
                //r.setY(25);
                r.setWidth(25);
                r.setHeight(50);
                r.setArcWidth(10);
                r.setArcHeight(10);


                r.setFill(Color.PINK);
                nextToStandard1.setTranslateX(r.getWidth() + 5);
                nextToStandard1.setTranslateY(r.getHeight() - 100);
                tStandard1.setTranslateX((r.getWidth() / 2) - 5);
                tStandard1.setTranslateY(r.getHeight() - 85);


                Standard1.getChildren().addAll(r, tStandard1, nextToStandard1);
                Standard1List.add(r);
                Standard1Label.add(nextToStandard1);


//STANDARD2
                Rectangle r1 = new Rectangle();
                //r.setX(100);
                //r.setY(25);
                r1.setWidth(25);
                r1.setHeight(50);
                r1.setArcWidth(10);
                r1.setArcHeight(10);

                r1.setFill(Color.PINK);
                nextToStandard2.setTranslateX(r1.getWidth() + 5);
                nextToStandard2.setTranslateY(r1.getHeight() - 100);
                tStandard2.setTranslateX((r1.getWidth() / 2) - 5);
                tStandard2.setTranslateY(r1.getHeight() - 85);


                Standard2.getChildren().addAll(r1, tStandard2, nextToStandard2);
                Standard2List.add(r1);
                Standard2Label.add(nextToStandard2);


//EXPRESS -----------------------------------------------------------------------------------------------------------
                Rectangle r2 = new Rectangle();
                //r.setX(100);
                //r.setY(25);
                r2.setWidth(25);
                r2.setHeight(50);
                r2.setArcWidth(10);
                r2.setArcHeight(10);


                r2.setFill(Color.PINK);
                nextToExpress1.setTranslateX(r2.getWidth() + 5);
                nextToExpress1.setTranslateY(r2.getHeight() - 100);
                tExpress1.setTranslateX((r2.getWidth() / 2) - 5);
                tExpress1.setTranslateY(r2.getHeight() - 85);


                Express1.getChildren().addAll(r2, tExpress1, nextToExpress1);
                Express1List.add(r2);
                Express1Label.add(nextToExpress1);
//EXPRESS2
                Rectangle r3 = new Rectangle();
                //r.setX(100);
                //r.setY(25);
                r3.setWidth(25);
                r3.setHeight(50);
                r3.setArcWidth(10);
                r3.setArcHeight(10);


                r3.setFill(Color.PINK);
                nextToExpress2.setTranslateX(r3.getWidth() + 5);
                nextToExpress2.setTranslateY(r3.getHeight() - 100);
                tExpress2.setTranslateX((r3.getWidth() / 2) - 5);
                tExpress2.setTranslateY(r3.getHeight() - 85);


                Express2.getChildren().addAll(r3, tExpress2, nextToExpress2);
                Express2List.add(r3);
                Express2Label.add(nextToExpress2);


                c++;

            }


//Adding Passengers to list ----------------------------------------------------------------------------------------
            double PatientCall = 0.7;
            double StaffCall = 0.3;

//          Looping through the number of passengers and assigning a floor to each one
            for (int cPass = 0; cPass < NumPassenger; cPass++) {
                double randomNumber = randomPass.nextDouble();
                int randomFloorPatient1 = random.nextInt(floors);
                int randomFloorPatient2 = random.nextInt(floors);
                int randomFloorStaff1 = random.nextInt(floors);
                int randomFloorStaff2 = random.nextInt(floors);

//              If the random number is less that .30 then it will be a staff member, making the count 30% staff to 70% patients
                if (randomNumber < StaffCall) {
                    passengers.add(new Staff(randomFloorStaff1, randomFloorStaff2));
                } else {
                    passengers.add(new Paitent(randomFloorPatient1, randomFloorPatient2));
                }
            }




        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            System.err.println("Input is not a valid integer");
            ErrorLabel.setText("INPUT A INTEGER");
        }

    }

// ITERATIONS ------------------------------------------------------------------------------------------------------------
    long startTime;
    @FXML
    public void onRunBTN(ActionEvent actionEvent) {

        int counter = 0;

        String iterationsText = iterationsNum.getText();

        try {
            int iterationsCount = Integer.parseInt((iterationsText));

            startTime = System.currentTimeMillis();

            int x = 0;

//          While the number of iterations is not reached
            while(x < iterationsCount) {
                for (Passenger passenger : passengers) {
//                   Boolean for skipping the checks
                    boolean skip = false;

//                  Labels for the Vbox on the left side
                    Label express = new Label();
                    Label standard = new Label();

//                  if the iterations are reached before the number of passengers are reached it will break out of the loop
                    if (iterationsCount == counter) {
                        break;
                    }
//                  0=1, 1=2, 2=3, etc.
                    int finalCounter = counter + 1;

//                  Random number of either 1 or 2, so you either get Standard elevator 1 or 2, or express elevator 3 or 4
                    int One_or_Two = random.nextInt(2) + 1;

//          If passenger is staff and express is available
                    if (passenger.isStaff() && expressElevator.ablePickup()) {
                        skip = true;
                        int whatElevator = 0;
                        expressElevator.pickUp(passenger);

                        int pickupFloor = passenger.getPickupFloor();
//                      0=1, 1=2, 2=3, etc.
                        int finalpickupFloor = pickupFloor + 1;

//                          Either express1 or 2 (right or left)
                        switch (One_or_Two){
                            case 1:
                                Express1List.get(pickupFloor).setFill((Color.LIGHTBLUE));
                                Express1Label.get(pickupFloor).setText("Staff");
                                whatElevator = 1;
                                break;
                            case 2:
                                Express2List.get(pickupFloor).setFill((Color.LIGHTBLUE));
                                Express2Label.get(pickupFloor).setText("Staff");
                                whatElevator = 2;

                        }

                        express.setText("Express staff pickup at elevator: " + whatElevator + ", during iteration " + finalCounter + ", at floor " + finalpickupFloor);
                    }

//                  IF passenger is not staff and standard elevator is available
                    else if (passenger.isStaff() && standardElevator.ablePickup()) {
                        skip = true;
                        int whatElevator = 0;

                        standardElevator.pickUp(passenger);

                        int pickupFloor = passenger.getPickupFloor();
//                      0=1, 1=2, 2=3, etc.
                        int finalpickupFloor = pickupFloor + 1;

//                          Either express1 or 2 (right or left)
                        switch (One_or_Two){
                            case 1:
                                Standard1List.get(pickupFloor).setFill((Color.LIGHTBLUE));
                                Standard1Label.get(pickupFloor).setText("Staff");
                                whatElevator = 1;
                                break;

                            case 2:
                                Standard2List.get(pickupFloor).setFill((Color.LIGHTBLUE));
                                Standard2Label.get(pickupFloor).setText("Staff");
                                whatElevator = 2;
                                break;
                        }


                        standard.setText("Standard staff pickup at elevator: " + whatElevator + ", during iteration " + finalCounter + ", at floor " + finalpickupFloor);
                    }

//                      If passenger is not staff and express is available
                    else if (passenger.isStaff() || expressElevator.ablePickup()) {
                        skip = true;
                        int whatElevator = 0;
                        expressElevator.pickUp(passenger);

                        int pickupFloor = passenger.getPickupFloor();
//                      0=1, 1=2, 2=3, etc.
                        int finalpickupFloor = pickupFloor + 1;
//                          Either express1 or 2 (right or left)
                        switch (One_or_Two){
                            case 1:
                                Express1List.get(pickupFloor).setFill((Color.RED));
                                Express1Label.get(pickupFloor).setText("Patient");
                                whatElevator = 1;
                                break;
                            case 2:
                                Express2List.get(pickupFloor).setFill((Color.RED));
                                Express2Label.get(pickupFloor).setText("Patient");
                                whatElevator = 2;
                                break;
                        }
                        express.setText("Express staff pickup at elevator: " + whatElevator + " during iteration " + finalCounter + " at floor " + finalpickupFloor);

                    }

//                      If passenger is not staff and standard is available
                    else if (passenger.isStaff() || standardElevator.ablePickup()) {
                        skip = true;
                        int whatElevator = 0;
                        standardElevator.pickUp(passenger);

                        int pickupFloor = passenger.getPickupFloor();
//                      0=1, 1=2, 2=3, etc.
                        int finalpickupFloor = pickupFloor + 1;

//                          Either express1 or 2 (right or left)
                        switch (One_or_Two) {
                            case 1:
                                Standard1List.get(pickupFloor).setFill((Color.LIGHTBLUE));
                                Standard1Label.get(pickupFloor).setText("Staff");
                                whatElevator = 1;
                                break;

                            case 2:
                                Standard2List.get(pickupFloor).setFill((Color.LIGHTBLUE));
                                Standard2Label.get(pickupFloor).setText("Staff");
                                whatElevator = 2;
                                break;

                        }

                        standard.setText("Standard staff pickup at elevator: " + whatElevator + ", during iteration " + finalCounter + ", at floor " + finalpickupFloor);
                    }

                    if (skip){
                        long endTime = System.currentTimeMillis();
                        long timeTaken = endTime - startTime;

                        // Update the TimeID Text object with the time taken
                        Label Time = new Label();
                        Label blank = new Label();
                        Time.setText("Time taken for iteration " + finalCounter + ": " + timeTaken + " ms");

                        Platform.runLater(() -> TIMEvbox.getChildren().addAll(Time, standard, express, blank));
                        continue;


                    }
                    else {
                        //                  If standard elevator is full then it drops off the passengers
                        if (!standardElevator.ablePickup()) {
                            int listSize = standardElevator.passengers.size();
//                      Loop through each value in the list
                            for (int i = 0; i < listSize; i++) {
                                int dropoffFloor = passenger.getDroppedFloor();

                                standardElevator.dropOff(standardElevator.passengers.get(0));
//                      0=1, 1=2, 2=3, etc.
                                int finaldropoffFloor = dropoffFloor + 1;
                                int whichElevator = 0;


//                          Either express1 or 2 (right or left)
                                switch (One_or_Two) {
                                    case 1:
                                        Standard1List.get(dropoffFloor).setFill((Color.GREEN));
                                        Standard1Label.get(dropoffFloor).setText("Standard Dropped");

                                        break;
                                    case 2:
                                        Standard2List.get(dropoffFloor).setFill((Color.GREEN));
                                        Standard2Label.get(dropoffFloor).setText("Standard Dropped");

                                        break;
                                }
                                if (One_or_Two == 1){
                                    whichElevator = 3;
                                }
                                else {
                                    whichElevator = 4;
                                }
                                standard.setText("Standard dropoff at floor " + whichElevator +"  during iteration " + finalCounter + " at floor " + finaldropoffFloor);
                            }
                        }

//                  If the expressElvator is full then it drops off the passengers
                        if (!expressElevator.ablePickup()) {
//                      Loop through each value in the list
                            int listSize = expressElevator.passengers.size();
                            for (int i = 0; i < listSize; i++) {
                                int dropoffFloor = passenger.getDroppedFloor();

                                expressElevator.dropOff(expressElevator.passengers.get(0));
//                      0=1, 1=2, 2=3, etc.
                                int finaldropoffFloor = dropoffFloor + 1;

                                int whichElevator = 0;

//                          Either express1 or 2 (right or left)
                                switch (One_or_Two) {
                                    case 1:
                                        Express1List.get(dropoffFloor).setFill((Color.YELLOW));
                                        Express1Label.get(dropoffFloor).setText("Express Dropped");

                                        break;
                                    case 2:
                                        Express2List.get(dropoffFloor).setFill((Color.YELLOW));
                                        Express2Label.get(dropoffFloor).setText("Express Dropped");

                                        break;
                                }

                                if (One_or_Two == 1){
                                    whichElevator = 3;
                                }
                                else {
                                    whichElevator = 4;
                                }
                                express.setText("Express dropoff at floor " + whichElevator +"  during iteration " + finalCounter + " at floor " + finaldropoffFloor);
                            }
                        }
                    }


                    long endTime = System.currentTimeMillis();
                    long timeTaken = endTime - startTime;

                    // Update the TimeID Text object with the time taken
                    Label Time = new Label();
                    Label blank = new Label();
                    Time.setText("Time taken for iteration " + finalCounter + ": " + timeTaken + " ms");

                    Platform.runLater(() -> TIMEvbox.getChildren().addAll(Time, standard, express, blank));

                    counter++;
                    x++;
                }
            }
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            System.err.println("Input is not a valid integer");
            ErrorLabel.setText("INPUT A INTEGER");
        }
    }
    
    @FXML
    public void onInputFloors(ActionEvent actionEvent) {
    }


    @Deprecated
    public void onButtonIterations(ActionEvent actionEvent) {
    }

    @FXML
    public void onInterationNum(ActionEvent actionEvent) {
    }

}