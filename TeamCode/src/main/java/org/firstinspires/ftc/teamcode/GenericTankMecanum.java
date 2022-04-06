/*package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "GenericTankMecanum")
public class GenericTankMecanum extends LinearOpMode {
    private DcMotor bLeftMotor;
    private DcMotor fLeftMotor;
    private DcMotor fRightMotor;
    private DcMotor bRightMotor;



    @Override
    @Disabled
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
                } else if (gamepad1.right_trigger){
                else {
                    leftpower = gamepad1.left_stick_y;
                    bLeftMotor.setPower(.75 * leftpower);
                    fLeftMotor.setPower(.75 * leftpower);
                    rightpower = gamepad1.right_stick_y;
                    fRightMotor.setPower(-.75 * rightpower);
                    bRightMotor.setPower(-.75 * rightpower);
                }
            }
        }
    }
}

 */