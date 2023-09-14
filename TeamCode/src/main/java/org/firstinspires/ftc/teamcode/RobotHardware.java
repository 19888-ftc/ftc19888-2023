
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
    public Servo servo = null;
    // Define a constructor that allows the OpMode to pass a reference to itself.
    public RobotHardware(HardwareMap hardwareMap){

        // Define and Initialize Motors (note: need to use reference to actual OpMode).
        leftFront = hardwareMap.get(DcMotor.class, "lfDriveMotor");
        rightFront = hardwareMap.get(DcMotor.class, "rfDriveMotor");
        leftBack = hardwareMap.get(DcMotor.class, "lbDriveMotor");
        rightBack = hardwareMap.get(DcMotor.class, "rbDriveMotor");

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);




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
