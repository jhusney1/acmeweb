package statusmgr;

public class ExtentionsDetailDecorator extends DetailedStatusControllerDecorator {
    public ExtentionsDetailDecorator(AbstractStatus detailedStatusControllerToBeDecorated) {
        super(detailedStatusControllerToBeDecorated);
    }

    @Override
    public String getCurrentServerStatus() {
        return super.getCurrentServerStatus() + ", and is using these extensions - [Hypervisor, Kubernetes, RAID-6]";
    }
}
