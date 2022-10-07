package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.drivetrain.DriveBase;

public class Auto extends ParallelCommandGroup {

    public Auto(DriveBase drive) {
        addCommands(new DriveStraight(drive, 0.25));
    }

}
