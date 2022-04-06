package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "MethodsTest")

public class MethodsTest extends LinearOpMode {

    // DcMotors
    private DcMotor bLeftMotor;
    private DcMotor fLeftMotor;
    private DcMotor fRightMotor;
    private DcMotor bRightMotor;

    @Override public void runOpMode() throws InterruptedException {

        double power;
        power = 0.5;

        // Initialization
        bLeftMotor = hardwareMap.dcMotor.get("bLeftMotor");
        bRightMotor = hardwareMap.dcMotor.get("bRightMotor");
        fLeftMotor = hardwareMap.dcMotor.get("fLeftMotor");
        fRightMotor = hardwareMap.dcMotor.get("fRightMotor");

        waitForStart();

        // Run Code
        DriveForwardTime(1, 4000);
        DriveLeftTime(1,500);
        DriveRightTime(1,500);
        DriveForwardTime(1,4000);
        DriveBackTime(1,5000);


    }

    // Creating Methods - able to shorten the code
    public void DriveForward(double power){
        bLeftMotor.setPower(power);
        bRightMotor.setPower(power);
        fRightMotor.setPower(power);
        fLeftMotor.setPower(power);
    }
    public void DriveForwardTime(double power, long time) throws InterruptedException{
        DriveForward(power);
        Thread.sleep(time);
    }
    public void DriveLeft(double power){
        bLeftMotor.setPower(power);
        bRightMotor.setPower(0);
        fLeftMotor.setPower(power);
        fRightMotor.setPower(0);
    }
    public void DriveLeftTime(double power, long time) throws InterruptedException{
        DriveLeft(power);
        Thread.sleep(time);
    }
    public void DriveRight(double power){
        bLeftMotor.setPower(0);
        bRightMotor.setPower(power);
        fLeftMotor.setPower(0);
        fRightMotor.setPower(power);
    }
    public void DriveRightTime(double power, long time) throws InterruptedException{
        DriveRight(power);
        Thread.sleep(time);
    }

    public void DriveBack(double power){
        DriveForward(-power);
    }
    public void DriveBackTime(double power, long time) throws InterruptedException{
        DriveBack(power);
        Thread.sleep(time);
    }
}