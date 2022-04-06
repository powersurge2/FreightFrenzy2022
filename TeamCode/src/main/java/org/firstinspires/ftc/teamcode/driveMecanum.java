package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name="Mecanum Drive")
@Disabled
public class driveMecanum extends LinearOpMode {

    hardWareMap robot = new hardWareMap();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        methods drive = new methods(robot, this);
        telemetry.addData("Robot", "Initialized");
        telemetry.update();
        RevBlinkinLedDriver.BlinkinPattern orange;
        RevBlinkinLedDriver.BlinkinPattern blue;
        orange = RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE;
        blue = RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_OCEAN_PALETTE;

        waitForStart();

        robot.runtime.reset();

        while (opModeIsActive()) {
            drive.Mecanum(0.5);

            // Using if and else if to move the arm
            // setting a tolerance to allow us to avoid having false positives reads move the arm
            double t = gamepad2.right_trigger;
            double f = gamepad2.left_trigger;

            if (t > 0.1){
                robot.armMotor.setPower(t);
            }
            else if  ( (f > 0.1 )) {
                robot.armMotor.setPower(-(f));
            }
            else {
                robot.armMotor.setPower(0);
            }
            robot.clawMotor.setPower(gamepad2.left_stick_y * 0.25);


// adding v as the output from the method;
            telemetry.addData("Wheel Power",
                    "front left (%.2f), front right (%.2f), " +

                        "back left (%.2f), back right (%.2f)" ,
                    robot.fLeft.getPower(), robot.fRight.getPower(),

                    robot.bLeft.getPower(), robot.bRight.getPower())


            ;

            telemetry.update();
        }
    }
}