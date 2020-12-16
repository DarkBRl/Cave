package command;


public class WalkFoward implements Command {
   private Cave theCave;

   public WalkFoward(Cave cave) {
      this.theCave = cave;
   }

   @Override    // Command
   public void execute() {
      theCave.walkFoward();
   }
}