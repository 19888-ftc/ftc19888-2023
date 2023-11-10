package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous

public class Automatic extends LinearOpMode{



    @Override
    public void runOpMode(){
        RobotHardware map= new RobotHardware(hardwareMap);
        waitForStart();
        while(opModeIsActive()) {
            /*double t1=0.0,t2=0.0,t3=0.0;
            map.leftFront.setPower(0.6);
            map.leftBack.setPower(0.6);
            map.rightFront.setPower(0.6);
            map.rightBack.setPower(0.6);
            sleep(1000);

            map.leftFront.setPower(0.6);
            map.leftBack.setPower(0.6);
            map.rightFront.setPower(-0.6);
            map.rightBack.setPower(-0.6);
            sleep(1000);
            map.leftFront.setPower(0.6);
            map.leftBack.setPower(0.6);
            map.rightFront.setPower(0.6);
            map.rightBack.setPower(0.6);
            sleep(1000);
            break;*/
        }
    }
}
