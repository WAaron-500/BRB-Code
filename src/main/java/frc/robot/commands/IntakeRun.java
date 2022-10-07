package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.Intake;

public class IntakeRun extends CommandBase {

    private final Intake intake;
    private final Supplier<Double> speedSupplier;

    public IntakeRun(Intake intake, Supplier<Double> speedSupplier) {

        this.intake = intake;
        this.speedSupplier = speedSupplier;

        speedSupplier.get();

        addRequirements(intake);

    }

    @Override
    public void execute() {
        double speed = speedSupplier.get();
        intake.runIntakeVelocity(speed);
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
