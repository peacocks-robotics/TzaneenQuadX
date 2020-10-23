package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@TeleOp(name = "Twomotors",group ="Teleop")
public class Twomotors extends LinearOpMode {

    private DcMotor fl;
    private DcMotor fr;


    @Override
    public void runOpMode() {

        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");



        fl.setDirection(DcMotorSimple.Direction.FORWARD);
        fr.setDirection(DcMotorSimple.Direction.FORWARD);



        waitForStart();
        if (opModeIsActive()) {

            while (opModeIsActive()) {


                fl.setPower(gamepad1.left_stick_y);
                fr.setPower(gamepad1.left_stick_y);

            }
        }
    }
}


