
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
    public DcMotor slide1=null;
    public DcMotor slide2=null;
    //public DcMotor intake_=null;
    public Servo servo1=null;
    public Servo servo2=null;
    public Servo servo3=null;
    public Servo servo4=null;
    public final static double ARM_HOME=0.0;
    public final static double ARM_MIN_RANGE=0.0;
    public final static double ARM_MAX_RANGE=1.0;
    // Define a constructor that allows the OpMode to pass a reference to itself.
    public RobotHardware(HardwareMap hardwareMap){

        // Define and Initialize Motors (note: need to use reference to actual OpMode).
        leftFront = hardwareMap.get(DcMotor.class, "lfDriveMotor");
        rightFront = hardwareMap.get(DcMotor.class, "rfDriveMotor");
        leftBack = hardwareMap.get(DcMotor.class, "lbDriveMotor");
        rightBack = hardwareMap.get(DcMotor.class, "rbDriveMotor");
        slide1=hardwareMap.get(DcMotor.class,"slide1");
        slide2=hardwareMap.get(DcMotor.class,"slide2");
        //intake_=hardwareMap.get(DcMotor.class,"intake_");
        servo1=hardwareMap.get(Servo.class,"servo1");
        servo2=hardwareMap.get(Servo.class,"servo2");
        servo3=hardwareMap.get(Servo.class,"servo3");
        servo4=hardwareMap.get(Servo.class,"servo4");
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        slide1.setDirection(DcMotorSimple.Direction.FORWARD);
        slide2.setDirection(DcMotorSimple.Direction.FORWARD);
        servo1.setDirection(Servo.Direction.FORWARD);
        servo2.setDirection(Servo.Direction.FORWARD);
        servo3.setDirection(Servo.Direction.FORWARD);
        servo4.setDirection(Servo.Direction.FORWARD);
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
