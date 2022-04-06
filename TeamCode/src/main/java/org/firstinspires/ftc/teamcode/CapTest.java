package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "CapTest")
 @Disabled
public class CapTest extends LinearOpMode {

    private DcMotor armMotor;
    private DcMotor carouselMotor;
    private DistanceSensor carouselDistance;
    private DistanceSensor capDistance;
    private DcMotor clawMotor;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        float leftpower;
        float rightpower;
        float rightstrafepower;
        float xdiagonalpower;
        float ydiagonalpower;
        float clawPower;
        float armpower;
        float carouselpower;


        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        carouselDistance = hardwareMap.get(DistanceSensor.class, "carouselDistance");
        capDistance = hardwareMap.get(DistanceSensor.class, "capDistance");
        clawMotor = hardwareMap.get(DcMotor.class, "clawMotor");
        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {

            // Put run blocks here.
            while (opModeIsActive()) {

                if (gamepad1.a) {
                    while (capDistance.getDistance(DistanceUnit.CM) < 40) {
                        armMotor.setPower(-.75);
                        telemetry.addData("Distance", capDistance.getDistance(DistanceUnit.CM));
                        telemetry.update();
                    }
                } else {
                    armpower = gamepad1.left_stick_y;
                    armMotor.setPower(armpower);
                    telemetry.addData("Distance", capDistance.getDistance(DistanceUnit.CM));
                    telemetry.update();
                }
            }
        }
    }
}

