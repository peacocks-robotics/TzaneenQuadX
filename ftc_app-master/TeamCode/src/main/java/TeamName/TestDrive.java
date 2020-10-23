package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "TestDrive",group ="Teleop")
public class TestDrive  extends LinearOpMode {

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;

      Servo  collect;

       @Override
        public void runOpMode() {

            fl = hardwareMap.dcMotor.get("fl");
            fr = hardwareMap.dcMotor.get("fr");
            bl = hardwareMap.dcMotor.get("bl");
            br = hardwareMap.dcMotor.get("br");
            collect = hardwareMap.servo.get("collect");

            fl.setDirection(DcMotorSimple.Direction.FORWARD);
            fr.setDirection(DcMotorSimple.Direction.FORWARD);
            bl.setDirection(DcMotorSimple.Direction.REVERSE);
            br.setDirection(DcMotorSimple.Direction.REVERSE);
        collect.setDirection(Servo.Direction.FORWARD);


        waitForStart();
        if (opModeIsActive()) {

            while (opModeIsActive()) {


                fl.setPower(-gamepad1.left_stick_y);
                fr.setPower(-gamepad1.left_stick_y);
                bl.setPower(gamepad1.left_stick_y);
                br.setPower(gamepad1.left_stick_y);

                if (gamepad1.a) ;
                {
                    collect.setPosition(0.0);

                }
                if (gamepad1.b) ;
                {
                    collect.setPosition(0.3);

                }


                telemetry.update();
            }
        }
    }
        }















