package Libraries;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Intake {

    private LinearOpMode opMode;

    private DcMotor intakeMotor;
    private DcMotor intakeSlide;

    private Servo intakeGate;



    public Intake (LinearOpMode opMode) {

        intakeMotor = opMode.hardwareMap.dcMotor.get("intakeMotor");
        intakeSlide = opMode.hardwareMap.dcMotor.get("intakeSpool");


        intakeGate = opMode.hardwareMap.servo.get("intakeGate");

    }

    public void moveSlides(long time, double power)
    {
        intakeSlide.setPower(power);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intakeSlide.setPower(0);
    }



    public void moveCollection(long time, double power) {

        //Forwards: +
        //Backwawrds: -
        intakeMotor.setPower(power);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intakeMotor.setPower(0);
    }

    public void spitOut(long time)
    {
        intakeMotor.setPower(-1.0);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intakeMotor.setPower(0.0);
    }



    public void setIntakeGate(double position)
    {
        intakeGate.setPosition(position);
    }


    public double getIntakeGatePosition()
    {
        return intakeGate.getPosition();
    }


}
