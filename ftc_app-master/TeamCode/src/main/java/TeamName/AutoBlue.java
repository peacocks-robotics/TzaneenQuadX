package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import Libraries.Drivetrain;
@Autonomous(name = "AutoBlue", group = "Autonomous")
public class AutoBlue extends LinearOpMode {

        @Override
    public void runOpMode() {
        Drivetrain dt = new Drivetrain(this);
        waitForStart();
        //AutoBlue
        dt.setPower(.75, 2000);
        dt.turn(0.75, true, 1000);
        dt.setPower(0.75,400);
        dt.stopMotors();

    }
}
