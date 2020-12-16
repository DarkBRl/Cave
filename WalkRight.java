package command;


public class WalkRight implements Command {
   private Cave theCave;

   public WalkRight(Cave cave) {
      this.theCave = cave;
   }

   @Override    // Command
   public void execute() {
      theCave.walkRight();
   }
}