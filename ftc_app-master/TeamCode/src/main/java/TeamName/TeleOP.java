package TeamName;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@TeleOp(name = "Teleop",group ="Teleop")
public class Teleop extends LinearOpMode {

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;


    @Override
    public void runOpMode() {

        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br =hardwareMap.dcMotor.get("br");



        fl.setDirection(DcMotorSimple.Direction.FORWARD);
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.FORWARD);
        br.setDirection(DcMotorSimple.Direction.REVERSE);



        waitForStart();
        if (opModeIsActive()) {

             bl.setPower(gamepad1.right_stick_y);
            br.setPower(gamepad1.right_stick_y);


                         bl.setPower(gamepad1.left_stick_x);
                          fr.setPower(gamepad1.left_stick_x);

            fl.setPower(gamepad1.right_trigger);
            bl.setPower(gamepad1.right_trigger);
            fr.setPower(gamepad1.left_trigger);
            fl.setPower(gamepad1.left_trigger);


        }
    }
}


