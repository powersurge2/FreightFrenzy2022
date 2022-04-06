package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "GenericMecanum")
public class GenericMecanum extends LinearOpMode {
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

                    double output = 1;
                    double r = Math.hypot(gamepad1.left_stick_x,
                            gamepad1.left_stick_y);
                    double robotAngle = Math.atan2(gamepad1.left_stick_y,
                            gamepad1.left_stick_x) - Math.PI / 4;
                    double rightX = gamepad1.right_stick_x;
                    double v1 = r * Math.cos(robotAngle) - rightX;
                    double v2 = r * Math.sin(robotAngle) + rightX;
                    double v3 = r * Math.sin(robotAngle) - rightX;
                    double v4 = r * Math.cos(robotAngle) + rightX;
                    double v5 = gamepad1.right_trigger;

                    if (gamepad1.right_trigger > 0.5) {

                        v1 = (2 * v5) * v1;
                        v2 = (2 * v5) * v2;
                        v3 = (2 * v5) * v3;
                        v4 = (2 * v5) * v4;

                    }

                    v1 *= output;
                    v2 *= output;
                    v3 *= output;
                    v4 *= output;

                    fLeftMotor.setPower((v1));
                    fRightMotor.setPower((v2));
                    bLeftMotor.setPower((v3));
                    bRightMotor.setPower((v4));

                }
            }

            }
        }




