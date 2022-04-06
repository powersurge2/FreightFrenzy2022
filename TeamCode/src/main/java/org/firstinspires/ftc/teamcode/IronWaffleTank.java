package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "IronWaffleTank")
@Disabled
public class IronWaffleTank extends LinearOpMode {
    private DcMotor bLeftMotor;
    private DcMotor fLeftMotor;
    private DcMotor fRightMotor;
    private DcMotor bRightMotor;
    private DcMotor armMotor;
    private DcMotor carouselMotor;
    private DistanceSensor carouselDistance;
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
        bLeftMotor = hardwareMap.get(DcMotor.class, "bLeftMotor");
        fLeftMotor = hardwareMap.get(DcMotor.class, "fLeftMotor");
        fRightMotor = hardwareMap.get(DcMotor.class, "fRightMotor");
        bRightMotor = hardwareMap.get(DcMotor.class, "bRightMotor");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        carouselDistance = hardwareMap.get(DistanceSensor.class, "carouselDistance");
        clawMotor = hardwareMap.get(DcMotor.class, "clawMotor");
        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                if (gamepad1.dpad_left) {
                    fLeftMotor.setPower(-.5);
                    fRightMotor.setPower(-.5);
                    bRightMotor.setPower(.5);
                    bLeftMotor.setPower(.5);
                } else if (gamepad1.dpad_right) {
                    fLeftMotor.setPower(.5);
                    fRightMotor.setPower(.5);
                    bRightMotor.setPower(-.5);
                    bLeftMotor.setPower(-.5);
                }
                



                 else {
                    leftpower = gamepad1.left_stick_y;
                    bLeftMotor.setPower(.75 * leftpower);
                    fLeftMotor.setPower(.75 * leftpower);
                    rightpower = gamepad1.right_stick_y;
                    fRightMotor.setPower(-.75 * rightpower);
                    bRightMotor.setPower(-.75 * rightpower);
                }
                armpower = gamepad2.left_stick_y;
                armMotor.setPower(armpower);
                if(gamepad1.a){
                    armMotor.setPower(.5 * armpower);
                }

                carouselpower = gamepad2.right_stick_y;
                carouselMotor.setPower(.5 * carouselpower);
                // flat
                if(gamepad2.left_trigger >0){
                    clawMotor.setPower(.25);
                }
                else if (gamepad2.right_trigger > 0){
                    clawMotor.setPower(-.25);
                }
                else{
                    clawMotor.setPower(0);
                }



            }
                /*else if(gamepad2.y){
                    tiltServo.setPosition(1);
                }
                else if (gamepad2.x){
                    tiltServo.setPosition(0);
                }*/

            telemetry.update();
        }
    }
}