package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "RedDrivingAutonoumous")
public class RedDrivingAutonomous extends LinearOpMode {
    private DcMotor bLeftMotor;
    private DcMotor fLeftMotor;
    private DcMotor fRightMotor;
    private DcMotor bRightMotor;
    private DcMotor armMotor;
    private DcMotor carouselMotor;
    private Servo clawServo1;
    private DistanceSensor carouselDistance;
    private DcMotor clawMotor;


    /*
    Drives backwards using the distance sensor into the warehouse. Self Explanatory.
     */
    @Override
    public void runOpMode() {
        float leftpower;
        float rightpower;
        float rightstrafepower;

        bLeftMotor = hardwareMap.get(DcMotor.class, "bLeftMotor");
        fLeftMotor = hardwareMap.get(DcMotor.class, "fLeftMotor");
        fRightMotor = hardwareMap.get(DcMotor.class, "fRightMotor");
        bRightMotor = hardwareMap.get(DcMotor.class, "bRightMotor");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        clawServo1 = hardwareMap.get(Servo.class, "clawServo1");
        carouselDistance = hardwareMap.get(DistanceSensor.class, "carouselDistance");
        clawMotor = hardwareMap.get(DcMotor.class, "clawMotor");

// bLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
// fLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

// Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            armMotor.setPower(-1);
            sleep(700);
            armMotor.setPower(0);
            sleep(1000);

            clawMotor.setPower(0.50);
            sleep(1000);
            clawMotor.setPower(0);
            sleep(1000);

            fLeftMotor.setPower(.25);
            fRightMotor.setPower(.25);
            bRightMotor.setPower(-.25);
            bLeftMotor.setPower(-.25);
            sleep(700);

            bLeftMotor.setPower(0);
            bRightMotor.setPower(0);
            fLeftMotor.setPower(0);
            fRightMotor.setPower(0);
            sleep(500);

            while (carouselDistance.getDistance(DistanceUnit.INCH) > 22) {
                bLeftMotor.setPower(.25);
                bRightMotor.setPower(-.27);
                fLeftMotor.setPower(.25);
                fRightMotor.setPower(-.27);
                telemetry.addData("IS", "Driving Backwards");
                telemetry.update();



            }

            bLeftMotor.setPower(0);
            bRightMotor.setPower(0);
            fLeftMotor.setPower(0);
            fRightMotor.setPower(0);
            sleep(250);

            armMotor.setPower(1);
            sleep(700);
            armMotor.setPower(0);
            sleep(3000);


        }
    }
}

