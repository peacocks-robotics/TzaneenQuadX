package TeamName;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import Libraries.Drivetrain;

@Autonomous(name ="kasinerds", group = "Autonomous")
public class kasinerds extends LinearOpMode {

    Drivetrain dt;


    @Override
    public void runOpMode() {
        dt = new Drivetrain(this);


        waitForStart();

        dt.setPower(.75, 2000);
        dt.sleep(1000);
        dt.turn(.75,900,true);






    }
}
