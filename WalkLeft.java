package command;


public class WalkLeft implements Command {
   private Cave theCave;

   public WalkLeft(Cave cave) {
      this.theCave = cave;
   }

   @Override    // Command
   public void execute() {
      theCave.walkLeft();
   }
}