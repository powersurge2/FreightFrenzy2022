package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@Autonomous(name = "sensorTouch")
@Disabled
public class touchSensortest extends LinearOpMode {
    hardWareMap robot = new hardWareMap();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        float leftpower;
        float rightpower;
        float rightstrafepower;


// bLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
// fLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
// Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {

          /*  while (robot.carouselDistance.getDistance(DistanceUnit.INCH) > 8) {
                robot.bLeft.setPower(.25);
                robot.bRight.setPower(-.35);
                robot.fLeft.setPower(.25);
                robot.fRight.setPower(-.25);
                telemetry.addData("IS", "Less Than 5");
                telemetry.update();
            }
            if (gamepad1.dpad_up){
                robot.topActuator.setPower(1);
                robot.bottomActuator.setPower(1);
            }
            else if (gamepad1.dpad_down) {
                robot.topActuator.setPower(-1);
                robot.bottomActuator.setPower(-1);
            } else  {
                       robot.topActuator.setPower(0);
                robot.bottomActuator.setPower(0); }
            }
            robot.bLeft.setPower(0);
            robot.bRight.setPower(0);
            robot.fLeft.setPower(0);
            robot.fRight.setPower(0);
            telemetry.addData("Here", robot.carouselDistance.getDistance(DistanceUnit.INCH));
            telemetry.update();
            sleep(3000);
           robot. carousel.setPower(0.25);
            sleep(3000);
            robot.carousel.setPower(0);
            sleep(3000);
        } */
        }
    }
}
