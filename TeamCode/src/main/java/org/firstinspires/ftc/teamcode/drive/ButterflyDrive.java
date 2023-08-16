package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drive.util.ButterflyDriveMode;

public class ButterflyDrive {
    private MecanumDrive mecanumDrive;
    private TankDrive tankDrive;
    Telemetry telemetry;

    private ButterflyDriveMode mode;

    public ButterflyDrive(HardwareMap hardwareMap, Telemetry telemetry, ButterflyDriveMode mode) {
        mecanumDrive = new MecanumDrive(hardwareMap);
        tankDrive = new TankDrive(hardwareMap);
        this.telemetry = telemetry;
        this.telemetry.addData("Drive Train Mode", mode.toString());
        this.telemetry.update();
        this.mode = mode;
    }

    // TODO: Implement
    public void busy() {
        telemetry.addData("Drive Train Available", "NOT BUSY");
        telemetry.update();
    }

    public void setMode(ButterflyDriveMode mode) {
        if (this.mode == mode) return;

        telemetry.addData("Drive Train Mode", mode.toString());
        telemetry.update();

        if(mode == ButterflyDriveMode.MECANUM) {
            // TODO: change servo pos

        }
        else {
            // TODO: change servo pos
        }
        this.mode = mode;
    }

    // Telemetry purposes
    public ButterflyDriveMode getMode() {
        return mode;
    }

    public void setPower(double x1, double y1, double x2, ButterflyDrive.Function<Double, Double> func) {
        if(mode == ButterflyDriveMode.MECANUM) {
            // TODO: Configure multiplier parameters
            tankDrive.setPowersByGamepad(y1, x2, func);

        }
        else {
            // TODO: Configure multiplier parameters
            mecanumDrive.setPowersByGamepad(x1, y1, x2, func);
        }
    }

    @FunctionalInterface
    public interface Function<T, R> {
        R applyMultiplier(T t);
    }

}
