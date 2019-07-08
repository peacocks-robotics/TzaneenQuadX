package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Libraries.Drivetrain;
import Libraries.Intake;

@Autonomous(name = "PEACOCKS", group = "AutonomousRed")
public class PEACOCKS extends LinearOpMode {

    private Object inta;

    @Override
    public void runOpMode() {
        Drivetrain dt = new Drivetrain(this);
        Intake intake = new Intake(this);



        waitForStart();
        //AutoRed
        dt.setPower(.75, 1300);
        dt.turn(0.76, true, 600);
        intake.moveSlides(500,0.75);
        intake.moveCollection(75,-1.0);
        intake.moveSlides(-350,0.75);
        dt.setPower(0.75,750);
        dt.turn(0.5,true,400);
        dt.setPower(0.75,700);
        intake.moveCollection(75,-1.0);




    }



}
