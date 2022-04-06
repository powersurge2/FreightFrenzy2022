package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "GenericTank")
public class GenericTank extends LinearOpMode {
    private DcMotor bLeftMotor;
    private DcMotor fLeftMotor;
    private DcMotor fRightMotor;
    private DcMotor bRightMotor;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        float leftpower;
        float rightpower;
        bLeftMotor = hardwareMap.get(DcMotor.class, "bLeftMotor");
        fLeftMotor = hardwareMap.get(DcMotor.class, "fLeftMotor");
        fRightMotor = hardwareMap.get(DcMotor.class, "fRightMotor");
        bRightMotor = hardwareMap.get(DcMotor.class, "bRightMotor");

//        fRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        bRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
              /*  if (gamepad1.dpad_left) {
                    bLeftMotor.setPower(leftpower);
                    fLeftMotor.setPower(leftpower);
                }*/

                    leftpower = gamepad1.left_stick_y;
                    bLeftMotor.setPower(1 * leftpower);
                    fLeftMotor.setPower(1 * leftpower);
                    rightpower = gamepad1.right_stick_y;
                    fRightMotor.setPower(1 * rightpower);
                    bRightMotor.setPower(1 * rightpower);
                }
            }
        }
    }
