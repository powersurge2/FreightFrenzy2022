package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@Autonomous(name = "RedBlockAutonomous")
@Disabled

public class RedBlockAutonomous extends LinearOpMode {
    private DcMotor bLeftMotor;
    private DcMotor fLeftMotor;
    private DcMotor fRightMotor;
    private DcMotor bRightMotor;
    private DcMotor armMotor;
    private DcMotor carouselMotor;
    private Servo clawServo1;
    private DistanceSensor carouselDistance;
    private DcMotor clawMotor;
    private DistanceSensor capDistance;

    /*
      This code goes back and runs the carousel and then strafes left into the storage box.
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
        capDistance = hardwareMap.get(DistanceSensor.class, "capDistance");
// bLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
// fLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
// Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            while (capDistance.getDistance(DistanceUnit.INCH) > 10) {
                armMotor.setPower(.5);

            }
            armMotor.setPower(0);
        }
    }
}