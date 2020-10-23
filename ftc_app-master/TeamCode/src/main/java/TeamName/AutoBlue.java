package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import Libraries.Drivetrain;
import Libraries.Knocker;
import Libraries.Output;
import Libraries.Intake;
@Autonomous(name = "AutoBlue", group = "Autonomous")
public class AutoBlue extends LinearOpMode {

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

        //AutoBlue
        dt.setPower(.75, 1700);
        dt.turn(.5 , 600, false);
        dt.sleep(1000);
        dt.setPower(.75, 750);
        intake.spitOut(1500);
        dt.sleep(1300);
        dt.turn(.8, 500, true);
        dt.setPower(.75, 700);
        intake.moveCollection(1500,1);
        dt.setPower(-.75,1500);

    }



}
