package command;


public class WalkBack implements Command {
   private Cave theCave;

   public WalkBack(Cave cave) {
      this.theCave = cave;
   }

   @Override    // Command
   public void execute() {
      theCave.walkBack();
   }
}