package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import Libraries.Drivetrain;
import Libraries.Intake;
import Libraries.Output;

@Autonomous(name = "AutoRed", group = "AutonomousRed")
public class AutoRed extends LinearOpMode {

    private Object inta;

    @Override
    public void runOpMode() {
        Drivetrain dt = new Drivetrain(this);
        Intake intake = new Intake(this);



        waitForStart();
        //AutoRed
        dt.setPower(.75, 2000);
        dt.turn(.9, true, 1000);

        intake.moveSlides(500,0.75);



    }



}
