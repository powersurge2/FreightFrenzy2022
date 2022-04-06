package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@TeleOp(name = "IronWaffleDrive")
public class IronWaffleDrive extends LinearOpMode {
    hardWareMap robot = new hardWareMap();
    double up = 0.5;
    double armpower;
    double carouselpower;
    double clawPower;

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
                drive.cool();
                // The below allows us to have three different drive codes in a single code
                if ((gamepad1.right_bumper)) {
                    drive.tank();
                } else if ((gamepad1.left_bumper)) {
                    drive.tankADV();
                } else {
                    drive.Mecanum(0.5);
                }
            /*    if (gamepad2.b) {
                    while (robot.capDistance.getDistance(DistanceUnit.CM) < 36) {
                        robot.armMotor.setPower(-.75);
                        telemetry.addData("Distance", robot.capDistance.getDistance(DistanceUnit.CM));
                        telemetry.update();
                    }
             }  */


                // To allow us to run the arm at fast and slow speeds
                armpower = gamepad2.left_stick_y / 2.0;
                if ((gamepad2.right_trigger) > 0) {
                    clawPower = gamepad2.right_trigger * 0.25;
                } else {
                    clawPower = -gamepad2.left_trigger * 0.25;
                }
                if (gamepad2.a) {
                    robot.armMotor.setPower(1.5 * armpower);
                    robot.clawMotor.setPower(1.33 * clawPower);
                    robot.carousel.setPower(1.5 * carouselpower);
                } else {
                    robot.clawMotor.setPower(clawPower);
                    robot.armMotor.setPower(armpower);
                }
              /*  if (gamepad2.x) {
                    robot.carousel.setPower(0.5);
                    sleep(1000);
                    robot.carousel.setPower(0.75);
                    sleep(1000);
                    robot.carousel.setPower(0);
                } */
                carouselpower = gamepad2.right_stick_x;
                robot.carousel.setPower(.25 * carouselpower);

                telemetry.addData("Wheel Power",
                        "front left (%.2f), front right (%.2f), " +
                                "back left (%.2f), back right (%.2f)",
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