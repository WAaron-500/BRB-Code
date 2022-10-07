// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Auto;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberUp;
import frc.robot.commands.IntakeRun;
import frc.robot.oi.MatthewControls;
import frc.robot.oi.UserControls;
import frc.robot.subsystems.climber.Climber;
import frc.robot.subsystems.climber.ClimberIO;
import frc.robot.subsystems.climber.ClimberIOBRB;
import frc.robot.subsystems.drivetrain.DriveBase;
import frc.robot.subsystems.drivetrain.DriveIO;
import frc.robot.subsystems.drivetrain.DriveIOBRB;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.IntakeIO;
import frc.robot.subsystems.intake.IntakeIOBRB;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private DriveBase driveBase;
    private Intake intake;
    private Climber climb;

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        // Configure the button bindings
        configureSubsystems();
        configureButtonBindings();
    }

    private void configureSubsystems() {
        this.driveBase = new DriveBase(new DriveIOBRB());
        this.intake = new Intake(new IntakeIOBRB());
        this.climb = new Climber(new ClimberIOBRB());

        //fail safes because they are pretty
        driveBase = driveBase != null ? driveBase : new DriveBase(new DriveIO() {
        });
        intake = intake != null ? intake : new Intake(new IntakeIO() {
        });
        climb = climb != null ? climb : new Climber(new ClimberIO() {
        });
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // UserControls controls = new XeniteControls(0);
        UserControls controls = new MatthewControls(0, 1);

        //defining commands
        ArcadeDrive defaultDriveCommand = new ArcadeDrive(driveBase,
                () -> controls.getLeftDriveX(),
                () -> controls.getLeftDriveY(),
                () -> controls.getRightDriveX(),
                () -> controls.getRightDriveY());

        IntakeRun intakeInCommand = new IntakeRun(intake, () -> 1.0);
        IntakeRun intakeOutCommand = new IntakeRun(intake, () -> -1.0);

        // ClimberUpBitch climberUpCommand = new ClimberUpBitch(climb, 0.3);
        // ClimberUpBitch climberDownCommand = new ClimberUpBitch(climb, -0.3);
        // ClimberDownBitch climberLeftCommand = new ClimberDownBitch(climb, 0.3);
        // ClimberDownBitch climberRightCommand = new ClimberDownBitch(climb, -0.3);

        ClimberUp climberUpCommand = new ClimberUp(climb, 0.7);
        ClimberDown climberDownCommand = new ClimberDown(climb, 0.7);

        //controller commands
        controls.getIntakeRunInButton().whileActiveOnce(intakeInCommand);
        controls.getIntakeRunOutButton().whileActiveOnce(intakeOutCommand);
        controls.ClimbUpButton().whileActiveOnce(climberUpCommand);
        controls.ClimbDownButton().whileActiveOnce(climberDownCommand);
        // controls.ClimbLeftButton().whileActiveOnce(climberLeftCommand);
        // controls.ClimbRightButton().whileActiveOnce(climberRightCommand);

        //default commands
        driveBase.setDefaultCommand(defaultDriveCommand);
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return new Auto(driveBase);
    }
}
