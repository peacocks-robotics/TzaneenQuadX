package TeamName;

    
import android.graphics.Bitmap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.Frame;
import com.vuforia.Image;
import com.vuforia.PIXEL_FORMAT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.Parameters;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;


    public class Vision{

        private LinearOpMode opMode;

        private VuforiaLocalizer vuforia;

        private final int RED_THRESHOLD = 140;
        private final int GREEN_THRESHOLD = 100;
        private final int BLUE_THRESHOLD = 60;

        public Vision(LinearOpMode opMode) {
            this.opMode = opMode;

            int cameraMonitorViewId = opMode.hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", opMode.hardwareMap.appContext.getPackageName());

            VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
            parameters.vuforiaLicenseKey = "AcD8BwX/////AAABmQfyyiD3b0tXiwsm/UX+fHkiPPZJQu55dY7HGrCBT84yc2dP8K+9mWY/3l3gcOKEmSvG+xB9UTPZRTzLqONEuj4hrYpRZtfz6wDkC4IWUvxdgh3+On8UHBaue+CJveRpqla8XZtgMJUqzE3Mxt4QBk3SFkh815rM08JJ11a4XsZrxD4ZDVI6XcsrBmWFub8E/+weoU5gweajvJcE5tzVyLn7IaaYyshx9CHJdS0ObM29e3tHbVJjpwsU/zuoEEoXNRUL++LR0j8z6KY7WQvnsf0PyZXIpu6/tvFR1/WMn74Rc7IkWdO3sdiRQL3i96/rhOeAvQfjlg1VJhEyWKXqqLfQSJrOQSCKegayB4KFCXZf";
            parameters.cameraName = opMode.hardwareMap.get(WebcamName.class, "Webcam 1");
            vuforia = ClassFactory.getInstance().createVuforia(parameters);
            Vuforia.setFrameFormat(PIXEL_FORMAT.RGB565, true);
            vuforia.setFrameQueueCapacity(4);
        }

        public Bitmap getBitmap() throws InterruptedException{
            VuforiaLocalizer.CloseableFrame frame = vuforia.getFrameQueue().take();
            Image rgb = frame.getImage(1);

            long numImages = frame.getNumImages();

            for (int i = 0; i < numImages; i++) {
                int fmt = frame.getImage(i).getFormat();

                if (fmt == PIXEL_FORMAT.RGB565) {
                    rgb = frame.getImage(i);
                    break;

                }
                else {
                    opMode.telemetry.addLine("Didn't find correct rgb format");
                    opMode.telemetry.update();

                }

            }

            Bitmap bm = Bitmap.createBitmap(rgb.getWidth(), rgb.getHeight(), Bitmap.Config.RGB_565);
            bm.copyPixelsFromBuffer(rgb.getPixels());

            frame.close();

            opMode.telemetry.addLine("Got Bitmap");
            opMode.telemetry.update();

            opMode.sleep(500);

            return bm;
        }

        public String sample() throws InterruptedException{
            Bitmap bitmap = getBitmap();
            ArrayList<Integer> yValues = new ArrayList<>();

            int avgY = 0;

            //top left = (0,0)
            for (int colNum = 0; colNum < bitmap.getWidth(); colNum ++) {

                for (int rowNum = 140 ; rowNum < 256; rowNum ++) {
                    int pixel = bitmap.getPixel(colNum, rowNum);

                    int redPixel = red(pixel);
                    int greenPixel = green(pixel);
                    int bluePixel = blue(pixel);

                    if (redPixel >= RED_THRESHOLD && greenPixel >= GREEN_THRESHOLD && bluePixel <= BLUE_THRESHOLD) {
                        yValues.add(rowNum);

                    }

                }

            }

            for (int y : yValues) {
                avgY+= y;

            }

            opMode.telemetry.addData("Num Pixels found", yValues.size());
            opMode.telemetry.update();

            try {
                avgY /= yValues.size();
            } catch (ArithmeticException E){
                return  "right";

            }

            opMode.telemetry.addData("avgY = ", avgY);
            opMode.telemetry.update();

            if (avgY < 300) {
                return "left";

            }
            else if (avgY < 550) {
                return "center";

            }
            else {
                return "right";

            }

        }

    }
 
