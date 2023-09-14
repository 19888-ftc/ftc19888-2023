package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class baller extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive robert = new SampleMecanumDrive(hardwareMap);
        robert.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();

        if (isStopRequested()) return;
        while (opModeIsActive()){


                Pose2d poseEstimate = robert.getPoseEstimate();

                Vector2d input = new Vector2d(
                        -gamepad1.left_stick_y,
                        -gamepad1.left_stick_x
                ).rotated(-poseEstimate.getHeading());


                robert.setWeightedDrivePower(
                        new Pose2d(
                                input.getX(),
                                input.getY(),
                                -gamepad1.right_stick_x
                        )
                );

        }
    }
}
