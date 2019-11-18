package statusmgr;

public class MemoryDetailDecorator extends DetailedStatusControllerDecorator {
    public MemoryDetailDecorator(AbstractStatus detailedStatusControllerToBeDecorated) {
        super(detailedStatusControllerToBeDecorated);
    }

    @Override
    public String getCurrentServerStatus() {
        return super.getCurrentServerStatus() + ", and its memory is Running low";
    }
}