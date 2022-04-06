
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@TeleOp(name = "IronWaffleDrive Tripple")
@Disabled
public class tripleDrivemode extends LinearOpMode {
    hardWareMap robot = new hardWareMap();
    double up = 0.5;
    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        // Put initialization blocks here.
        waitForStart();
        robot.init(hardwareMap);
        methods drive = new methods(robot, this);
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                robot.isStrafing = false;
                if ((gamepad1.left_bumper) && (gamepad1.right_bumper == false)){
                    drive.Mecanum(0.5);
                } else {
                    robot.fLeft.setPower(0);
                    robot.bLeft.setPower(0);
                    robot.fRight.setPower(0);
                    robot.bRight.setPower(0);
                }
                if ((gamepad1.right_bumper) && (gamepad1.left_bumper == false)){
                    drive.tankADV();
                } else {
                    robot.fLeft.setPower(0);
                    robot.bLeft.setPower(0);
                    robot.fRight.setPower(0);
                    robot.bRight.setPower(0);
                }
                if ((gamepad1.right_bumper) && (gamepad1.left_bumper)) {
                    drive.tank();
                } else {
                    robot.fLeft.setPower(0);
                    robot.bLeft.setPower(0);
                    robot.fRight.setPower(0);
                    robot.bRight.setPower(0);
                }
                double t = gamepad2.right_trigger;
                double f = gamepad2.left_trigger;
                if (t > 0.1) {
                    robot.armMotor.setPower(t);
                } else if ((f > 0.1)) {
                    robot.armMotor.setPower(-(f));
                } else {
                    robot.armMotor.setPower(0);
                }
                double arctangent = Math.atan2(gamepad2.right_stick_x,
                        gamepad2.right_stick_y);
                if ((arctangent > 1.4) && (arctangent < 1.6)) {
                    robot.carousel.setPower(0.25);
                }
                else if ((arctangent < -1.4) && (arctangent > -1.6)) {
                    robot.carousel.setPower(-0.25);
                } else {
                    robot.carousel.setPower(0);
                }
                robot.clawMotor.setPower(gamepad2.left_stick_y * 0.25);
                telemetry.addData("Wheel Power",
                        "front left (%.2f), front right (%.2f), " +
                                "back left (%.2f), back right (%.2f)" ,
                        robot.fLeft.getPower(), robot.fRight.getPower(),
                        robot.bLeft.getPower(), robot.bRight.getPower());
                telemetry.update();
                 /*if (robot.sensorDistance.getDistance(DistanceUnit.INCH) > ){
                       robot.fLeft.setPower(-Math.abs(gamepad1.left_stick_y));
                       robot.bRight.setPower(-Math.abs(gamepad1.right_stick_y));
                       robot.fRight.setPower(-Math.abs(gamepad1.right_stick_y));
                       robot.bLeft.setPower(-Math.abs(gamepad1.left_stick_y));
                    } */
            }
        }
    }
}