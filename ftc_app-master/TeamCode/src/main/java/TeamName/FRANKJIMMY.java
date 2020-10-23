package TeamName;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



      @TeleOp(name = "FRANKJIMMY",group ="Teleop")

             public class FRANKJIMMY extends LinearOpMode {

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;
    //private DcMotor intake;
    //private DcMotor slide;
    //private DcMotor servo;




    @Override
    public void runOpMode() {

          fl = hardwareMap.dcMotor.get("fl");
          fr = hardwareMap.dcMotor.get("fr");
          bl = hardwareMap.dcMotor.get("bl");
          br = hardwareMap.dcMotor.get("br");
          //intake = hardwareMap.dcMotor.get("intake1");
          //slide = hardwareMap.dcMotor.get("slide");
          //servo = hardwareMap.dcMotor.get("servo");


        // Rotations for the Motors and Servos
          fl.setDirection(DcMotorSimple.Direction.FORWARD);
          fr.setDirection(DcMotorSimple.Direction.REVERSE);
          bl.setDirection(DcMotorSimple.Direction.FORWARD);
          br.setDirection(DcMotorSimple.Direction.REVERSE);
          //intake.setDirection(DcMotorSimple.Direction.REVERSE);
          //slide.setDirection(DcMotorSimple.Direction.FORWARD);
          //servo.setDirection(DcMotorSimple.Direction.FORWARD);


        waitForStart();
        if (opModeIsActive()) {

            while (opModeIsActive()) {
                //Moving forward and Backwards

                    fl.setPower(gamepad1.right_stick_y);
                    fr.setPower(gamepad1.right_stick_y);
                    bl.setPower(gamepad1.right_stick_y);
                    br.setPower(gamepad1.right_stick_y);

                // Turning Left and Right

                           fl.setPower(-gamepad1.right_stick_x);
                           bl.setPower(-gamepad1.right_stick_x);
                           fr.setPower(gamepad1.right_stick_x);
                           br.setPower(gamepad1.right_stick_x);

                //Sliding left and Right

                    fl.setPower(-gamepad1.left_stick_y);
                    fr.setPower(-gamepad1.left_stick_y);
                    bl.setPower(gamepad1.left_stick_y);
                    br.setPower(gamepad1.left_stick_y);

                //turning with front motors

                         fl.setPower(gamepad1.left_stick_x);
                         fr.setPower(-gamepad1.left_stick_x);

                             // Controlling Servo for Blocking the rings before shooting
                          //servo.setPower(gamepad1.right_trigger);

                             // Controlling Intake

                //intake.setPower(gamepad1.left_trigger);




            }
        }
    }
}