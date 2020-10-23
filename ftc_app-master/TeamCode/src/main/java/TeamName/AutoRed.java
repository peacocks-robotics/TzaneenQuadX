package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import Libraries.Drivetrain;
import Libraries.Intake;
import Libraries.Knocker;
import Libraries.Output;

@Autonomous(name = "AutoRed", group = "Autonomous")
public class AutoRed extends LinearOpMode {

    Drivetrain dt;
    Output output;
    Intake intake;
    Knocker knocker;

    @Override
    public void runOpMode() {
        dt = new Drivetrain(this);
        output= new Output(this);
        intake = new Intake(this);
        knocker = new Knocker(this);

        waitForStart();

        //AutoRed
        dt.setPower(.75, 1700);
        dt.turn(.5 , 500, true);
        dt.sleep(1000);
        dt.setPower(.75, 750);
        intake.spitOut(1500);
        dt.sleep(1300);
        dt.turn(.8, 500, false);
        dt.setPower(.75, 700);
        intake.moveCollection(1500,1);
        dt.setPower(-.75,1500);


    }



}
