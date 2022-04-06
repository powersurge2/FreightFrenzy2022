package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@Autonomous(name = "RedCarouselAutonomous")
public class RedCarouselAutonomous extends LinearOpMode {
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
     The blue version of Red Carousel Autonomous.  This code goes back and runs the carousel and then strafes right into the storage box.
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
            //Raising arm, closing claw, and strafe sideways

            clawMotor.setPower(0.50);
            sleep(1300);
            clawMotor.setPower(0);
            sleep(1000);

            armMotor.setPower(-1);
            sleep(600);
            armMotor.setPower(0);
            sleep(1000);

            fLeftMotor.setPower(-.25);
            fRightMotor.setPower(-.25);
            bRightMotor.setPower(.25);
            bLeftMotor.setPower(.25);
            sleep(500);
            bLeftMotor.setPower(0);
            bRightMotor.setPower(0);
            fLeftMotor.setPower(0);
            fRightMotor.setPower(0);
            sleep(500);

            //Driving backwards and spinning carousel
            while (carouselDistance.getDistance(DistanceUnit.INCH) > 9) {
                bLeftMotor.setPower(.25);
                bRightMotor.setPower(-.25);
                fLeftMotor.setPower(.28);
                fRightMotor.setPower(-.25);
                telemetry.addData("IS", "Less Than 5");
                telemetry.update();
            }
            bLeftMotor.setPower(0);
            bRightMotor.setPower(0);
            fLeftMotor.setPower(0);
            fRightMotor.setPower(0);
            telemetry.addData("Here", carouselDistance.getDistance(DistanceUnit.INCH));
            telemetry.update();
            sleep(500);
            carouselMotor.setPower(-0.25);
            sleep(3000);
            carouselMotor.setPower(0);
            sleep(1000);
            // Strafing, driving backwards into box, and opening claw
            fLeftMotor.setPower(.5);
            fRightMotor.setPower(.5);
            bRightMotor.setPower(-.5);
            bLeftMotor.setPower(-.5);
            sleep(1600);

            bLeftMotor.setPower(0);
            bRightMotor.setPower(0);
            fLeftMotor.setPower(0);
            fRightMotor.setPower(0);
            telemetry.update();
            sleep(500);

          /*  while (carouselDistance.getDistance(DistanceUnit.INCH) > 3) {
                bLeftMotor.setPower(.28);
                bRightMotor.setPower(-.25);
                fLeftMotor.setPower(.28);
                fRightMotor.setPower(-.25);
                telemetry.update();
            } */
            /*int i = 1;
            while ((i < 300) || (carouselDistance.getDistance(DistanceUnit.INCH) < 1)) {
                bLeftMotor.setPower(.28);
                bRightMotor.setPower(-.25);
                fLeftMotor.setPower(.28);
                fRightMotor.setPower(-.25);
                i++;
                sleep(10);
                telemetry.addData("IS", "Less Than 5");
                telemetry.update();
            }*/
            while (carouselDistance.getDistance(DistanceUnit.INCH) > 3) {
                bLeftMotor.setPower(.28);
                bRightMotor.setPower(-.25);
                fLeftMotor.setPower(.28);
                fRightMotor.setPower(-.25);
                telemetry.addData("IS", "Less Than 5");
                telemetry.update();
            }

            bLeftMotor.setPower(0);
            bRightMotor.setPower(0);
            fLeftMotor.setPower(0);
            fRightMotor.setPower(0);
            telemetry.addData("Here", carouselDistance.getDistance(DistanceUnit.INCH));
            telemetry.update();
            sleep(500);

            armMotor.setPower(.5);
            sleep(600);
            armMotor.setPower(0);
            sleep(500);

            clawMotor.setPower(-0.25);
            sleep(3000);
            clawMotor.setPower(0);
            sleep(3000);
            bLeftMotor.setPower(0);
            bRightMotor.setPower(0);
            fLeftMotor.setPower(0);
            fRightMotor.setPower(0);
            sleep(500);


        }
    }
}