package Libraries;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import TeamName.AutoBlue;

public class Drivetrain {

    private ElapsedTime ElapsedTime;
    private LinearOpMode opMode;
    private Gyro gyro;

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;

    public Drivetrain(LinearOpMode opMode) {
        this.opMode = opMode;

        ElapsedTime=new ElapsedTime();

        gyro = new Gyro(opMode, true);

        fl = opMode.hardwareMap.dcMotor.get("fl");
        fr = opMode.hardwareMap.dcMotor.get("fr");
        bl = opMode.hardwareMap.dcMotor.get("bl");
       br = opMode.hardwareMap.dcMotor.get("br");

        fl.setDirection(DcMotorSimple.Direction.FORWARD);
        fr.setDirection(DcMotorSimple.Direction.FORWARD);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
       br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

    }



    // ===================================  Utility Methods  =======================================

    public void resetEncoders() {
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        opMode.idle();
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        opMode.idle();
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        opMode.idle();
       br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        opMode.idle();

        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        opMode.idle();
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        opMode.idle();
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        opMode.idle();
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        opMode.idle();

    }

    public void setPower(double power) {
        fl.setPower(power);
        fr.setPower(power);
        bl.setPower(-power);
        br.setPower(-power);

    }

    public void setPower(double power, long time) {
        fl.setPower(power);
        bl.setPower(power);
        fr.setPower(-power);
        br.setPower(-power);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopMotors();
    }

    public void stopMotors() {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);

    }

    public void turn(double power, boolean right) {
        //turns right
        if (right) {
            fl.setPower(power);
            fr.setPower(-power);
            bl.setPower(power);
           br.setPower(-power);

        }

        //turns left
        else {
            fl.setPower(-power);
            fr.setPower(power);
            bl.setPower(-power);
           br.setPower(power);

        }

    }

    public void turn(double power, long time, boolean right) {
        if (!right) {
            fl.setPower(0.9);
            bl.setPower(0.9);
            fr.setPower(0.9);
            br.setPower(0.9);
        } else {
            fl.setPower(0.9);
            bl.setPower(0.9);
            fr.setPower(0.9);
           br.setPower(0.9);
        }

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopMotors();
    }

    public void sleep(long time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void strafe(double power, boolean right) {
        if (right) {
            fl.setPower(-0.9);
            fr.setPower(0.9);
            bl.setPower(0.9);
           br.setPower(-0.9);

        }
        else {
            fl.setPower(0.9);
            fr.setPower(-0.9);
            bl.setPower(-0.9);
            br.setPower(0.9);

        }

    }

    public void diagonal(double power, boolean right, boolean forward) {
        if (right && forward) {
            fl.setPower(0.9);
           br.setPower(0.9);

        }
        else if (!right && forward){
            fr.setPower(0.9);
            bl.setPower(0.9);

        }
        else if (right) {
            fr.setPower(-0.9);
            bl.setPower(-0.9);

        }
        else {
            fl.setPower(-0.9);
           br.setPower(-0.9);

        }

    }


    // =======================================  Encoder  ===========================================

    public double getEncoderAvg() {
        double countZeros = 0;

        if (fl.getCurrentPosition() == 0) {
            countZeros++;
        }
        if (fr.getCurrentPosition() == 0) {
            countZeros++;
        }
        if (bl.getCurrentPosition() == 0) {
            countZeros++;
        }
        if (br.getCurrentPosition() == 0) {
            countZeros++;
        }

        if (countZeros == 4) {
          return 0;
        }

       return (Math.abs(fl.getCurrentPosition()) +
                Math.abs(fr.getCurrentPosition()) +
               Math.abs(bl.getCurrentPosition()) +
               Math.abs(br.getCurrentPosition())) / (4 - countZeros);

    }

    public void moveEncoder(double power, double distance, double timeout) {
        ElapsedTime time = new ElapsedTime();

        resetEncoders();
        time.reset();

        while (getEncoderAvg() < distance && time.seconds() < timeout && opMode.opModeIsActive()) {
            setPower(power);

        }
        stopMotors();

    }

    public void strafeEncoder(double power, double distance, boolean right, double timeout) {
        ElapsedTime time = new ElapsedTime();

        resetEncoders();
        time.reset();

        while (getEncoderAvg() < distance && time.seconds() < timeout && opMode.opModeIsActive()) {
            strafe(power, right);

        }
        stopMotors();

    }

    public void diagonalEncoder(double power, double distance, boolean right, boolean forward, double timeout) {
        ElapsedTime time = new ElapsedTime();

        resetEncoders();
        time.reset();

        while (getEncoderAvg() < distance && time.seconds() < timeout && opMode.opModeIsActive()) {
            diagonal(power, right, forward);

        }
        stopMotors();

    }

    // =========================================  PID  =============================================

    public void turnPID(double kP, double kI, double kD, double angle, boolean right, double timeout) {
        ElapsedTime time = new ElapsedTime();

        time.reset();

        double initialAngle = gyro.getGyroYaw();

        double error;
        double power;

        double proportional;
        double integral = 0;
        double derivative;

        double previousTime;
        double previousError = angle - Math.abs(gyro.getGyroYaw() - initialAngle);

        while (Math.abs(gyro.getGyroYaw() - (angle + initialAngle)) > 1 && time.seconds() < timeout) {
            error = angle - Math.abs(gyro.getGyroYaw() - initialAngle);

            previousTime = time.seconds();

            proportional = error * kP;
            integral += error * (time.seconds() - previousTime) * kI;
            derivative = ((error - previousError) / (time.seconds() - previousTime)) * kD;

            power = proportional + integral + derivative;

            turn(power, right);

            opMode.telemetry.addData("power", power);
            opMode.telemetry.addData("error", error);
            opMode.telemetry.addData("proportional", proportional);
            opMode.telemetry.addData("integral", integral);
            opMode.telemetry.addData("derivative", derivative);

            previousError = error;

            opMode.idle();


        }
        stopMotors();

    }

}
