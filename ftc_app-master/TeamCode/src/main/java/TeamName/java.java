package TeamName;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "java",group ="Teleop")
 public abstract class java extends LinearOpMode {


                  private DcMotor fl;
                  private DcMotor fr;
                  private DcMotor bl;
                  private DcMotor br;
                  private DcMotor intake1;
                  private DcMotor intake2;
                  private DcMotor slide;

          @Override

             public void runOpMode() {

          fl = hardwareMap.dcMotor.get("fl");
          fr = hardwareMap.dcMotor.get("fr");
          bl = hardwareMap.dcMotor.get("bl");
          br = hardwareMap.dcMotor.get("br");

                //front intake

          intake1 = hardwareMap.dcMotor.get("intake1");

                //middle intake
          intake2 = hardwareMap.dcMotor.get("intake2");

          slide = hardwareMap.dcMotor.get("slide");

                       //moving forward
              fl.setDirection(DcMotorSimple.Direction.FORWARD);
              fr.setDirection(DcMotorSimple.Direction.REVERSE);
              bl.setDirection(DcMotorSimple.Direction.REVERSE);
              br.setDirection(DcMotorSimple.Direction.FORWARD);

                  intake2.setDirection(DcMotorSimple.Direction.REVERSE);
                  intake1.setDirection(DcMotorSimple.Direction.REVERSE);

                  slide.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();
        if (opModeIsActive()) {

            while (opModeIsActive()) {
            }
        }
             //moving in left and right x-axis

         fl.setPower(-gamepad1.left_stick_y);
         fr.setPower(-gamepad1.left_stick_y);
         bl.setPower(gamepad1.left_stick_y);
         br.setPower(gamepad1.left_stick_y);


              //moving the intakes

          intake1.setPower(gamepad2.left_trigger);
          intake2.setPower(gamepad2.left_trigger);


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



            // moving slide

        slide .setPower(gamepad2.left_stick_y);

    }

    }

