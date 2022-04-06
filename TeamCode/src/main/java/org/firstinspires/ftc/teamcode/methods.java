
package org.firstinspires.ftc.teamcode;


import static android.os.Looper.loop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class methods extends hardWareMap {

    private LinearOpMode opModeObj;

    public hardWareMap robot;


    public methods(hardWareMap hardwaremap, LinearOpMode opMode) {

        robot = hardwaremap;

        opModeObj = opMode;

    }

    public void Holonomic() {

        double rightActual;

        if ((Math.atan2(opModeObj.gamepad1.right_stick_x,
                opModeObj.gamepad1.right_stick_y) < Math.PI) &&
                (Math.atan2(opModeObj.gamepad1.right_stick_x,
                        opModeObj.gamepad1.right_stick_y) > 1.57)) {

            rightActual = -(1 - (1 - (Math.hypot(opModeObj.gamepad1.right_stick_x,
                    opModeObj.gamepad1.right_stick_y))));

        } else {

            rightActual = (1 - (1 - (Math.hypot(opModeObj.gamepad1.right_stick_x,
                    opModeObj.gamepad1.right_stick_y))));

        }

        double joyStick = Math.hypot(opModeObj.gamepad1.left_stick_x,
                opModeObj.gamepad1.left_stick_y);

        if ((Math.atan2(opModeObj.gamepad1.left_stick_x,
                opModeObj.gamepad1.left_stick_y) < 1.57) &&
                (Math.atan2(opModeObj.gamepad1.left_stick_x,
                        opModeObj.gamepad1.left_stick_y) > -1.57)) {

            joyStick = Math.abs(Math.hypot(opModeObj.gamepad1.left_stick_x,
                    opModeObj.gamepad1.left_stick_y));

        } else {

            joyStick = 0;

        }
        robot.bLeft.setPower(joyStick);

        robot.bRight.setPower(joyStick);

        if (Math.hypot(opModeObj.gamepad1.right_stick_x,
                opModeObj.gamepad1.right_stick_y) == 0) {

            robot.fRight.setPower(joyStick);

            robot.fLeft.setPower(joyStick);

        } else {

            robot.fLeft.setPower(-rightActual);

            robot.fRight.setPower(rightActual);

        }

        if (opModeObj.gamepad1.x) {

            robot.bLeft.setPower(1);

            robot.fLeft.setPower(-1);

        }
    }

    public double Mecanum(double powerLimit) {

        double output = powerLimit;


        double r = Math.hypot(opModeObj.gamepad1.left_stick_x,
                opModeObj.gamepad1.left_stick_y);

        double robotAngle = Math.atan2(-opModeObj.gamepad1.left_stick_y,
                opModeObj.gamepad1.left_stick_x) - Math.PI / 4;

        double rightX = opModeObj.gamepad1.right_stick_x;

        double v1 = r * Math.cos(robotAngle) - rightX;

        double v2 = r * Math.sin(robotAngle) + rightX;

        double v3 = r * Math.sin(robotAngle) - rightX;

        double v4 = r * Math.cos(robotAngle) + rightX;

        double v5 = opModeObj.gamepad1.right_trigger;

        if (opModeObj.gamepad1.right_trigger > 0.5) {

            v1 = (2 * v5) * v1;

            v2 = (2 * v5) * v2;

            v3 = (2 * v5) * v3;

            v4 = (2 * v5) * v4;

        }

        v1 *= output;

        v2 *= output;

        v3 *= output;

        v4 *= output;

        robot.fLeft.setPower((v1));

        robot.fRight.setPower((v2));

        robot.bLeft.setPower((v3));

        robot.bRight.setPower((v4));

// need to add because it was giving error on missing return after I returned
        return 0.0;
    }

    /* Extra Option for Mecanum Drive */
    public void TimeDrive(double time, double lx, double ly, double rx) {

        double r = Math.hypot(lx, ly);

        double robotAngle = Math.atan2(-ly, lx) - Math.PI / 4;

        double rightX = rx;

        double v1 = r * Math.cos(robotAngle) - rightX;

        double v2 = r * Math.sin(robotAngle) + rightX;

        double v3 = r * Math.sin(robotAngle) - rightX;

        double v4 = r * Math.cos(robotAngle) + rightX;


        if (opModeObj.gamepad1.x) {

            v1 *= 2;

            v2 *= 2;

            v3 *= 2;

            v4 *= 2;

        }

        robot.fLeft.setPower(v1 * 1);

        robot.fRight.setPower(v2 * 1);

        robot.bLeft.setPower(v3 * 1);

        robot.bRight.setPower(v4 * 1);

        opModeObj.sleep((long) time * 1000);

        robot.fRight.setPower(0);
        robot.fLeft.setPower(0);
        robot.bLeft.setPower(0);
        robot.bRight.setPower(0);
    }

    public void tankADV() {
        double universalPower = 0.5;
        if ((Math.atan2(opModeObj.gamepad1.left_stick_x,
                opModeObj.gamepad1.left_stick_y) < -1.4) &&
                (Math.atan2(opModeObj.gamepad1.left_stick_x,
                        opModeObj.gamepad1.left_stick_y) > -1.6)) {
            robot.isStrafing = true;
            robot.fLeft.setPower(-universalPower);
            robot.bLeft.setPower(universalPower);
            robot.bRight.setPower(-universalPower);
            robot.fRight.setPower(universalPower);
        } else if ((Math.atan2(opModeObj.gamepad1.right_stick_x,
                opModeObj.gamepad1.right_stick_y) > 1.4) &&
                (Math.atan2(opModeObj.gamepad1.right_stick_x,
                        opModeObj.gamepad1.right_stick_y) < 1.6)) {
            robot.isStrafing = true;
            robot.fLeft.setPower(universalPower);
            robot.bLeft.setPower(-universalPower);
            robot.bRight.setPower(universalPower);
            robot.fRight.setPower(-universalPower);
        } else {
            robot.isStrafing = false;
        }
        if (opModeObj.gamepad1.left_trigger > 0.5) {
            universalPower = (2 * opModeObj.gamepad1.right_trigger) * universalPower;
        }

        if (robot.isStrafing == false) {
            robot.fLeft.setPower(-opModeObj.gamepad1.left_stick_y / 2);
            robot.bLeft.setPower(-opModeObj.gamepad1.left_stick_y / 2);
            robot.fRight.setPower(-opModeObj.gamepad1.right_stick_y / 2);
            robot.bRight.setPower(-opModeObj.gamepad1.right_stick_y / 2);

        } else if ((opModeObj.gamepad1.right_trigger > 0.5) && (robot.isStrafing == false)) {
            robot.fLeft.setPower(-opModeObj.gamepad1.right_stick_y);
            robot.bLeft.setPower(-opModeObj.gamepad1.right_stick_y);
            robot.fRight.setPower(-opModeObj.gamepad1.right_stick_y);
            robot.bRight.setPower(-opModeObj.gamepad1.right_stick_y);
        } else {
            robot.fLeft.setPower(0);
            robot.bLeft.setPower(0);
            robot.fRight.setPower(0);
            robot.bRight.setPower(0);
        }
    }


    public void tank() {
        if (robot.isStrafing == false) {
            robot.fLeft.setPower(-opModeObj.gamepad1.left_stick_y / 2);
            robot.bLeft.setPower(-opModeObj.gamepad1.left_stick_y / 2);
            robot.fRight.setPower(-opModeObj.gamepad1.right_stick_y / 2);
            robot.bRight.setPower(-opModeObj.gamepad1.right_stick_y / 2);
        } else if ((opModeObj.gamepad1.right_trigger > 0.5) && (robot.isStrafing = false)) {
            robot.fLeft.setPower(-opModeObj.gamepad1.right_stick_y);
            robot.bLeft.setPower(-opModeObj.gamepad1.right_stick_y);
            robot.fRight.setPower(-opModeObj.gamepad1.right_stick_y);
            robot.bRight.setPower(-opModeObj.gamepad1.right_stick_y);
        } else {
            robot.fLeft.setPower(0);
            robot.bLeft.setPower(0);
            robot.fRight.setPower(0);
            robot.bRight.setPower(0);
        }

    }

    //carousel knockoff function with ramp up speed, chnages 25 times/sec
    public void cool() {
        if (opModeObj.gamepad2.x) {
            robot.P = 20;
        }
        while (robot.P < 50) {
            robot.carousel.setPower(robot.P / 100);
            robot.P = robot.P + 1;
            opModeObj.sleep(42);
        }

    }
        /* better version of cool, equipped with override
    public void cool2() {
        boolean robotisrunning = false;
        if ((robot.fLeft.getPower() > 0) || (robot.clawMotor.getPower() > 0) || (robot.armMotor.getPower() > 0)) {
            robotisrunning = false;
        } else {
            robotisrunning = true;
        }
        if (opModeObj.gamepad2.x) {
            robot.P = 20;
        }
        while ((robot.P < 50) && (robotisrunning = false)) {
            robot.carousel.setPower(robot.P / 100);
            robot.P = robot.P + 1;
            opModeObj.sleep(42);
        }
    }
    //better version of cool, allows movement while running with no override conditional needed, changes speed 1000 times/sec as opposed to roughly 25, yet to be tested
    //robot controlled run feature
    public void protocool() {
        double el = System.currentTimeMillis();
        if (opModeObj.(bind you want to use) {
            el = 0;
            robot.P = (starting power, will be divided by 100);
        }
        while (el < ((run time in milliseconds) * 1000)) {
            robot.(motor).setPower(robot.P / 100);
            robot.P = P + (finishing P - starting P) / ((run time in milliseconds) * 1000);
            pushin P up in increments determined by the time we have to increase to max power and how much it has to ramp up the power
        }   finishing P is the power you want the motor to end at, will be divided by 100

    }
    */



}