package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Libraries.Drivetrain;
@Autonomous(name = "test", group = "Autonomous")
public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() {
        Drivetrain dt = new Drivetrain(this);
        waitForStart();
        dt.setPower(.75, 2000);

        dt.turn(.9, true, 1000);
    }
}
