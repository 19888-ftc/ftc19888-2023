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
        double servo1position=0.0;
        double servo2position=0.0;
        double servospeed=0.01;
        double servo3position=0.0;
        double servo4position=0.0;
        map.servo1.setPosition(0.0);
        map.servo2.setPosition(0.0);
        map.servo3.setPosition(0.0);
        map.servo4.setPosition(0.0);
        while(opModeIsActive()){
            double max;
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;
            double power1  =  0;
            double motorpower=0.04;
            if(gamepad1.dpad_up) power1=motorpower;
            double power2=0;
            if(gamepad1.dpad_down) power2=motorpower;
            double power3  =  0;
            if(gamepad1.y) power3=motorpower;
            double power4  =  0;
            if(gamepad1.a) power4=motorpower;
            double power5  =  0;
            if(gamepad1.x) power5=motorpower;
            double power6  =  0;
            if(gamepad1.b) power6=motorpower;
            map.servo1.setPosition(0.0);
            map.servo2.setPosition(0.0);
            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            double leftFrontPower  = axial + lateral + yaw;
            double rightFrontPower = axial - lateral - yaw;
            double leftBackPower   = axial - lateral + yaw;
            double rightBackPower  = axial + lateral - yaw;
            double Power=axial+lateral+yaw;
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
            }
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
            map.leftFront.setPower(-leftFrontPower);
            map.rightFront.setPower(rightFrontPower);
            map.leftBack.setPower(leftBackPower);
            map.rightBack.setPower(rightBackPower);
            map.slide1.setPower(power1-power2);
            map.slide2.setPower(power3-power4);
            //map.intake_.setPower(power5-power6);

            if(gamepad1.x) servo1position+=servospeed;
            if(gamepad1.b) servo2position-=servospeed;
            if(gamepad1.left_bumper) servo1position+=servospeed;
            if(gamepad1.right_bumper) servo2position-=servospeed;
            if(gamepad1.left_bumper) {servo3position+=servospeed;servo4position-=servospeed;}
            if(gamepad1.right_bumper) {servo3position-=servospeed;servo4position+=servospeed;}
            map.servo1.setPosition(servo1position);
            map.servo2.setPosition(servo2position);
            map.servo3.setPosition(servo3position);
            map.servo4.setPosition(servo4position);
            // Show the elapsed game time and wheel power.
            telemetry.addData("Front left/Right", "%4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.update();
        }
    }
}