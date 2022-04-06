
    package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

    class  hardWareMap {

        HardwareMap hwMap = null;

        ElapsedTime runtime = new ElapsedTime();

       // public RevBlinkinLedDriver led;
        double P = 76;
       // public ColorSensor sensorColor = null;

        public boolean isStrafing = false;

        public DistanceSensor sensorDistance = null;

        public DistanceSensor capDistance = null;

        public DcMotor armMotor = null;

        public Servo clawServo2 = null;

        public Servo clawServo1 = null;

        public DcMotor fLeft = null;

        public DcMotor fRight = null;

        public DcMotor bLeft = null;

        public DcMotor bRight = null;

        public DcMotor carousel = null;

        public DcMotor clawMotor = null;

      //  public DcMotor touchSensor = null;

        //   public DcMotor  intake = null;

        //  public DcMotor knockDown = null;

        //  public DcMotor sh00ter_left = null;

        //  public DcMotor sh00ter_right = null;

        // public Servo knockDown = null;


        /* Constructor */

        public hardWareMap(){

        }
        protected enum DisplayKind {
            MANUAL,
            AUTO
        }

        public void init(HardwareMap ahwMap) {

            hwMap = ahwMap;

            //   knockDown = hwMap.get(Servo.class, "knockDown");

           // sensorColor = hwMap.get(ColorSensor.class, "colorTest");
            carousel = hwMap.get(DcMotor.class, "carouselMotor");

            clawServo1 = hwMap.get(Servo.class, "clawServo1");

            clawServo2 = hwMap.get(Servo.class, "clawServo2");

            armMotor= hwMap.get(DcMotor.class, "armMotor");

            fLeft = hwMap.get(DcMotor.class, "fLeftMotor");

            fRight = hwMap.get(DcMotor.class, "fRightMotor");

            bLeft = hwMap.get(DcMotor.class, "bLeftMotor");

            bRight = hwMap.get(DcMotor.class, "bRightMotor");

            sensorDistance = hwMap.get(DistanceSensor.class, "carouselDistance");

            capDistance = hwMap.get(DistanceSensor.class, "capDistance");


            clawMotor = hwMap.get(DcMotor.class, "clawMotor");


            //led = hwMap.get(RevBlinkinLedDriver.class, "LEDsystem");

          //  knockDown = hwMap.get(DcMotor.class, "knockDown");

            // intakeSystem = hwMap.get(DcMotor.class, "intakeSystem");

            //  sh00ter_left = hwMap.get(DcMotor.class, "sh00ter_left");

            //  sh00ter_right = hwMap.get(DcMotor.class, "sh00ter_right");

            //   intakeSystem.setDirection(DcMotor.Direction.REVERSE);

           // knockDown.setDirection(DcMotor.Direction.FORWARD);

           bRight.setDirection(DcMotor.Direction.FORWARD);

           bLeft.setDirection(DcMotor.Direction.REVERSE);

           fRight.setDirection(DcMotor.Direction.FORWARD);

           fLeft.setDirection(DcMotor.Direction.REVERSE);

           // bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

           // bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

           // fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

           // fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sh00ter_right.setDirection(DcMotor.Direction.REVERSE);

            //  sh00ter_left.setDirection(DcMotor.Direction.REVERSE);

            //  sh00ter_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            // sh00ter_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            armMotor.setPower(0);

            fLeft.setPower(0);

            fRight.setPower(0);

            bLeft.setPower(0);

            bRight.setPower(0);

            carousel.setPower(0);

            //  knockDown.setPower(0);



            //   sh00ter_right.setPower(0);

            //  sh00ter_left.setPower(0);

            //  intakeSystem.setPower(0);
        }
    }
