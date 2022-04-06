package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "TestingIronWaffle")
@Disabled
public class TestingIronWaffle extends LinearOpMode {
    private DcMotor Bleftmotor;
    private DcMotor Fleftmotor;
    private DcMotor Frightmotor;
    private DcMotor Brightmotor;
    private DcMotor ArmMotor;
    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    // @Override
    public void runOpMode() {
        float leftpower;
        float rightpower;
        float rightstrafepower;
        float ArmMotorPower;

        Bleftmotor = hardwareMap.get(DcMotor.class, "Bleftmotor");
        Fleftmotor = hardwareMap.get(DcMotor.class, "Fleftmotor");
        Frightmotor = hardwareMap.get(DcMotor.class, "Frightmotor");
        Brightmotor = hardwareMap.get(DcMotor.class, "Brightmotor");
        ArmMotor = hardwareMap.get(DcMotor.class, "ArmMotor");
        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                leftpower = gamepad1.left_stick_y;
                Bleftmotor.setPower(leftpower);
                Fleftmotor.setPower(leftpower);
                rightpower = gamepad1.right_stick_y;
                Frightmotor.setPower(-rightpower);
                Brightmotor.setPower(-rightpower);
                rightstrafepower = gamepad1.right_stick_x;
                Fleftmotor.setPower(-rightstrafepower);
                Frightmotor.setPower(rightstrafepower);
                Brightmotor.setPower(-rightstrafepower);
                Bleftmotor.setPower(rightstrafepower);

                ArmMotorPower = gamepad1.left_trigger;
                ArmMotor.setPower(ArmMotorPower);

                // Put loop blocks here.
                telemetry.update();
            }
        }
    }
}