package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp
public class TeleOp1 extends LinearOpMode{
    @Override
    public void runOpMode(){
        RobotHardware map = new RobotHardware(hardwareMap);
        waitForStart();
        double servoposition=0.0;
        double placement_angle=0.75;// the angle for the placement, servo
        //map.servo2.setPosition(0.0);
        //map.servo1.setPosition(0.0);
        //initialize servo position
        while(opModeIsActive()){
            double max;
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;
            double power1  =  0;//power1 is the positive power for the slide
            double motorpower=0.8;//motorpower is the default power for all the motors except the driving motors
            if(gamepad1.dpad_up) power1=motorpower;
            double power2=0;//power2 is the negative power for the slide
            if(gamepad1.dpad_down) power2=motorpower;
            double power3=0;//power3 is the power for the intake
            if(gamepad1.left_bumper) power3=motorpower;
            if(gamepad1.a)  servoposition=placement_angle;
            if(gamepad1.b)  servoposition=0.0;
            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            double leftFrontPower  = axial + lateral + yaw;
            double rightFrontPower = axial - lateral - yaw;
            double leftBackPower   = axial - lateral + yaw;
            double rightBackPower  = axial + lateral - yaw;
            double Power=axial+lateral+yaw;//driving template no need to change
            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max=Math.abs(leftFrontPower);
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));
            if (max > 1.0) {
                leftFrontPower  /= max;
                rightFrontPower /= max;
                leftBackPower   /= max;
                rightBackPower  /= max;
            }//driving template no need to change
            // This is test code:
            //
            // Uncomment the following code to test your motor directions.
            // Each button should make the corresponding motor run FORWARD.
            //   1) First get all the motors to take to correct positions on the robot
            //      by adjusting your Robot Configuration if necessary.
            //   2) Then make sure they run in the correct direction by modifying the
            //      the setDirection() calls above.
            // Once the correct motors move in the correct direction re-comment this code.
            leftFrontPower  = gamepad1.x ? 1.0 : 0.0;  // X gamepad
            leftBackPower   = gamepad1.a ? 1.0 : 0.0;  // A gamepad
            rightFrontPower = gamepad1.y ? 1.0 : 0.0;  // Y gamepad
            rightBackPower  = gamepad1.b ? 1.0 : 0.0;  // B gamepad
            // Send calculated power to wheels
            /*map.leftFront.setPower(-leftFrontPower);
            map.rightFront.setPower(rightFrontPower);
            map.leftBack.setPower(leftBackPower);
            map.rightBack.setPower(rightBackPower);
            map.slide1.setPower(power1-power2);// the power on the positive side - power on the negative side = the power
            map.slide2.setPower(power1-power2);*/
            map.intake1.setPower(power3);
            //map.intake2.setPower(power3);
            //map.intake_.setPower(power5-power6);
            //set the power for all the powers
            //map.servo1.setPosition(servoposition);
            //map.servo2.setPosition(servoposition);
            //set position for the servo
            // Show the elapsed game time and wheel power.
            telemetry.addData("Front left/Right", "%4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.update();
        }
    }
}