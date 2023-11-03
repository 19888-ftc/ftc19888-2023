
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class RobotHardware {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    public DcMotor leftFront   = null;
    public DcMotor rightFront  = null;
    public DcMotor leftBack   = null;
    public DcMotor rightBack  = null;
    public DcMotor intake1=null;
    public DcMotor intake2=null;
    public DcMotor slide1=null;
    public DcMotor slide2=null;
    //public DcMotor intake_=null;
    public Servo servo1=null;
    public Servo servo2=null;
    // Define a constructor that allows the OpMode to pass a reference to itself.
    public RobotHardware(HardwareMap hardwareMap){

        // Define and Initialize Motors (note: need to use reference to actual OpMode).
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "leftBack");
        leftBack = hardwareMap.get(DcMotor.class, "rightBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightFront");
        slide1=hardwareMap.get(DcMotor.class,"slide1");
        slide2=hardwareMap.get(DcMotor.class,"slide2");
        intake1=hardwareMap.get(DcMotor.class,"intake1");
        intake2=hardwareMap.get(DcMotor.class,"intake2");
        //intake_=hardwareMap.get(DcMotor.class,"intake_");
        servo1=hardwareMap.get(Servo.class,"servo1");
        servo2=hardwareMap.get(Servo.class,"servo2");
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        slide1.setDirection(DcMotorSimple.Direction.FORWARD);
        slide2.setDirection(DcMotorSimple.Direction.FORWARD);
        intake1.setDirection(DcMotorSimple.Direction.FORWARD);
        intake2.setDirection(DcMotorSimple.Direction.FORWARD);
        servo1.setDirection(Servo.Direction.FORWARD);
        servo2.setDirection(Servo.Direction.FORWARD);
        //intake_.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    /**
     * Calculates the left/right motor powers required to achieve the requested
     * robot motions: Drive (Axial motion) and Turn (Yaw motion).
     * Then sends these power levels to the motors.
     *
     * @param Drive     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param Turn      Right/Left turning power (-1.0 to 1.0) +ve is CW
     */

}
