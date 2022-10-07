package frc.robot.oi;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class XeniteControls implements UserControls {

    private final XboxController xanderController;

    public XeniteControls(int xanderController) {
        this.xanderController = new XboxController(xanderController);
    }

    @Override
    public double getLeftDriveX() {
        return xanderController.getLeftX();
    }

    @Override
    public double getLeftDriveY() {
        return xanderController.getLeftY();
    }

    @Override
    public double getRightDriveX() {
        return xanderController.getRightX();
    }

    @Override
    public double getRightDriveY() {
        return xanderController.getRightY();
    }

    @Override
    public Trigger ClimbUpButton() {
        return new Trigger(() -> xanderController.getPOV() == 0);
    }

    @Override
    public Trigger ClimbDownButton() {
        return new Trigger(() -> xanderController.getPOV() == 180);
    }

    @Override
    public Trigger ClimbLeftButton() {
        return new Trigger(() -> xanderController.getPOV() == 90);
    }

    @Override
    public Trigger ClimbRightButton() {
        return new Trigger(() -> xanderController.getPOV() == 270);
    }

    // @Override
    // public Trigger getIntakeRunInButton() {
    //     return new Trigger(() -> rightDriverJoystick.getRawButton(3));
    // }

    // @Override
    // public Trigger getIntakeRunOutButton() {
    //     return new Trigger(() -> leftDriverJoystick.getRawButton(3));
    // }
}
