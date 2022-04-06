package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "TeleOpTest")

public class TeleOpTest extends LinearOpMode {

    private DcMotor fLeftMotor;
    private DcMotor fRightMotor;
    private DcMotor bLeftMotor;
    private DcMotor bRightMotor;

    @Override
    public void runOpMode() throws InterruptedException{

        fLeftMotor = hardwareMap.dcMotor.get("fLeftMotor");
        fRightMotor = hardwareMap.dcMotor.get("fRightMotor");
        bLeftMotor = hardwareMap.dcMotor.get("bLeftMotor");
        bRightMotor = hardwareMap.dcMotor.get("bRightMotor");

        waitForStart();

        while(opModeIsActive()){
            idle();
        }
    }
}
